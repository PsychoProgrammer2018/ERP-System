package com.abvgiet.erp;
import javax.servlet.http.*;
public class validation extends HttpServlet{
	String Id,Password;
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		Cookie[] cookie=req.getCookies();
	    for(Cookie c :cookie) {
	    	//if(c.getName().equals("Name"))
	    }
		
	}
}
