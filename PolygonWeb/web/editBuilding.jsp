<%@include file="include/header.jsp" %>
<%@page import="entity.Document"%>
<%@page import="entity.User"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>     
<h1>Edit building </h1>
<%
    String temp = session.getAttribute("ID").toString().substring(0, 1);
    int buildingID = Integer.parseInt(temp);
    Building b = DomainFacade.getBuilding(buildingID);
    User u = DomainFacade.getUser(buildingID);
    Document d = DomainFacade.getDocument(buildingID);
%>
<form action="Servlet" method="POST">
            <h5>Info om ejer af bygning:</h5>
            <table>
                <tr><td>Fornavn</td><td><input type="text" name="firstname" value="<%=u.getFirstname()%>"></td></tr>
                <tr><td>Efternavn</td><td><input type="text" name="lastname" value="<%=u.getLastname()%>"></td></tr>
                <tr><td>Tlf. nr.</td><td><input type="text" name="phone" value="<%=u.getPhone()%>"></td></tr>
                <tr><td>E-mail</td><td><input type="text" name="email" value="<%=u.getEmail()%>"></td></tr>
                <tr><td>Adresse</td><td><input type="text" name="userStreet" value="<%=u.getAddress().getAddressline()%>"></td></tr>
                <tr><td>Post nr.</td><td><input type="text" name="userZip" value="<%=u.getAddress().getZipCode().getZip()%>"></td></tr>
                <tr><td>By</td><td><input type="text" name="userCity" value="<%=u.getAddress().getZipCode().getCity()%>"></td></tr>
            </table>
            <h5>Info om bygning:</h5>
            <table>
                <tr><td>Adresse</td><td><input type="text" name="buildingStreet" value="<%=b.getAddress().getAddressline()%>"></td></tr>
                <tr><td>Post nr.</td><td><input type="text" name="buildingZip" value="<%=b.getAddress().getZipCode().getZip()%>"></td></tr>
                <tr><td>By</td><td><input type="text" name="buildingCity" value="<%=b.getAddress().getZipCode().getCity()%>"></td></tr>
                <tr><td>Rapport URL</td><td><input type="text" name="reportURL" value="<%=b.getReport()%>"></td></tr>
                <tr><td>Fil URL</td><td><input type="text" name="fileURL" value="<%=d.getFileURL()%>"></td></tr>
                <tr><td>Evt. note</td><td><input type="text" name="note" value="<%=d.getNote()%>"></td></tr>
            </table>
            <a href="rapport.jsp">Opret rapport!</a>
            <input type="submit" name="origin" value="Submit">
            <input type="submit" name="origin" value="Cancel">
            <input type="hidden" name="id" value="<%=buildingID%>" />
        </form>             
<%@ include file="include/footer.jsp" %>