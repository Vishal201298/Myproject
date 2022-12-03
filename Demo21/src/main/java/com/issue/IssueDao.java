package com.issue;

import java.util.*;



import java.sql.*;  
  
public class IssueDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/information","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Issue e){  
        int status1=0;  
        try{  
            Connection con=IssueDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into issue(ID,discription,user_id,status) values (?,?,?,?)");  
            ps.setString(1,e.getId());
            ps.setString(2,e.getDiscription());  
            ps.setString(3,e.getUserid());
            ps.setString(4,e.getStatus());
           
              
            status1=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status1;  
    }  
    
    
    public static int update(Issue e){  
        int status1=0;  
        try{  
            Connection con=IssueDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update issue set  discription=?,user_id=?, status=? where ID=? ");  
            ps.setString(1,e.getDiscription());  
            ps.setString(2,e.getUserid());
            ps.setString(3,e.getStatus());  
           
            ps.setString(4,e.getId());  
              
            status1=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status1;  
    }  
    public static int delete(int id){  
        int status1=0;  
        try{  
            Connection con=IssueDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from issue where ID=?");  
            ps.setInt(1,id);  
            status1=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status1;  
    }  
    public static Issue getIssueById(int id){  
        Issue e=new Issue();  
          
        try{  
            Connection con=IssueDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from issue where discription=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getString(1));  
                e.setDiscription(rs.getString(2));  
                e.setStatus(rs.getString(3));  
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Issue> getAllIssues(){  
        List<Issue> list=new ArrayList<Issue>();  
          
        try{  
            Connection con=IssueDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from issue");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Issue e=new Issue();  
                e.setId(rs.getString(1));  
                e.setDiscription(rs.getString(2)); 
                e.setUserid(rs.getString(3));
                e.setStatus(rs.getString(4));  
                 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
