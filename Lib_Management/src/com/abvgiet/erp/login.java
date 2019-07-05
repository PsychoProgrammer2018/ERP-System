package com.abvgiet.erp;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res) {
		String Id=req.getParameter("Id");
        String Password=req.getParameter("Password");
        dbm obj=new dbm() {
	   public void qry() {
		  
		   query="Select s_name,s_password from Signup where roll_no='"+Id+"'";
		 try {  
			 st=con.createStatement();
			 
			rs= st.executeQuery(query);
			
			rs.next();
			String Name=rs.getString(1);
			String Pass=rs.getString(2);
			
			if(Pass.equals(Password))
				{
				
				HttpSession session =req.getSession();
				//session.setAttribute("Name",Name);
				//session.setAttribute("Id", Id);
				/*Cookie cookie[]=req.getCookies();
                for(Cookie c:cookie)
                c.setMaxAge(0);
                for(Cookie c:cookie) {
                    System.out.println(c.getValue());}*/
				//String s[]=Name.split(" ",3);
			//	for( String nm:s) {
			//	res.addCookie(new Cookie(nm,nm));
				//}
				Cookie cookie3=new Cookie("Name",Name);
				Cookie cookie1=new Cookie("Id",Id);
				cookie3.setMaxAge(60*60*24*365);
				cookie1.setMaxAge(60*60*24*365);
				res.addCookie(cookie3);
				res.addCookie(cookie1);
				
				}		
				
				}
			 
	   catch(SQLException e) {
		try{
			res.getWriter().print("User Id Does Not Exist");
			return;
		}catch(IOException ex) {
			System.out.println(ex);
		}
		}
	   }
		 
};		
	obj.connect();
	obj.qry();
	obj.close();
	}
}
