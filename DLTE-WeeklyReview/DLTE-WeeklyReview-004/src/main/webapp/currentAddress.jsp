<%--
  Created by IntelliJ IDEA.
  User: xxmanoka
  Date: 3/26/2023
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <title>Current Address</title>
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
        <p>New Feature Added - You can now view permament and current addresses in separate windows </p>
    </marquee>
</div>
<div class="row justify-content-center">
    <div class="col-lg-6 col-sm-12 align-self-center">
        <h1 class="text-info bg-info-subtle text-center rounded-5 mt-2">Current Address of ${param['id']}</h1>
        <%@ taglib prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>
        <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
        <db:setDataSource var="studentDb" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user = "ABHISHEK MANOJ" password="J@nuary200!"/>
        <db:query var="profiles" sql="select door_no,street,city,state,pincode from address_e,map_address where map_address.regno = ? and map_address.address_id=address_e.address_id and address_e.type_address = ?" dataSource="${studentDb}">
            <db:param value="${param['id']}"/>
            <db:param value="Current"/>
        </db:query>
        <div class="table-responsive">
            <table class="table text-info table-striped p-2 rounded-3 shadow-lg text-nowrap" cellspacing="1px" cellpadding="1px">
                <thead class="bg-success-subtle">
                <tr>
                    <th>Door No</th><th>Street</th>
                    <th>City</th><th>State</th><th>Pin Code</th>
                </tr>
                </thead>
                <tbody class="bg-light">
                <core:forEach var="student" items="${profiles.rows}">
                    <tr>
                        <td>${student.door_no}</td><td>${student.street}</td>
                        <td>${student.city}</td><td>${student.state}</td><td>${student.pincode}</td>
                    </tr>
                </core:forEach>
                </tbody>
            </table>
        </div>
        <a class="btn btn-dark float-end m-2" href="insert.jsp">
            <i class="bi bi-newspaper"></i>New Student
        </a>
        <a class="btn btn-secondary float-end m-2" href="dashboard.jsp">
            <i class="bi bi-layer-backward"></i>Back to Dashboard
        </a>
    </div>
</div>
</div>
</div>
<%}
else{
    response.sendRedirect("authorize.jsp");
}%>
</body>
</html>
