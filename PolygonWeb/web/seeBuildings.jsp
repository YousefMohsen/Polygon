<%@page import="java.util.List"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">Sundebygninger</a>                    
                </div>               
            </div>
        </nav>
        <div class="navbar navbar-inverse navbar-fixed-left">        
            <ul class="nav navbar-nav">               
                <li><a href="seeBuildings.jsp"><center><span style="font-size:5em;" class="glyphicon glyphicon-tent" aria-hidden="true"></span>Buildings</center></a></li>    
                <li><a href="#"><center><span style="font-size:5em;" class="glyphicon glyphicon-signal" aria-hidden="true"></span>Something</center></a></li>    
            </ul>
        </div>

        <%   //get data from DomainFacade
            DomainFacade df = new DomainFacade();
            List<Building> buildings = (List<Building>) session.getAttribute("buildings");
            // List<Building> buildings = (List) df.getBuildings();


        %>

        <div class="container">

            <form action="Servlet" method="POST"> 

      
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Index</th>
                            <th>Address</th>
                            <th>Zip</th>
                            <th>City</th>

                        </tr>
                    </thead>

                    <tbody>
                        <% 


                   
                        for (Building b : buildings) { 

                            out.println("<tr>");
                            out.println("<td>");        
                            out.println(b.getId());%>
 
                    <input type="radio" name="buildingID" value="<%out.println(b.getId());%>" checked="checked" />
   
             
                            <%
                                  
                                  out.println("</td>"); 
                            
                            
                          
                            out.println("<td>" + b.getAddress().getAddressline()+ "</td>");
                            out.println("<td>" + b.getAddress().getZipCode().getZip() + "</td>");
                            out.println("<td>" + b.getAddress().getZipCode().getCity() + "</td>");
                            out.println("<tr>");%>
                            
                
                            
                       <%   }

                        %>



                     
                        <tr>



                        </tr>

                    </tbody>

                </table>

                       
          <input type="hidden" name="origin" value="addBuilding">
            <input type="submit" class="btn btn-success" value="Edit" name="add"/> 
                   
        
            </form>
        
                        <div> </div>

</div>




    </body>

</html>
