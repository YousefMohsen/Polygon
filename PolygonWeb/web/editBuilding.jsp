<%@page import="entity.Document"%>
<%@page import="entity.User"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="indexdelete.html">Sundebygninger</a>                    
                </div>               
            </div>
        </nav>
        <div class="navbar navbar-inverse navbar-fixed-left">        
            <ul class="nav navbar-nav">               
                <li><a href="seeBuildings.jsp"><center><span style="font-size:5em;" class="glyphicon glyphicon-tent" aria-hidden="true"></span>Buildings</center></a></li>    
                <li><a href="#"><center><span style="font-size:5em;" class="glyphicon glyphicon-signal" aria-hidden="true"></span>Something</center></a></li>    
            </ul>
        </div>


        <div class="container"> 
        <h1>Edit building </h1>
        <%    
            String temp = session.getAttribute("ID").toString().substring(0,1);                       
            int buildingID = Integer.parseInt(temp);
            Building b = DomainFacade.getBuilding(buildingID);         
            User u = DomainFacade.getUser(1); 
            Document d = DomainFacade.getDocument(1);
        %>
        <form action="Servlet" method="POST">
            <h5>Info om ejer af bygning:</h5>
            <table>
                <tr><td>Fornavn</td><td><input type="text" name="firstname" value="<%=u.getFirstname()%>"></td></tr>
                <tr><td>Efternavn</td><td><input type="text" name="lastname" value="<%=u.getLastname()%>"></td></tr>
                <tr><td>Tlf. nr.</td><td><input type="text" name="phone" value="<%=u.getPhone()%>"></td></tr>
                <tr><td>E-mail</td><td><input type="text" name="email" value="<%=u.getEmail()%>"></td></tr>
                <tr><td>Adresse</td><td><input type="text" name="street" value="<%=u.getAddress().getAddressline()%>"></td></tr>
                <tr><td>Post nr.</td><td><input type="text" name="zip" value="<%=u.getAddress().getZipCode().getZip()%>"></td></tr>
                <tr><td>By</td><td><input type="text" name="city" value="<%=u.getAddress().getZipCode().getCity()%>"></td></tr>
            </table>
            <h5>Info om bygning:</h5>
            <table>
                <tr><td>Adresse</td><td><input type="text" name="street" value="<%=b.getAddress().getAddressline()%>"></td></tr>
                <tr><td>Post nr.</td><td><input type="text" name="zip" value="<%=b.getAddress().getZipCode().getZip()%>"></td></tr>
                <tr><td>By</td><td><input type="text" name="city" value="<%=b.getAddress().getZipCode().getCity()%>"></td></tr>
                <tr><td>Rapport URL</td><td><input type="text" name="report" value="<%=b.getReport()%>"></td></tr>
                <tr><td>Fil URL</td><td><input type="text" name="fileURL" value="<%=d.getFileURL()%>"></td></tr>
                <tr><td>Evt. note</td><td><input type="text" name="note" value="<%=d.getNote()%>"></td></tr>
            </table>
            <!--<input type="hidden" name="id" value="<//%=buildingID%>">-->
            <input type="submit" name="origin" value="Submit">
            <input type="submit" name="origin" value="Cancel">
        </form>
        </div>
    </body>
</html>
