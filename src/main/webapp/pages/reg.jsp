<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags/form" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<body>
<spring:form action="/user/reg" method="post" class= "offset-sm-1" modelAttribute="user">
    <div class="form-group text-light">
        <label for="Name2" class="w-25 p-1">Name</label>
        <spring:input class="form-control w-25 p-1" id="Name2" path="name"/>
        <spring:errors path="name"/>
    </div>
    <div class="form-group text-light">
        <label for="inputLogin1" class="w-25 p-1">login</label>
        <spring:input class="form-control w-25 p-1" id="inputLogin1" path="login"/>
        <spring:errors path="login"/>
    </div>
    <div class="form-group text-light">
        <label for="exampleInputPassword1" class="w-25 p-1">Password</label>
        <spring:input class="form-control w-25 p-1" id="exampleInputPassword1" path="password"/>
        <spring:errors path="password"/>
    </div>
    <div class="mb-3">
    </div>
    <spring:button type="submit" class="btn btn-primary offset-sm-2">Submit</spring:button>
</spring:form>



<style>
    body {
        background: url("https://i1.wallbox.ru/wallpapers/main/201134/2560h1600-tekstura-oboi-e710001.jpg")
    }
</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
