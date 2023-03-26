<%--
  Created by IntelliJ IDEA.
  User: xxmanoka
  Date: 3/26/2023
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <title>List of Student Details</title>
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
<div class="row justify-content-center">
    <div class="col-lg-6 col-sm-12 align-self-center">
        <h1 class="text-info bg-info-subtle text-center rounded-5 mt-2">Student Records</h1>
        <%--    <div class="alert alert-info">--%>
        <%--        <h2 class="text-info text-center">Find Student</h2>--%>
        <%--        <div class="row justify-content-between">--%>
        <%--            <div class="col-lg-6 col-sm-12"><input type="text" name="regno" placeholder="Registration Number" class="form-control" /></div>--%>
        <%--            <div class="col-lg-6 col-sm-12"><input type="text" onchange="collect(this.value)" name="name" placeholder="Student Name" class="form-control" /></div>--%>
        <%--        </div>--%>
        <%--    </div>--%>
        <%@ taglib prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>
        <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
        <db:setDataSource var="studentDb" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user = "ABHISHEK MANOJ" password="J@nuary200!"/>
        <db:query var="profiles" sql="select * from student_e" dataSource="${studentDb}"/>
        <div class="table-responsive">
            <table class="table text-info table-striped p-2 rounded-3 shadow-lg text-nowrap" cellspacing="1px" cellpadding="1px">
                <thead class="bg-success-subtle">
                <tr>
                    <th>Reg. No.</th><th>Student Name</th>
                    <th>Student Age</th><th>Contact No</th><th>Email ID</th>
                    <th>Address</th>
                </tr>
                </thead>
                <tbody class="bg-light">
                <core:forEach var="student" items="${profiles.rows}">
                    <tr>
                        <td>${student.regno}</td><td>${student.name}</td>
                        <td>${student.age}</td><td>${student.contact}</td><td>${student.email}</td>

                        <td>
                            <a href="currentAddress.jsp?id=${student.regno}" class="btn btn-warning">
                                <i class="bi bi-house-check"></i>
                            </a>
                            <a href="permanentAddress.jsp?id=${student.regno}" class="btn btn-success">
                                <i class="bi bi-house-door-fill"></i>
                            </a>
                        </td>
                    </tr>
                </core:forEach>
                </tbody>
            </table>
        </div>
        <a class="btn btn-outline-success float-end m-2" href="insert.jsp">
            <i class="bi bi-newspaper"></i>New Student
        </a>
        <a class="btn btn-outline-danger float-end m-2" href="logout">
            <i class="bi bi-newspaper"></i>Logout
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
