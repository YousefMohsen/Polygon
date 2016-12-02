<%@page import="Domain.DomainFacade"%>
<%@page import="entity.Document"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    int buildingID = Integer.parseInt(request.getParameter("buildingID"));
    //Document d = DomainFacade.getDocument(buildingID);
%>

<html>
    <head>
        <title>Upload Af Plantegning</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h3>Upload Plantegning</h3>
        Vælg det billede du ønsker at uploade: <br/>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" name="file" size="50"/>
            <br/>
            <input type="submit" value="Upload Billede"/>
            <input type="hidden" name="buildingID" value="<%=buildingID%>" />
        </form>
    </body>
</html>
