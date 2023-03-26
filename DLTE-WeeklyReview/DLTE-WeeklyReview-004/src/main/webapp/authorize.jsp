<%--
  Created by IntelliJ IDEA.
  User: xxmanoka
  Date: 3/23/2023
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <title>Login | Student Database</title>
</head>
<body class="bg-warning">
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
    <div class="row container-fluid justify-content-center">
        <form class="card col-lg-4 justify-content-center mt-5" action="authenticate" method="post" name="login">
            <h5 class="card-title text-center bg-primary-rounded-3 text-light">Student Login</h5>
            <div class="form-group">
                <label>Access Number:</label>
                <input type="number" class="form-control" placeholder="Admin access number" name="studentId" />
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control" name="studentPass" placeholder="Enter password" />
            </div>
            <div class="d-flex justify-content-around p-2">
                <input type="submit" class="col-2 btn btn-outline-success" value="Login"/>
                <input type="reset" class="col-2 btn btn-outline-danger" value="Clear"/>
            </div>
        </form>
    </div>
</body>
</html>
