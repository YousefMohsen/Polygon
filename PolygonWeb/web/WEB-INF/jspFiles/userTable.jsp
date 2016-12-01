<%@page import="entity.Building"%>
<%@page import="entity.Login"%>
<%@page import="Domain.DomainFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.User"%>
<h1 class="page-header">Users</h1>

<table class="table table-bordered table-hover">
    <thead>
        <tr>             
            <th>Username</th>
            <th>City</th>
            <th>Address</th>
            <th>Buildings</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Username</th>
            <th>Password</th>
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<User> userList = new ArrayList<>();       
        userList = DomainFacade.getUsers();       
        
           
        for (int i = 0; i < userList.size(); i++) {
            Login l = DomainFacade.getLogin(userList.get(i).getId()); 
            String b = "";
            for (Building building : DomainFacade.getBuildingsForUser(userList.get(i).getId(), l.getRank())) {
                b += "<a href='FrontController?ID=Servlet&switch=editBuilding&buildingID="+building.getId()+"'>" + building.getBuildingName() + "</a><br />";                
            }
            out.println();
            out.println("<tr>" );
            out.println("<td>"+userList.get(i).getFirstname()+"</td>");
            out.println("<td>"+DomainFacade.getAddress(userList.get(i).getId()).getZipCode().getCity()+"</td>");
            out.println("<td>"+DomainFacade.getAddress(userList.get(i).getId()).getAddressline()+"</td>");
            out.println("<td><button type=\"button\" class=\"btn btn-primary btn-sm\" title=\"Buildings\" data-toggle=\"popover\" data-html='true' data-placement=\"top\" "
                    + "data-content=\"  <a href=''>"+b+"</a>       \">"
                    +DomainFacade.getBuildingsForUser(userList.get(i).getId(), l.getRank()).size()+" Buildings"+"</a></td>");
            out.println("<td>"+userList.get(i).getFirstname()+"</td>");
            out.println("<td>"+userList.get(i).getLastname()+"</td>");
            out.println("<td>"+l.getUsername()+"</td>");
            out.println("<td>"+l.getPassword()+"</td>");            
            out.println("</tr>");
            
            }       
        %>
    </tbody>  
</table>   
