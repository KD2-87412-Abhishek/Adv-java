package assign01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
public class ProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); response.getWriter().println("<html><body bgcolor='pink'>");
		response.getWriter().println("<h2>Profile Information</h2>"); 
		response.getWriter().println("<p>First Name: John</p>");
		response.getWriter().println("<p>Last Name: Doe</p>"); 
		response.getWriter().println("<p>Qualification: Electronics Science</p>");
		response.getWriter().println("<p>College/University: Smvit University</p>");
		response.getWriter().println("<p>Birth Date: December 1, 1990</p>"); 
		response.getWriter().println("</body></html>");
		
	} }
