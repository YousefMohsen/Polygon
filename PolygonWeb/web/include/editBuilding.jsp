<%@page import="entity.Document"%>
<%@page import="entity.User"%>
<%@page import="entity.Building"%>
<%@page import="Domain.DomainFacade"%>    

<%

    String temp = session.getAttribute("ID").toString().substring(0, 1);
    int buildingID = Integer.parseInt(temp);
    Building b = DomainFacade.getBuilding(buildingID);
    User u = DomainFacade.getUser(buildingID);
    Document d = DomainFacade.getDocument(buildingID);

%>
<<<<<<< HEAD
   
=======

>>>>>>> f8c06a7177f1090ad131755cdcca48230781ec2b

<form action="Servlet" method="POST">
    <div class="well well-lg">   
        <div class="row">
            <button class="btn btn-default pull-right" type="button" onclick="unlock()">Edit</button>


        </div>

        <div class="row">
            <div class="col-md-6">
                <h4>Info om ejer af bygning:</h4>
                <table class = "table">
                    <tr><td>Fornavn</td><td><input  type="text" name="firstname" value="<%=u.getFirstname()%>"></td></tr>
                    <tr><td>Efternavn</td><td><input  type="text" name="lastname" value="<%=u.getLastname()%>"></td></tr>
                    <tr><td>Tlf. nr.</td><td><input  type="text" name="phone" value="<%=u.getPhone()%>"></td></tr>
                    <tr><td>E-mail</td><td><input  type="text" name="email" value="<%=u.getEmail()%>"></td></tr>
                    <tr><td>Adresse</td><td><input  type="text" name="userStreet" value="<%=u.getAddress().getAddressline()%>"></td></tr>
                    <tr><td>Post nr.</td><td><input  type="text" name="userZip" value="<%=u.getAddress().getZipCode().getZip()%>"></td></tr>
                    <tr><td>By</td><td><input  type="text" name="userCity" value="<%=u.getAddress().getZipCode().getCity()%>"></td></tr>
                </table>
            </div>
            <div class="col-md-6">
                <h4>Info om bygning:</h4>
                <table class="table">
                    <tr><td>Adresse</td><td><input  type="text" name="buildingStreet" value="<%=b.getAddress().getAddressline()%>"></td></tr>
                    <tr><td>Post nr.</td><td><input  type="text" name="buildingZip" value="<%=b.getAddress().getZipCode().getZip()%>"></td></tr>
                    <tr><td>By</td><td><input  type="text" name="buildingCity" value="<%=b.getAddress().getZipCode().getCity()%>"></td></tr>
                    <tr><td>Rapport URL</td><td><input  type="text" name="reportURL" value="<%=b.getReport()%>"></td></tr>
                    <tr><td>Fil URL</td><td><input  type="text" name="fileURL" value="<%=d.getFileURL()%>"></td></tr>
                    <tr><td>Evt. note</td><td><input  type="text" name="note" value="<%=d.getNote()%>"></td></tr>
                </table>
            </div>
        </div>            
    </div>
    <div class="row">
<<<<<<< HEAD
  <div class="col-md-6">
      <h4>Info om ejer af bygning:</h4>
  <table class = "table">
                <tr><td>Fornavn</td><td><input  type="text" name="firstname" value="<%=u.getFirstname()%>"></td></tr>
                <tr><td>Efternavn</td><td><input  type="text" name="lastname" value="<%=u.getLastname()%>"></td></tr>
                <tr><td>Tlf. nr.</td><td><input  type="text" name="phone" value="<%=u.getPhone()%>"></td></tr>
                <tr><td>E-mail</td><td><input  type="text" name="email" value="<%=u.getEmail()%>"></td></tr>
                <tr><td>Adresse</td><td><input  type="text" name="userStreet" value="<%=u.getAddress().getAddressline()%>"></td></tr>
                <tr><td>Post nr.</td><td><input  type="text" name="userZip" value="<%=u.getAddress().getZipCode().getZip()%>"></td></tr>
                <tr><td>By</td><td><input  type="text" name="userCity" value="<%=u.getAddress().getZipCode().getCity()%>"></td></tr>
            </table>
  </div>
  <div class="col-md-6">
  <h4>Info om bygning:</h4>
            <table class="table">
                <tr><td>Adresse</td><td><input  type="text" name="buildingStreet" value="<%=b.getAddress().getAddressline()%>"></td></tr>
                <tr><td>Post nr.</td><td><input  type="text" name="buildingZip" value="<%=b.getAddress().getZipCode().getZip()%>"></td></tr>
                <tr><td>By</td><td><input  type="text" name="buildingCity" value="<%=b.getAddress().getZipCode().getCity()%>"></td></tr>
                <tr><td>Rapport URL</td><td><input  type="text" name="reportURL" value="<%=b.getReport()%>"></td></tr>
                <tr><td>Fil URL</td><td><input  type="text" name="fileURL" value="<%=d.getFileURL()%>"></td></tr>
                <tr><td>Evt. note</td><td><input  type="text" name="note" value="<%=d.getNote()%>"></td></tr>
            </table>
  </div>
    </div>            
</div>
            <div class="row">
                <div class="col-md-6">
                <a href="rapport.jsp" class="btn btn-default">Lav rapport</a>

                <input class="btn btn-default" type="submit" name="origin" value="Submit">         
                <input type="hidden" name="id" value="<%=buildingID%>" />
</form>
<a href="index.jsp" class="btn btn-default">Back</a>
</div>
         
<form action="Servlet" method="POST"> 
    
   <input class="btn btn-danger" type="submit" value="Request deletion">  
       <input type="hidden" name="buildingID" value="<%=buildingID%>" />
       <input type="hidden" name="origin" value="requestDeletion" />
</form>
            </div>
=======
        <div class="col-md-6">
            <a href="rapport.jsp" class="btn btn-default">Lav rapport</a>

            <input class="btn btn-default" type="submit" name="origin" value="Submit">         
            <input type="hidden" name="id" value="<%=buildingID%>" />
            </form>
            <a href="buildingTable.jsp" class="btn btn-default">Back</a>
        </div>
    </div>

>>>>>>> f8c06a7177f1090ad131755cdcca48230781ec2b


    <script src="javascript/inputHider.js"></script>