<%@page import="entity.Login"%>
<%@page import="Domain.DomainFacade"%>
<%@page import="entity.User"%>
<%@ include file="jspFiles/header.jsp" %>
<%
    User u = DomainFacade.getUserViaId((int) session.getAttribute("uId"));
    Login l = DomainFacade.getLogin((int) session.getAttribute("uId"));
;%>
<br>
Firstname: <%out.println(u.getFirstname());%>
<br>
Lastname: <%out.println(u.getLastname());%>
<br>
Email: <%out.println(u.getEmail());%>
<br>
Phone: <%out.println(u.getPhone());%>
<br>
Username: <%out.println(l.getUsername());%>
<br>
Password: <%out.println(l.getPassword());%>
<br>
Address: <%out.println(DomainFacade.getAddress(u.getAddressId()).getAddressline());%>
<br>
Zip: <% out.println(DomainFacade.getAddress(u.getAddressId()).getZipCode().getZip());%>
<br>
City: <%out.println(DomainFacade.getAddress(u.getAddressId()).getZipCode().getCity());%>
<%@ include file="jspFiles/footer.jsp" %>