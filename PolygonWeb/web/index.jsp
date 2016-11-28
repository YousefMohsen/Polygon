<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Sundebygninger</title>   
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <form class="form-horizontal" id="editBuilding.jsp" action='LoginServlet' method="POST">
                        <fieldset>
                            <div id="legend">
                                <legend class="">Login</legend>
                            </div>
                            <div class="form-group">
                                <!-- Username -->
                                <label>Username</label>
                                <div class="controls">
                                    <input type="text" id="username" name="username" placeholder="" class="form-control input-xlarge ">
                                </div>
                            </div>
                            <div class="form-group">
                                <!-- Password-->
                                <label for="password">Password</label>
                                <div class="controls">
                                    <input type="password" id="password" name="password" placeholder="" class="form-control input-xlarge">
                                </div>
                            </div>
                            <div class="form-group">
                                <!-- Button -->
                                <div class="controls">
                                    <button class="btn btn-info">Login</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">   
        <!-- Custom styles -->  
        <link href="css/dashboard.css" rel="stylesheet" type="text/css"/>   
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>