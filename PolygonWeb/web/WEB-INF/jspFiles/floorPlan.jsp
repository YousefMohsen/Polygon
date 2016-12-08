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
            <div class="col-md-6">
                <h4>Info om plantegning:</h4>
                <table class="table">
                    <tr><td>Note</td><td><input  type="text" name="note" value="<%= d.getNote()%>"></td></tr>
                </table>
                <input class="btn btn-default pull-right" type="submit" value="Gem note"/>
                <input type="hidden" name="buildingID" value="<%=buildingID%>" />
            </div>
        </form>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            <h4>Upload Plantegning:</h4>
            <h5>Vælg det billede du ønsker at uploade:</h5>
            <input type="file" name="file" size="50"/>
            <br/>
            <input class="btn btn-default" type="submit" value="Upload Plantegning"/>
            <input type="hidden" name="buildingID" value="<%=buildingID%>" />
        </form>
        <br/>
        <% if (d.getFile() != null) {%>
        <form action="FrontController?ID=Servlet&switch=showImage" method="post">
            <input class="btn btn-default" type="submit" value="Vis Plantegning"/>
            <input type="hidden" name="buildingID" value="<%=buildingID%>" />
        </form>
        <%}%>
    </body>
</html>
