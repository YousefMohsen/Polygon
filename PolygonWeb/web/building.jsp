<%-- 
    Document   : building
    Created on : 10-11-2016, 16:51:42
    Author     : Joacim
--%>

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


        <div class="container"> 
            <div class="well">
                <h2>Info</h2>
                Navn    Adresse OSV
            </div>
            <div class="well">
                <h2>Filer</h2>
                Fil1
                Fil2
                <input type="file" name="UploadFile" value="" />
            </div>
            <div class="well">
                <h2>Skader</h2>
                Navn    Adresse OSV
            </div>
            <div class="well">
                <h2>Anmod om service</h2>
                <select name="">
                    <option>Vandskade</option>
                    <option>Fugtskade</option>
                    <input type="text" name="" value="Skriv en note" />
                    <input type="submit" value="Submit" />
                </select>
            </div>            
        </div>
    </body>
</html>
