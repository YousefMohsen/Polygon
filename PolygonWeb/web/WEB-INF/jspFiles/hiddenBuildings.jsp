       
<%@page import="java.util.List"%>
<%@page import="Domain.DomainFacade"%>
<%@page import="entity.Building"%>

<%  List<Building> buildings = (List)DomainFacade.getDeletedBuildings(); 


%>


 <table class="table table-bordered table-hover tableHovers">
        <thead>
            <tr>             
                <th>Zip</th>
                <th>City</th>
                <th>Address</th>
                <th>Name</th>
            </tr>
        </thead>
  <tbody>    
        <%
            for (Building b : buildings) {
                out.println("<tr>");
                out.println("<td>" + b.getAddress().getZipCode().getZip() + "</td>");
                out.println("<td>" + b.getAddress().getZipCode().getCity() + "</td>");
                out.println("<td>" + b.getAddress().getAddressline() + "</td>");
                out.println("<td>" + " <button class=\"btn btn-warning \"  onclick=\"document.location = 'FrontController?ID=Servlet?switch=restoreBuilding&buildingID=" + b.getId() + "';\">" + " Restore Building  </button>  </td>");

            }
        %>
    </tbody>
    </table>        