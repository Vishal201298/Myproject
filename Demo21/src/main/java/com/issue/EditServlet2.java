package com.issue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String id=request.getParameter("id");  
	      //  String id=String.substring(sid);  
	        String discription=request.getParameter("discription");  
	        String userid=request.getParameter("userid");
	        String Status=request.getParameter("status");  
	       
	          
	        Issue e=new Issue();  
	        e.setId(id);  
	        e.setDiscription(discription); 
	        e.setUserid(userid);
	        e.setStatus(Status);  
	        
	          
	        int status=IssueDao.update(e);  
	        if(status>0){  
	            response.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	}

}