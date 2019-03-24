<%-- 
    Document   : addcourse
    Created on : Dec 10, 2018, 1:13:49 PM
    Author     : Siron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>

    <%@include file="admin/title.jsp" %>
    <!--this is static or compile time include -->
    
    <jsp:include page="admin/title.jsp"/>
    <!--dynamic include includes this file by translating everytime the response is being created-->

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
      

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Register new user </h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div class="row">
                <!-- add course information form-->
                <div class="row">
                    
                    
                                <div class="col-lg-9">
                                    <form role="form" action="${pageContext.request.contextPath}/register" method="post" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label>First Name</label>
                                            <input class="form-control" name="firstname" type="text" placeholder="Enter first name here" required>
                                           
                                        </div>
                                        <div class="form-group">
                                            <label>Last Name </label>
                                            <input class="form-control" name="lastname" type="text"  placeholder="Enter last name here" required>
                                        </div>
                                      
                                            <div class="form-group">
                                            <label>Date of birth</label>
                                            <input class="form-control" type="date" name="dob" required>
                                        </div>
                                         <div class="form-group">
                                            <label>Upload image</label>
                                            <input class="form-control" type="file" name="image" placeholder="Select user image" required>
                                            <p class="text-danger">${err_upload}</p>
                                        </div>
                                          <div class="form-group">
                                            <label>E-mail</label>
                                            <input class="form-control" type="email" name="email" placeholder="Enter email  here" required>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Password</label>
                                            <input class="form-control" type="password" name="password"  required>
                                            <p class="text-danger">${err_pass}</p>
                                        </div>
                                          <div class="form-group">
                                            <label> Confirm Password</label>
                                            <input class="form-control" type="password" name="cpassword"  required>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Authority</label>
                                            <select class="form_control" name="authority">
                                                <option value="ROLE_ADMIN">ADMINSTRATOR </option>
                                                <option value="ROLE_USER"> USER </option>
                                            </select>
                                        </div>
                                        
                                     
                                        
                                        
                                      
                       
                                        
                                        <button type="submit" class="btn btn-default">Submit Button</button>
                                        <button type="reset" class="btn btn-default">Reset Button</button>
                                    </form>
                                </div>
            </div>
            
           
           
                    
                   
                        <!-- /.panel-body -->
                       
                        <!-- /.panel-footer -->
              
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
   
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/raphael/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>

