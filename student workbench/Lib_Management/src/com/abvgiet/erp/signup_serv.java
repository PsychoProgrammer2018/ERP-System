package com.abvgiet.erp;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/signup")
public class signup_serv extends HttpServlet{
	long Phone=0l;
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
	res.setContentType("text/plain");
	String Name=req.getParameter("Name");
	String Id=req.getParameter("Roll_No");
	String Email=req.getParameter("Email");
	
	try {
		
	Phone=Long.parseLong(req.getParameter("Phone"));}
	catch(NumberFormatException e) {
		res.getWriter().print("Invalid Phone Number");
		return;
	}
	String Password=req.getParameter("Password");
	String Branch=req.getParameter("Branch");
	dbm obj=new dbm() {
	public void qry() {
			query="insert into Signup value(?,?,?,?,?,?)";
			try {
				ps=con.prepareStatement(query);
				ps.setString(1, Id);
				ps.setString(2, Name);
				ps.setString(3, Email);
				ps.setLong(4,Phone);
				ps.setString(5,Branch);
				ps.setString(6,Password);
				ps.executeUpdate();
			    res.getWriter().print("User Added Successfully");
			    return;
			    
			} catch (SQLException e) {
			try {
				res.getWriter().print("User Already Exist");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	};
	obj.connect();
	obj.qry();
	obj.close();
	
}
}
