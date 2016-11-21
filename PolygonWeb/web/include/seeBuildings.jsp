<%-- 
    Document   : seeBuildings
    Created on : 20-11-2016, 20:59:26
    Author     : joaci
--%>
<%@page import="java.util.List"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>

<h1 class="page-header">Buildings</h1>
<%
    DomainFacade df = new DomainFacade();
    List<Building> buildings = df.getBuildings();
%>
<form action="Servlet" method="POST">
    <div class="row top-buffer"> </div>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>Index</th>
                <th>Address</th>
                <th>Zip</th>
                <th>City</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Building b : buildings) {
                    out.println("<tr>");
                    out.println("<td>");
                        out.println(b.getId());%>
        <input type="radio" name="buildingID" value="<%out.println(b.getId());%>" checked="checked" />
        <%
                out.println("</td>");
                out.println("<td>" + b.getAddress().getAddressline() + "</td>");
                out.println("<td>" + b.getAddress().getZipCode().getZip() + "</td>");
                out.println("<td>" + b.getAddress().getZipCode().getCity() + "</td>");
                out.println("<tr>");
            }
        %>
        </tbody>
    </table>
    <input type="hidden" name="origin" value="editBuilding">
    <input type="submit" class="btn btn-success" value="Edit" name="add"/> 
</form>
<br>
<form action="Servlet" method="POST">  
    <table class="table table-bordered">
        <thead>
            <tr>
                <th></th>
                <th>Address</th>
                <th>Zip</th>
                <th>City</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td> </td>   
                <td> <input type="text" name="address" value="" /> </td>  
                <td> <input type="text" name="zip" value="" />  </td>  
                <td> <input type="text" name="city" value="" />  </td>  
            </tr>


            <tr>  </tr>

        </tbody>
    </table>
    <input type="submit" class="btn btn-success" value="Create Building" name="origin"/>
</form> 