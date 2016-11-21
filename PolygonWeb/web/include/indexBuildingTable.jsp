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
                <th>Zip</th>
                <th>City</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Building b : buildings) {
                    out.println("<tr>");   
                    out.println("<td>" + b.getAddress().getZipCode().getZip() + "</td>");
                    out.println("<td>" + b.getAddress().getZipCode().getCity() + "</td>");
                    out.println("<td>"+"<a href=\"Servlet?origin=editBuilding&buildingID=" + b.getId() + "\">"+ b.getAddress().getAddressline() + "</a></td>");
                }                 
            %>
        </tbody>
    </table>     
</form>
<br>
<form action="Servlet" method="POST">  
    <table class="table table-bordered">
        <thead>
            <tr>              
                <th>Address</th>
                <th>Zip</th>
                <th>City</th>
            </tr>
        </thead>
        <tbody>
            <tr>                
                <td> <input type="text" name="address" value="" /> </td>  
                <td> <input type="text" name="zip" value="" />  </td>  
                <td> <input type="text" name="city" value="" />  </td>  
            </tr>
        </tbody>
    </table>
    <input type="submit" class="btn btn-success" value="Create Building" name="origin"/>
</form> 