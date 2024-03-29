<%--
  Created by IntelliJ IDEA.
  User: xxmanoka
  Date: 3/20/2023
  Time: 2:33 PM
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
    <title>Customer Login </title>
</head>
<body>
<!-- TITLE BAR AND LOGO -->
<nav class="col-lg-12 col-sm-0 navbar navbar-expand-lg navbar-light text-bg-light">
    <div class="container-fluid">
        <img class="col-lg-4 col-sm-12" src="/files/sbilogopng.png" width="400px" height="100px">
        <!-- <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button> -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="FEA005home.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="FEA005login.html">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FEA005new.html">New Transactions</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FEA005list.html">List of Transactions</a>
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
<div class="text-warning h-100">
    <marquee direction="left" class="bg-danger">
        <p>You can now create and update your transactions through the website. You can also view the list of transactions </p>
    </marquee>
</div>

<div class="container bg-info p-3">
    <!-- Login Card -->
    <div class="row p-5">
        <form class="col-lg-4 card p-4 text-bg-light rounded-5  mt-3">
            <h5 class="card-title text-bg-primary rounded-5 text-center p-2">Login</h5>
            <div class="form-group mt-5">
                <label>Username :</label>
                <input type="text" class="form-control mt-2" placeholder="Enter your username">
            </div>
            <div class="form-group">
                <label class="mt-3">Password :</label>
                <input type="password" class="form-control mt-1" placeholder="Enter password" id="myInput">
            </div>
<%--            <div class="form-group  mt-3">--%>
<%--                <input type="checkbox" onclick="myFunction()">Show Password--%>
<%--            </div>--%>
            <div class="d-flex justify-content-center mt-5">
                <button type="button" value="submit" class="btn btn-outline-primary m-3">Submit</button>
                <button type="button" value="reset" class="btn btn-outline-danger m-3">Reset</button>
            </div>
        </form>

        <!-- Carousel begins here -->
        <div class="col-lg-8">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/files/login.png" class="d-block w-100 justify-content-center" alt="..." height="500px">
                    </div>
                    <div class="carousel-item">
                        <img src="/files/sbi1.jpg" class="d-block w-100" alt="..." height="500px">
                    </div>
                    <div class="carousel-item">
                        <img src="/files/sbi2.jpg" class="d-block w-100" alt="..." height="500px">
                    </div>
                    <div class="carousel-item">
                        <img src="/files/sbi3.jpg" class="d-block w-100" alt="..." height="500px">
                    </div>
                    <div class="carousel-item">
                        <img src="/files/sbi4.png" class="d-block w-100" alt="..." height="500px">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>
</div>
<div>

</div>
</div>
</body>
</html>
