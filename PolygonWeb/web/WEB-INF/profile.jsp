<%@page import="entity.Login"%>
<%@page import="Domain.DomainFacade"%>
<%@page import="entity.User"%>
<%@ include file="jspFiles/header.jsp" %>
<%        
    User u = DomainFacade.getUserViaId((int)session.getAttribute("uId"));      
    Login l = DomainFacade.getLogin((String)session.getAttribute("name"));   
    ;%>
<br>
Firstname: <%out.println(u.getFirstname());%>
<br>
Lastname: <%out.println(u.getLastname());%>
<br>
Adress: <%out.println(u.getAddress());%>
<br>
Email: <%out.println(u.getEmail());%>
<br>
Phone: <%out.println(u.getPhone());%>
<br>
Username: <%out.println(l.getUsername());%>
<br>
Password: <%out.println(l.getPassword());%>
<%@ include file="jspFiles/footer.jsp" %>