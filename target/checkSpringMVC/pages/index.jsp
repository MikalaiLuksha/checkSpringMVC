<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags/form" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<body>
<nav class="navbar navbar-light" style="background-color: #f4ac63; height: 55px">
    <form class="container-fluid justify-content-start">
        <div class="row">
            <div class="col pr-5">
                <p>
                    <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                            data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample"
                            style="width: 220px">
                        <c:if test="${!sessionScope.key1}">
                            Enter or Registration
                        </c:if>
                        <c:if test="${sessionScope.key1}">
                            ${sessionScope.currentUser.name}
                        </c:if>
                    </button>
                </p>
            </div>

<c:if test="${sessionScope.key1}">
            <div class="col pr-5">
                <p>
                    <a class="btn btn-primary" href="" role="button">Play</a>
                </p>
            </div>
            </c:if>

            <c:if test="${sessionScope.admin}">
            <div class="col pr-5">
                <p>
                    <a class="btn btn-primary" href="/userList" role="button">Users List</a>
                </p>
            </div>
            <div class="col pr-5">
                <p>
                    <a class="btn btn-primary" href="/createBoard" role="button" style="width: 220px">Create board</a>
                </p>
            </div>
            </c:if>

    </form>
</nav>
<div class="collapse" id="collapseExample">
    <div class="card card-body">
        <c:if test="${!sessionScope.key1}">
            <spring:form class="px-4 py-3" action="/user/auth" method="post" modelAttribute="userDTO">
                <div class="mb-3">
                    <label for="exampleDropdownFormLogin" class="form-label">Login</label>
                    <spring:input path="login" class="form-control w-25 p-1" id="exampleDropdownFormLogin"
                           placeholder="Login"/>
                    <spring:errors path="login"/>
                </div>
                <div class="mb-3">
                    <label for="exampleDropdownFormPassword1" class="form-label">Password</label>
                    <spring:input path="password" class="form-control w-25 p-1"
                      id="exampleDropdownFormPassword1" placeholder="Password"/>
                    <spring:errors path="password"/>
                </div>
                <div class="mb-3">
                </div>
                <spring:button type="submit" class="btn btn-primary">Sign in</spring:button>
            </spring:form>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="/user/reg">Registration</a>
            <a class="dropdown-item" href="#">Forgot password?</a>
        </c:if>
        <c:if test="${sessionScope.key1}">
            <a class="dropdown-item" href="user/profiles/${sessionScope.currentUser.id}">Profiles</a>
            <a class="dropdown-item" href="/user/logout">Logout</a>
        </c:if>
    </div>
</div>

<c:if test="${keyReg}">
    <div class="offset-sm-1">
        <div class="alert alert-danger w-25" role="alert">
            <strong>${messageA}</strong>
        </div>
    </div>
</c:if>

${userNot}


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
