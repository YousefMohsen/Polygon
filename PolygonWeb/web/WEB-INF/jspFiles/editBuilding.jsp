<%@page import="java.util.List"%>
<%@page import="entity.Request"%>

<%@page import="entity.Document"%>
<%@page import="entity.User"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>    

<%
    int buildingID = (Integer) request.getAttribute("buildingID");
    Building b = DomainFacade.getBuilding(buildingID);
    User u = DomainFacade.getUser(buildingID);
%>


<%
    List<Request> requestList = (List) DomainFacade.getRequest(buildingID);

    for (Request r : requestList) {
        int requestId = r.getId();

        if (requestId == 1) {//if building is appending approval for deletion
            String str = "<div class=\"alert alert-danger\">"
                    + "<strong>Info!</strong> This building is appending approval for deletion."
                    + "</div> ";

            out.println(str);
        } else if (requestId == 2) {//if building is appending approval for health check
            String str = "<div class=\"alert alert-info\">"
                    + "<strong>Info!</strong> This building is appending approval for health check."
                    + "</div> ";

            out.println(str);
        }
    }


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
                </table>
            </div>
            <div class="col-md-6">
                <h4>Info om bygning:</h4>
                <table class="table">
                    <tr><td>Building name</td><td><input  type="hidden" name="buildingName" value="<%=b.getBuildingName()%>"><%=b.getBuildingName()%></td></tr>
                    <tr><td>Address</td><td><input  type="hidden" name="buildingStreet" value="<%=b.getAddress().getAddressline()%>"><%=b.getAddress().getAddressline()%></td></tr>
                    <tr><td>Zip code</td><td><input  type="hidden" name="buildingZip" value="<%=b.getAddress().getZipCode().getZip()%>"><%=b.getAddress().getZipCode().getZip()%></td></tr>
                    <tr><td>City</td><td><input  type="hidden" name="buildingCity" value="<%=b.getAddress().getZipCode().getCity()%>"><%=b.getAddress().getZipCode().getCity()%></td></tr>
                            <%String rapportPath = "files/pdf/" + b.getReport();%>
                    <tr><td>Rapport URL</td><td><input  type="hidden" name="reportURL" value="<%=b.getReport()%>"><a href="<%= rapportPath%>" target="_blank"><%=b.getReport()%></a></td></tr>
                    <!--<tr><td>Filer</td><td><a href="" name="fileURL" ><input  type="hidden" value="<//%=d.getFile());%>" name="fileURL" ><//%=d.getFile()%></a></td></tr>-->
                    <!--<tr><td>Note (About file)</td><td><input  type="text" name="note" value="<//%= d.getNote()%>"></td></tr>-->

                </table>
                <input  type="hidden" name="buildingAddressId" value="<%=b.getAddressId()%>">
            </div>
        </div>            
    </div>

    <div class="row">
        <div class="col-md-3">
            <a href="FrontController?ID=LinkServlet&page=rapport.jsp&buildingID=<%= buildingID%>&newRapport" class="btn btn-default">Lav rapport</a>
            <a href="FrontController?ID=LinkServlet&page=seeFloorPlan.jsp&buildingID=<%= buildingID%>" class="btn btn-default">Upload Plantegning</a>
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