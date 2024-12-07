	package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String candId = req.getParameter("candidate");
		int id = Integer.parseInt(candId);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		

		String bgcolor = app.getInitParameter("background-color");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		out.printf("<body style='background-color: %s'>", bgcolor);
		out.printf("<h1>%s</h1>", appTitle);
		


		Cookie[] arr = req.getCookies();
		String userName = "", role = "";
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname"))
					userName = c.getValue();
				if(c.getName().equals("role"))
					role = c.getValue();
			}
		}
		
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);
		out.println("<h2>Voting Status</h2>");
				
		HttpSession session = req.getSession(false);
		if(session == null) 
		{
			resp.sendError(440);
			return;
		}
		
		User user = (User) session.getAttribute("curUser");
		if(user.getStatus() == 0)
		{
			try(CandidateDao candDao = new CandidateDaoImpl())
			{
				int count = candDao.incrVote(id);
				if(count == 1)
				{
					out.println("<h4>You have successfully casted your vote.</h4>");
					user.setStatus(1);					
					try(UserDao userDao = new UserDaoImpl())
					{
						count = userDao.update(user);
						if(count == 1)
							out.println("You have casted your voted");
					}
				}	
				else
					out.println("<h4>Your voting failed.</h4>");	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}			
		}
		else 
		{
			out.println("<h4>You have already voted.</h4>");
		}
		
		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}