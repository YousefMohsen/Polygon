<%@page import="java.sql.Connection"%>
<%@page import="data.DB"%>
<%@page import="entity.Address"%>
<%@page import="entity.Building"%>
<%@page import="entity.Login"%>
<%@page import="Domain.DomainFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.User"%>
<h1 class="page-header">Users</h1>

<table class="table table-bordered table-hover">
    <thead>
        <tr>             
            <th>Rank</th>
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

            ArrayList<Login> loginData = new ArrayList();
            loginData = DomainFacade.getAllLogin();

            ArrayList<Address> addressList = new ArrayList();
            addressList = DomainFacade.getAllAddress();

            ArrayList<Building> buildingList = new ArrayList();
            buildingList = DomainFacade.getBuildings();

            for (int i = 0; i < userList.size(); i++) {
                Address address = null;
                for (Address ad : addressList) {
                    if (ad.getAddressID() == userList.get(i).getId()) {
                        address = ad;
                    }
                }
                String b = "";
                int userBuildingsCount = 0;
                if (loginData.get(i).getRank() == 5) {
                    for (Building building : buildingList) {
                        if (building.getUser() == userList.get(i).getId()) {
                            b += "<a href='FrontController?ID=Servlet&switch=editBuilding&buildingID=" + building.getId() + "'>" + building.getBuildingName() + "</a><br />";
                            userBuildingsCount++;
                        }
                    }
                }
                out.println();
                out.println("<tr>");
                out.println("<td>" + loginData.get(i).getRank() + "</td>");
                out.println("<td>" + address.getZipCode().getCity() + "</td>");
                out.println("<td>" + address.getAddressline() + "</td>");
                if (loginData.get(i).getRank() == 5) {
                    out.println("<td><button type=\"button\" class=\"btn btn-primary btn-sm\" title=\"Buildings\" data-toggle=\"popover\" data-html='true' data-placement=\"top\" "
                            + "data-content=\"  <a href=''>" + b + "</a> \">"
                            + userBuildingsCount + " Buildings" + "</a></td>");
                }
                if (loginData.get(i).getRank() != 5) {
                    out.println("<td></td> ");
                }
                out.println("<td>" + userList.get(i).getFirstname() + "</td>");
                out.println("<td>" + userList.get(i).getLastname() + "</td>");
                out.println("<td>" + loginData.get(i).getUsername() + "</td>");
                out.println("<td>" + loginData.get(i).getPassword() + "</td>");
                out.println("</tr>");
            }
        %>
    </tbody>  
</table>  


<button data-toggle="collapse" data-target="#createForm" class="btn btn-primary">Create new user</button>


<form id="createForm" action="FrontController?ID=Servlet&switch=createUser" class="form-horizontal collapse" method="POST">

    <fieldset>

        <!-- Form Name -->
        <legend>Create new user</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">Username</label>  
            <div class="col-md-4">
                <input id="textinput" name="username" placeholder="Insert username here" class="form-control input-md" required="" type="text">
                <span class="help-block"> </span>  
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">Password</label>  
            <div class="col-md-4">
                <input id="textinput" name="password" placeholder="Insert password here" class="form-control input-md" required="" type="password">
                <span class="help-block"> </span>  
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">First Name</label>  
            <div class="col-md-4">
                <input id="textinput" name="firstname" placeholder="Insert First Name here" class="form-control input-md" required="" type="text">
                <span class="help-block"> </span>  
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">Last Name</label>  
            <div class="col-md-4">
                <input id="textinput" name="lastname" placeholder="Insert Last Name here" class="form-control input-md" required="" type="text">
                <span class="help-block"> </span>  
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">Phone</label>  
            <div class="col-md-4">
                <input id="textinput" name="phone" placeholder="Insert Phone here" class="form-control input-md" required="" type="text">
                <span class="help-block"> </span>  
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">Email</label>  
            <div class="col-md-4">
                <input id="textinput" name="email" placeholder="Insert Email here" class="form-control input-md" required="" type="text">
                <span class="help-block"> </span>  
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">Address</label>  
            <div class="col-md-4">
                <input id="textinput" name="address" placeholder="Insert Address here" class="form-control input-md" required="" type="text">
                <span class="help-block"> </span>  
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">Zip</label>  
            <div class="col-md-4">
                <input id="textinput" name="zip" placeholder="Insert Zipcode here" class="form-control input-md" required="" type="text">
                <span class="help-block"> </span>  
            </div>
        </div>

        <!-- Select option -->
        <div class="form-group">
            <label class="col-md-1 control-label" for="textinput">Rank</label>  
            <div class="col-md-4">
                <select name="rank">
                    <option name="1" value="1">Admin</option>
                    <option name="3" value="3">Employee</option>
                    <option name="5" value="5">Customer</option>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-1 control-label" for="singlebutton"> </label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
            </div>
        </div>      

    </fieldset>
</form>   