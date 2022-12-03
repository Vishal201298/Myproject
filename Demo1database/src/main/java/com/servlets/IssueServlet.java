package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.IssuesDAO;

/**
 * Servlet implementation class IssueServlet
 */
@WebServlet("/Issueservlet")
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IssuesDAO issueDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		
//		String id= request.getParameter("id");
//		String description= request.getParameter("description");
//		String userId= request.getParameter("userid");
//		String status= request.getParameter("status");
//		doGet(request, response);
		
		try {
			List<Map<String, Object>> issueList = issueDao.getAllIssue();
		
        response.setContentType("text/html");
           PrintWriter pw = response.getWriter();
           response.getWriter().print("<table border='1'>");
           issueList.forEach(employee -> {
               pw.print("<tr>");
               employee.forEach((k,v) ->{
                   pw.print("<td>" + v.toString() + "</td>" );
                   
               });
               pw.print("</tr>");
           });
           response.getWriter().print("</table>");
           
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		issueDao=new IssuesDAO();
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		 
		

	}
}
