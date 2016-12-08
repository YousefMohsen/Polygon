<%@page import="Domain.DomainFacade"%>
<%@page import="entity.Document"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int buildingID = Integer.parseInt(request.getParameter("buildingID"));
    Document d = DomainFacade.getDocument(buildingID);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <img src="FrontController?ID=ShowImageServlet?buildingID=<%= buildingID%>" style="width:728px;height:728px;">
    </body>
</html>
