<%-- 
    Document   : seeBuildings
    Created on : 25-10-2016, 14:05:17
    Author     : Yousinho
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
       
        <title>JSP Page</title>
    </head>
    <body>
           <%   //get data from servlet
        DomainFacade df = new DomainFacade();
       List<Building> buildings = (List) df.getBuildings(); 
           %>

           
                 <table class="table table-bordered">
    <thead>
      <tr>
        <th>Name</th>
        <th>Adress</th>
        <th>Owner</th>
        <th>Report</th>
      </tr>
    </thead>
  
    <tbody>
        <% 
            
        for (Building b : buildings) {
    %>  
        
        
        
        <% 

            out.println("<tr>");
        out.println("<td>" +"</td>");    
        out.println("<td>" + b.getAdressID()+"</td>");
        out.println("<td>" + b.getUser()+"</td>");
        out.println("<td>" + b.getRapoort()+"</td>");
        
        
        
  
          %>     
</tr>


    </form>
        <%
        }
        

        
        
        %>
  

      
      
    </tbody>
    
  </table>
           
           
    </body>
</html>
