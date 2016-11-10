<%@page import="entity.Document"%>
<%@page import="entity.User"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit building</title>
    </head>
    <body>
        <h1>Edit building </h1>
        <%
            //int buildingID = Integer.parseInt(request.getParameter("buildingid"));
            //Building b = DomainFacade.getBuilding(buildingID);
            Building b = DomainFacade.getBuilding(1); //to delete
            User u = DomainFacade.getUser(1); //to delete
            Document d = DomainFacade.getDocument(1); //to delete

        %>
        <form action="updateBuilding" method="POST">
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
            <input type="submit" name="action" value="Submit">
            <input type="submit" name="action" value="Cancel">
        </form>
    </body>
</html>
