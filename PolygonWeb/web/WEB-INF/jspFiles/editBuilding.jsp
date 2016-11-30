<%@page import="entity.Document"%>
<%@page import="entity.User"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>    

<%
   
    int buildingID = (Integer)request.getAttribute("ID");
  
    Building b = DomainFacade.getBuilding(buildingID);
    User u = DomainFacade.getUser(buildingID);
    Document d = DomainFacade.getDocument(buildingID);
%>

<form action="FrontController?ID=Servlet&switch=Submit" method="POST">
    <div class="well well-lg">   
        <div class="row">
            <button class="btn btn-default pull-right" type="button" onclick="unlock()">Edit</button>
        </div>

        <div class="row">
            <div class="col-md-6">
                <h4>Info om ejer af bygning:</h4>
                <table class ="table">
                    <tr><td>Fornavn</td><td><%=u.getFirstname()%></td></tr>
                    <tr><td>Efternavn</td><td><%=u.getLastname()%></td></tr>
                    <tr><td>Tlf. nr.</td><td><%=u.getPhone()%></td></tr>
                    <tr><td>E-mail</td><td><%=u.getEmail()%></td></tr>
                    <tr><td>Adresse</td><td><%=u.getAddress().getAddressline()%></td></tr>
                    <tr><td>Post nr.</td><td><%=u.getAddress().getZipCode().getZip()%></td></tr>
                    <tr><td>By</td><td><%=u.getAddress().getZipCode().getCity()%></td></tr>
                </table>
            </div>
            <div class="col-md-6">
                <h4>Info om bygning:</h4>
                <table class="table">
                    <tr><td>Adresse</td><td><input  type="text" name="buildingStreet" value="<%=b.getAddress().getAddressline()%>"></td></tr>
                    <tr><td>Post nr.</td><td><input  type="text" name="buildingZip" value="<%=b.getAddress().getZipCode().getZip()%>"></td></tr>
                    <tr><td>By</td><td><input  type="text" name="buildingCity" value="<%=b.getAddress().getZipCode().getCity()%>"></td></tr>
                            <%
                                String rapportPath = "files/" + b.getReport();
                            %>
                    <tr><td><a href="<%= rapportPath%>" target="_blank">Rapport URL</a></td><td><input  type="text" name="reportURL" value="<%=b.getReport()%>"></td></tr>
                    <tr><td>Fil URL</td><td><input  type="text" name="fileURL" value="<%=d.getFileURL()%>"></td></tr>
                    <tr><td>Evt. note</td><td><input  type="text" name="note" value="<%=d.getNote()%>"></td></tr>
                </table>
            </div>
        </div>            
    </div>


    <div class="row">
        <div class="col-md-3">
            <a href="FrontController?ID=LinkServlet&page=rapport.jsp&buildingID=<%= buildingID%>&newRapport" class="btn btn-default">Lav rapport</a>
            <a href="FrontController?ID=LinkServlet&page=buildingTable.jsp" class="btn btn-default">Back</a>       
            <input type="hidden" name="buildingID" value="<%=buildingID%>" />
            <input type="hidden" name="id" value="<%=buildingID%>" />
            <input class="btn btn-default" type="submit" name="origin" value="Save">   
            </form>
        </div>
        <div class="col-md-9">     

            <form action="FrontController?ID=Servlet&switch=deletionRequest" method="POST" id="deletionForm"> 
                <input type="hidden" name="buildingID" value="<%=buildingID%>" />
                <input type="hidden" name="origin" value="deletionRequest" />
                <input class="btn btn-danger pull-right" size="12" value="Request deletion" onclick="deletionRequest()">  
            </form>
            <form action="FrontController?ID=Servlet&switch=healthCheck" method="POST" id="HealthCheckForm" > 
                <input class="btn btn-default pull-right "  value="Request health check" onclick="healthCheck()">  
                <input type="hidden" name="buildingID" value="<%=buildingID%>" />
                <input type="hidden" name="origin" value="healthCheck" />
            </form>
        </div> 
    </div>  
    <script src="javascript/requestHandler.js"></script>
    <script src="javascript/inputHider.js"></script>