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
  
    
    int userId = (int) session.getAttribute("userID");
    //int rank = (int) session.getAttribute("rank");
    //System.out.println(rank);
    List<Building> buildings = DomainFacade.getBuildingsForUser(userId, 1);
               
%>
<form action="" method="POST">
    <div class="row top-buffer"> </div>
    <table class="table table-bordered table-hover tableHovers">
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
                    out.println("<tr class = \"menu_links\" onclick=\"document.location = 'FrontController?ID=Servlet&switch=editBuilding&buildingID=" + b.getId() +"';\">");   
                    out.println("<td>" + b.getAddress().getZipCode().getZip() + "</td>");
                    out.println("<td>" + b.getAddress().getZipCode().getCity() + "</td>");
                    out.println("<td>"+ b.getAddress().getAddressline() + "</td>");
                }                
            %>
        </tbody>
    </table>        
</form>
<br>
<form action="FrontController?ID=Servlet&switch=createBuilding" method="POST">  
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
    <input type="hidden" name="buildingID" value="1" />
    <input type="submit" class="btn btn-success" value="Create Building"/>
</form> 