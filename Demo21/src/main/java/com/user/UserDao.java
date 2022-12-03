package com.user;

import java.util.*;  
import java.sql.*;  
  
public class UserDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/information","root","root");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(User e){  
        int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into user(ID,username,password,type) values (?,?,?,?)");
            ps.setString(1,e.getId());
            ps.setString(2,e.getUsername());  
            ps.setString(3,e.getPassword());
            ps.setString(4,e.getType());
           
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
}
//    public static int update(Emp e){  
//        int status=0;  
//        try{  
//            Connection con=EmpDao.getConnection();  
//            PreparedStatement ps=con.prepareStatement(  
//                         "update userdetails set name=?,password=? where id=?");  
//            ps.setString(1,e.getName());  
//            ps.setString(2,e.getPassword());  
//           
//            ps.setInt(3,e.getId());  
//              
//            status=ps.executeUpdate();  
//              
//            con.close();  
//        }catch(Exception ex){ex.printStackTrace();}  
//          
//        return status;  
//    }  
//    public static int delete(int id){  
//        int status=0;  
//        try{  
//            Connection con=EmpDao.getConnection();  
//            PreparedStatement ps=con.prepareStatement("delete from userdetails where id=?");  
//            ps.setInt(1,id);  
//            status=ps.executeUpdate();  
//              
//            con.close();  
//        }catch(Exception e){e.printStackTrace();}  
//          
//        return status;  
//    }  
//    public static Emp getEmployeeById(int id){  
//        Emp e=new Emp();  
//          
//        try{  
//            Connection con=EmpDao.getConnection();  
//            PreparedStatement ps=con.prepareStatement("select * from userdetails where name=?");  
//            ps.setInt(1,id);  
//            ResultSet rs=ps.executeQuery();  
//            if(rs.next()){  
//                e.setId(rs.getInt(1));  
//                e.setName(rs.getString(2));  
//                e.setPassword(rs.getString(3));  
//                 
//            }  
//            con.close();  
//        }catch(Exception ex){ex.printStackTrace();}  
//          
//        return e;  
//    }  
//    public static List<Emp> getAllEmployees(){  
//        List<Emp> list=new ArrayList<Emp>();  
//          
//        try{  
//            Connection con=EmpDao.getConnection();  
//            PreparedStatement ps=con.prepareStatement("select * from userdetails");  
//            ResultSet rs=ps.executeQuery();  
//            while(rs.next()){  
//                Emp e=new Emp();  
//                e.setId(rs.getInt(1));  
//                e.setName(rs.getString(2));  
//                e.setPassword(rs.getString(3));  
//                 
//                list.add(e);  
//            }  
//            con.close();  
//        }catch(Exception e){e.printStackTrace();}  
//          
//        return list;  
//    }  
//}  
