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
        <title>Upload Af Plantegning</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="FrontController?ID=Servlet&switch=updateNote" method="post">
            <img src="FrontController?ID=ShowImageServlet?buildingID=<%=buildingID%>" style="width:128px;height:128px;">
            <div class="col-md-6">
                <h4>Info om plantegning:</h4>
                <table class="table">
                    <tr><td>Filer</td><td><a href="" name="file" ><input  type="hidden" value="<%=d.getFile()%>" name="file" ><%=d.getFile()%></a></td></tr>
                    <tr><td>Note</td><td><input  type="text" name="note" value="<%= d.getNote()%>"></td></tr>
                </table>
                <input class="btn btn-default" type="submit" value="Gem"/>
                <input type="hidden" name="buildingID" value="<%=buildingID%>" />
            </div>
        </form>
        <br/>
        <br/>
        <br/>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <h4>Upload Plantegning:</h4>
            <h5>Vælg det billede du ønsker at uploade:</h5>
            <input type="file" name="file" size="50"/>
            <br/>
            <input class="btn btn-default" type="submit" value="Upload Billede"/>
            <input type="hidden" name="buildingID" value="<%=buildingID%>" />
        </form>
    </body>
</html>
