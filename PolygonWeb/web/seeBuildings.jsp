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

                <input type="hidden" name="origin" value="addBuilding">
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
                        <%                        for (Building b : buildings) {

                                out.println("<tr>");
                                out.println("<td>" + b.getId() + "</td>");
                                out.println("<td>" + b.getAddress().getAddressline() + "</td>");
                                out.println("<td>" + b.getAddress().getZipCode().getZip() + "</td>");
                                out.println("<td>" + b.getAddress().getZipCode().getCity() + "</td>");
                                out.println("<tr>");
                            }


                        %>



                        <tr>
                            <td>  </td>   
                            <td> <input type="text" name="address" value="" /> </td>  
                            <td> <input type="text" name="zip" value="" /> </td>
                            <td> <input type="text" name="city" value="" /> </td>
                            <td>   

                        </tr> 
                        <tr>



                        </tr>

                    </tbody>

                </table>

                <div>
                    <input type="submit" class="btn btn-success" value="Edit" name="add"/> 
                    Click the tables to edit them, and save with "enter" or go back with "escape".
                </div>
            </form>
        </div>




    </body>

</html>
