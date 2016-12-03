<%@page import="java.util.List"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>
<h2> Deletion requests:</h2>
<%
    DomainFacade df = new DomainFacade();
    List<Building> buildings = df.getDeletionBuildings();
    
if(buildings.size()<=0){%> <div class="alert alert-info">
  <strong>Info!</strong> Ingen anmodninger fundet!
</div><%}
%>
<div class="row top-buffer"> </div>
<table class="table table-bordered table-hover tableHovers">
    <thead>
        <tr>             
            <th>Zip</th>
            <th>City</th>
            <th>Address</th>
            <th></th>
        </tr>
    </thead>                                     
    <tbody>    
        <%
            for (Building b : buildings) {
                out.println("<tr>");
                out.println("<td>" + b.getAddress().getZipCode().getZip() + "</td>");
                out.println("<td>" + b.getAddress().getZipCode().getCity() + "</td>");
                out.println("<td>" + b.getAddress().getAddressline() + "</td>");
                out.println("<td>" + " <button class=\"btn btn-danger \"  onclick=\"document.location = 'FrontController?ID=Servlet?switch=acceptRequest&buildingID=" + b.getId() + "';\">" + " Accept deletion  </button>  </td>");

            }
        %>
    </tbody>
</table>        
