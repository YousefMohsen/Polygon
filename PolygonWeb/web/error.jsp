<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspFiles/header.jsp" %>
<h1>Something went wrong!</h1>
<%
    if (request.getSession().getAttribute("errorMessage") != null) {
        String msg = request.getSession().getAttribute("errorMessage").toString();
%><p><%= msg%></p><%
                request.getSession().removeAttribute("errorMessage");
            }
%>
<%@include file="WEB-INF/jspFiles/footer.jsp" %>
