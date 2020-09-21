<%@ page import="models.Entry" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Lab 2</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body style="background-color:#e9ecef">
<header>
    <nav class="navbar navbar-dark bg-dark">
        <span class="navbar-text">Вариант 3136</span>
        <span style="position: absolute; transform: translateX(-50%); left: 50%; color: transparent">I am Batman</span>
        <span class="navbar-text">Канторов Всеволод, P3212</span>
    </nav>
</header>
<jsp:useBean id="jb" class="models.JavaBean" scope="session"/>
<%Entry entry = jb.getLastEntry();%>
<div class="jumbotron">
    <p class="lead">X: <%=entry.getX()%></p>
    <p class="lead">Y: <%=entry.getY()%></p>
    <p class="lead">R: <%=entry.getR()%></p>
    <hr class="my-4">
    <h4>Результат: <%=entry.isResult()%></h4>
    <hr class="my-4">
    <form action="controllerServlet">
        <button type="submit" class="btn btn-dark btn-lg">Назад</button>
    </form>
</div>
</body>
</html>
