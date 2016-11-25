<%@page import="Domain.DomainFacade"%>
<%@page import="entity.Document"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
//    String temp = session.getAttribute("ID").toString().substring(0, 1);
//    int buildingID = Integer.parseInt(temp);
//    String file = DomainFacade.getDocument(buildingID).getFileURL();
      int buildingID = 1;
%>

<html>
    <head>
        <title>File Uploading</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h3>Floor Plan Upload:</h3>
        Select a file to upload: <br/>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <input type="file" name="file" size="50"/>
            <br/>
            <input type="submit" value="Upload File"/>
            <input type="hidden" name="buildingID" value="<%=buildingID%>" />
        </form>
    </body>
</html>
