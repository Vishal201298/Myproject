package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.IssuesDAO;





/**
* Servlet implementation class Loginservlet
*/
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID1=1L;
	private IssuesDAO issuedao;
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		issuedao=new IssuesDAO();
	}



	private static final long serialVersionUID = 1L;
       
    /**getaWriter
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }



   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out=response.getWriter();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/information ","root","root");
            String n=request.getParameter("username");
            String p=request.getParameter("password");
            
            PreparedStatement ps= con.prepareStatement("select username from login where username=? and password=?");
            ps.setString(1,n);
            ps.setString(2, p);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()) {
                System.out.println(rs.getString(1));
                RequestDispatcher rd=request.getRequestDispatcher("Registerissue.html");
                rd.forward(request, response);
//            	 response.getWriter().append("<h2>Issue DashBoard</h2>");
//            	List<Map<String, Object>> issueList=issuedao.getAllIssue();
//                response.setContentType("text/html");
//                   PrintWriter pw = response.getWriter();
//                   response.getWriter().print("<table border='1'>");
//                   issueList.forEach(employee -> {
//                       pw.print("<tr>");
//                       employee.forEach((k,v) ->{
//                           pw.print("<td>" + v.toString() + "</td>" );
//                           
//                       });
//                       pw.print("</tr>");
//                   });
//                   response.getWriter().print("</table>");
//                   response.getWriter().append("<a href=\"Home.html\">Logout </a>");
           } else {
               out.print("<font color=black size=4>Login Unsuccessful!<br>");
               out.println("<a href=login.html>Try Again");
           }
            	
            
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }



}