package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;


@WebServlet("/newCandidate")
public class NewCandidateServlet extends HttpServlet {

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
		String candidateName = req.getParameter("candname");
		String party = req.getParameter("party");
		try(CandidateDao candDao = new CandidateDaoImpl())
		{
			Candidate cand = new Candidate(0,candidateName, party, 0);
			int newCand = candDao.save(cand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		String bgcolor = app.getInitParameter("background-color");
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Info</title>");
		out.println("</head>");
		out.printf("<body style='background-color: %s'>", bgcolor);
		out.printf("<h1>%s</h1>", appTitle);
		out.println("<h3>Candidate successfully created!!");
		out.println("</body>");
		out.println("</html>");		
	}
}
