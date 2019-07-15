<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="mainstyle/pages1.css">
        <title></title>
    </head>
    <body>
        <div id="body">
        <div class="top-info">
            <div class="top-info-image">
                <img src="photos/logo.png" alt="smile face" height="100px" width="100px">
            </div>
            <div class="top-info-detail">
                <div>Hi,<%
                Cookie cookie[]=request.getCookies();
                for(Cookie c:cookie)
              if(c.getName().equals("Name")){
            	  out.print(c.getValue());
            	  break;
            	  }
              
                //out.print(session.getAttribute("Name")); 
                %></div>
            </div>
            <div class="top-info-nav-logo">
               <div class="gknav">
                        <a href="" >Home</a>
                        <a href="" >Setting</a>
                        <a href="" >Notification</a>
                        <a href="index.html" onClick="del()")>Logout</a>
                    </div>
                <div class="top-info-logo" > <p>ABVGIET </p></div>
            </div>
        </div>
        <div class="nav bar">
                <ul>
                        <li>Result</li>
                        <li>Quesion Paper</li>
                        <li>Notice Board</li>
                        <li>Library</li>
                        <li>
                            Academics
                            <ul>
                                <li>1</li>
                                <li>2</li>
                            </ul>
                        </li>
                        <li>Attendence</li>
                    </ul>
        </div>
    </div>
        <script type="text/javascript">
           function del(){
        	document.cookie="Name=";
        	document.cookie="Id=";
        	   Window.location.replace("index.html");
           }
            var bdy=document.getElementById("body");
             var wid=screen.width;
            bdy.style.minWidth=wid+"px";
                </script>
    </body>
</html>