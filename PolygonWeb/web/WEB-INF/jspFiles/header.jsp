<!DOCTYPE html>
<%int rank = (int) session.getAttribute("rank");%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Sundebygninger</title>   
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
<!-- Custom styles -->  
<link href="css/dashboard.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header ">                  
                    <a class="navbar-brand" href="FrontController?ID=LinkServlet&page=buildingTable.jsp">
                        <img alt="Brand" src="images/favicon.png" height="26" width="32">
                    </a>  
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse">   
                    <ul class="nav navbar-nav navbar-right">                        
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%out.println(session.getAttribute("name"));%> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="FrontController?ID=LinkServlet&page=profile.jsp">Profile</a></li>                                
                                <li role="separator" class="divider"></li>
                                <li><a href="FrontController?ID=Servlet&switch=logout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar menu nav1">       
                        <li> <a href="FrontController?ID=LinkServlet&page=buildingTable.jsp">Buildings</a></li>
                        <%if (rank == 1) {%><li><a href="FrontController?ID=LinkServlet&page=users.jsp">Users</a></li> 
                      <li><a href="FrontController?ID=LinkServlet&page=Request.jsp">Deletion requests</a></li>
                        <li><a href="FrontController?ID=LinkServlet&page=hiddenBuildings.jsp">Deleted buildings</a></li>
                      
                      <%}%>
                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
