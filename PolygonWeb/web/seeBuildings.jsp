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
           <%   //get data from DomainFacade
        DomainFacade df = new DomainFacade();
       List<Building> buildings = (List) df.getBuildings(); 
           %>

        <form action="Servlet" method="POST"> 
                 
  <input type="hidden" name="origin" value="addBuilding">
      <table class="table table-bordered">
    <thead>
      <tr>
        <th>Contact</th>
        <th>Adress</th>
        <th>Zip</th>
        <th>City</th>
        <th>Phone</th>  
      </tr>
    </thead>
  
    <tbody>
        <% 
            
        for (Building b : buildings) {
  

            out.println("<tr>");
        out.println("<td>" + b.getUser()+"</td>");
        out.println("<td>" + b.getAdress().getAdressline()+"</td>");
        out.println("<td>" + b.getAdress().getZipCode().getZip()+"</td>");
        out.println("<td>" + b.getAdress().getZipCode().getCity()+"</td>");
        out.println("<td>"+"phone number"+ "</td>");
         out.println("<tr>");       }
        

        
        
        %>
  


        <tr>
            <td> <input type="text" name="contact" value="" /> </td>   
            <td> <input type="text" name="adress" value="" /> </td>  
            <td> <input type="text" name="zip" value="" /> </td>
             <td> <input type="text" name="city" value="" /> </td>
           <td> <input type="text" name="phone" value="" /> </td>
        </tr> 
         <tr>
             
<td> <input type="submit" class="btn btn-success" value="Add Building" name="add"/> </td>   


        </tr>
      
      
    </tbody>
        
  </table>


          </form>

   
           
    </body>
</html>
