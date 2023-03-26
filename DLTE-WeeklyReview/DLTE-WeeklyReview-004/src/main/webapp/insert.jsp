<%--
  Created by IntelliJ IDEA.
  User: xxmanoka
  Date: 3/23/2023
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <script src="/path/to/cdn/jquery.min.js"></script>
    <title>Insert Records</title>
</head>
<body class="bg-info">
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    if(session.getAttribute("admin")!=null){
%>
<!-- TITLE BAR AND LOGO -->
<nav class="col-lg-12 col-sm-0 navbar navbar-expand-lg navbar-light text-bg-light">
    <div class="container-fluid">
        <img class="col-lg-4 col-sm-12" src="" width="400px" height="100px">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link active" aria-current="page" href="">Home</a>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="newTransaction.html">New Transaction</a>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="#">Transaction Filter</a>--%>
                <%--                </li>--%>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-info" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<!-- Marquee moving left just below Nav Bar -->
<div class="text-warning" id="marq">
    <marquee direction="left" class="bg-danger">
        <p>New Feature Added - You can now view permament and current addresses in separate windows</p>
    </marquee>
</div>
<div class="container-fluid bg-info" id="main">
    <div class="row justify-content-around mt-2">
        <form name="insertion" method="post" action="insert" class="card col-lg-6 col-sm-10 rounded-5 py-3">
            <h5 class="card-title text-bg-warning rounded-3 text-center p-2 mt-3">Insert Student Details</h5>
            <div class="form-contents mt-3">
                <label>Student Registration Number:</label>
                <input type="text" placeholder="Enter registration number" class="form-control mt-1" name="regno" />
            </div>
            <div class="form-contents mt-3">
                <label>Student Name:</label>
                <input type="text" placeholder="Enter name" class="form-control mt-1" name="studentName" />
            </div>
            <div class="form-contents mt-3">
                <label>Age :</label>
                <input type="number" placeholder="Enter age" class="form-control mt-1" name="age" />
            </div>
            <div class="form-contents mt-3">
                <label>Contact Number:</label>
                <input type="number" placeholder="Enter mobile number" class="form-control mt-1" name="mobNumber" />
            </div>
            <div class="form-contents mt-3">
                <label>Email ID:</label>
                <input type="text" placeholder="Enter email" class="form-control mt-1" name="email"  />
            </div>
            <div class="form-contents mt-3">
                <label>Current Address:</label>
                <br>
                <label>Door No:</label>
                <input type="text" placeholder="Enter door number" class="form-control mt-1" name="cDoorNo" />
            </div>
            <div class="form-contents mt-3">
                <label>Street:</label>
                <input type="text" placeholder="Enter street" class="form-control mt-1" name="cStreet"  />
            </div>
            <div class="form-contents mt-3">
                <label>City:</label>
                <input type="text" placeholder="Enter city" class="form-control mt-1" name="cCity"  />
            </div>
            <div class="form-contents mt-3">
                <label>State:</label>
                <input type="text" placeholder="Enter state" class="form-control mt-1" name="cState"  />
            </div>
            <div class="form-contents mt-3">
                <label>PinCode:</label>
                <input type="number" placeholder="Enter pincode" class="form-control mt-1" name="cPin"  />
            </div>
            <div class="form-contents mt-3">
                <label>Permanent Address:</label>
                <br>
                <label>Door No:</label>
                <input type="text" placeholder="Enter door number" class="form-control mt-1" name="pDoorNo" />
            </div>
            <div class="form-contents mt-3">
                <label>Street:</label>
                <input type="text" placeholder="Enter street" class="form-control mt-1" name="pStreet"  />
            </div>
            <div class="form-contents mt-3">
                <label>City:</label>
                <input type="text" placeholder="Enter city" class="form-control mt-1" name="pCity"  />
            </div>
            <div class="form-contents mt-3">
                <label>State:</label>
                <input type="text" placeholder="Enter state" class="form-control mt-1" name="pState"  />
            </div>
            <div class="form-contents mt-3">
                <label>PinCode:</label>
                <input type="number" placeholder="Enter pincode" class="form-control mt-1" name="pPin"  />
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-outline-success m-2" id="submitButton" >Submit</button>
                <button type="reset" class="btn btn-outline-danger m-2">Reset</button>
            </div>
        </form>
    </div>
</div>
<%}
else{
    response.sendRedirect("authorize.jsp");
}%>
</body>
</html>
