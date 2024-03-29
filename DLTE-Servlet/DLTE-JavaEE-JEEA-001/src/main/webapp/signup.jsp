<%--
  Created by IntelliJ IDEA.
  User: xxmanoka
  Date: 3/20/2023
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="/files/fav.png">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <title>Create Account</title>
</head>
<body>
<!-- TITLE BAR AND LOGO -->
<nav class="col-lg-12 col-sm-0 navbar navbar-expand-lg navbar-light text-bg-light">
    <div class="container-fluid">
        <img class="col-lg-4 col-sm-12" src="/files/sbilogopng.png" width="400px" height="100px">

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="FEA005login.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FEA005login.html">Login</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-info" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<!-- Marquee moving left just below Nav Bar -->
<div class="text-warning">
    <marquee direction="left" class="bg-danger">
        <p>You can now create and update your transactions through the website. You can also view the list of transactions </p>
    </marquee>
</div>

<!-- Content of the page -->
<div class="container bg-info">
    <div class="row p-2 justify-content-center">
        <!-- Left Banner  -->
        <div class="card col-lg-3 rounded-5 mt-2 me-3">
            <h6 class="card-title text-success text-center display-6 mt-1 fw-bold">
                What's New?
            </h6>
            <div class="text-warning">
                <marquee direction="up" class="h-100">
                    <p><a href="#">1. SBI new special fixed deposit (FD) scheme is a limited period offer which will expire next month</a></p>
                    <p><a href="#">2. State Bank of India Recruitment for Various Posts: Date Extended till 24 Feb</a></p>
                    <p><a href="#">3. SBI new special fixed deposit (FD) scheme is a limited period offer which will expire next month</a></p>
                    <p><a href="#">4. SBI new special fixed deposit (FD) scheme is a limited period offer which will expire next month</a></p>
                    <p><a href="#">5. SBI new special fixed deposit (FD) scheme is a limited period offer which will expire next month</a></p>
                </marquee>
            </div>
        </div>

        <!-- Form for New Transactions -->
        <form class="col-lg-5 card p-4 text-bg-light rounded-5 mt-2 me-3">
            <h5 class="card-title text-bg-primary rounded-5 text-center p-2">Create Account</h5>
            <div class="form-group mt-3">
                <label>Customer Name :</label>
                <input type="text" class="form-control mt-2" placeholder="Enter your name">
            </div>
            <div class="form-group">
                <label class="mt-3">Enter Password :</label>
                <input type="password" class="form-control mt-1" placeholder="Enter password">
            </div>
            <div class="form-group">
                <label class="mt-3">Confirm Password :</label>
                <input type="text" class="form-control mt-1" placeholder="Re-enter password">
            </div>
            <div class="form-group">
                <label class="mt-3">Account Balance :</label>
                <input type="number" class="form-control mt-1" placeholder="Enter balance">
            </div>
            <div class="d-flex justify-content-center mt-3">
                <button type="submit" formaction="http://127.0.0.1:5501/FEA005list.html" class="btn btn-outline-primary m-3">Submit</button>
                <button type="reset" class="btn btn-outline-danger m-3">Reset</button>
            </div>
        </form>
        <!-- Right Banner -->
        <div class="col-lg-3 card p-4 mt-2 rounded-5">
            <div class="card p-3 rounded-5 bg-warning shadow-lg me-2">
                <img class="card-img w-100" src="/files/sbitrans.webp">
                <h5 class="card-title mt-1">Make Your Transactions and Get Mini Statements</h5>
                <div class="card-body justify-content-center">
                    <h5 class="row justify-content-center">Experience Mobile banking of SBI</h5>
                    <a class="float-end btn btn-outline-dark mt-3" href="https://www.onlinesbi.sbi/">Know more</a>
                </div>
            </div>
            <img src="/files/sbibank.jpg" class="rounded-5 mt-5" width="220px" height="200px"/>
        </div>
    </div>
</div>
</body>
</html>
