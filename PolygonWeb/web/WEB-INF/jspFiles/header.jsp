<!DOCTYPE html>
<%int rank = (int)session.getAttribute("userID");%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Sundebygninger</title>   
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.jsp">
                        <img alt="Brand" src="images/favicon.png" height="28" width="32">                       
                    </a>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar menu">       
                        <li> <a href="FrontController?ID=LinkServlet&page=buildingTable.jsp">Buildings</a></li>
                        <li><a href="FrontController?ID=LinkServlet&page=users.jsp">Users</a></li>   
                        <%if(rank==1){%><li><a href="FrontController?ID=LinkServlet&page=Request.jsp">Deletion requests</a></li><%}%>
                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
