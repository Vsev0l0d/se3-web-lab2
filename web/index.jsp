<%@ page contentType="text/html;charset=UTF-8"%>
<html style="height: 100%">
<head>
    <meta charset="UTF-8">
    <title>Lab 2</title>

    <script src="main.js"></script>
    <script src="interactiveObject.js"></script>
    <script src="upend.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body onload="draw()" style="background-color:#e9ecef; min-height: 100vh;">
<header>
    <nav class="navbar navbar-dark bg-dark">
        <span class="navbar-text">Вариант 3136</span>
        <span style="position: absolute; transform: translateX(-50%); left: 50%; color: transparent">I am Batman</span>
        <span class="navbar-text">Канторов Всеволод, P3212</span>
    </nav>
</header>
<div class="container">
    <canvas width="350px" height="350px" id="canvas" style="background-image: url('${pageContext.request.contextPath}/image/batman.png')"></canvas>
    <div class="container">
        <form method="get" action="controllerServlet" class="form-group">
            <div class="input-group my-2">
                <span id="labelX" class="input-group-text">X:</span>
                <div class="btn-group">
                    <button type="button" class="btn btn-secondary" id="x-5" onclick="xChoose('-5')">-5</button>
                    <button type="button" class="btn btn-secondary" id="x-4" onclick="xChoose('-4')">-4</button>
                    <button type="button" class="btn btn-secondary" id="x-3" onclick="xChoose('-3')">-3</button>
                    <button type="button" class="btn btn-secondary" id="x-2" onclick="xChoose('-2')">-2</button>
                    <button type="button" class="btn btn-secondary" id="x-1" onclick="xChoose('-1')">-1</button>
                    <button type="button" class="btn btn-secondary" id="x0" onclick="xChoose('0')">0</button>
                    <button type="button" class="btn btn-secondary" id="x1" onclick="xChoose('1')">1</button>
                    <button type="button" class="btn btn-secondary" id="x2" onclick="xChoose('2')">2</button>
                    <button type="button" class="btn btn-secondary" id="x3" onclick="xChoose('3')">3</button>
                </div>
                <input type="hidden" name="x" id="X_field">
            </div>

            <div class="input-group my-2">
                <label id="labelY" for="Y_field" class="input-group-text">Y:</label>
                <input type="text" class="form-control" id="Y_field" name="y" maxlength="8" onchange="update()" oninput=removeClaimsForY()>
            </div>
            <div id="fieldMessageY"></div>

            <div class="input-group my-2">
                <span id="labelR" class="input-group-text">R:</span>
                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                    <div class="align-bottom mx-2">
                        <input id="radio-1" type="radio" name="r_field" value="1" onclick="update()">
                        <label for="radio-1">1</label>
                    </div>
                    <div class="align-bottom mx-2">
                        <input id="radio-2" type="radio" name="r_field" value="2" onclick="update()">
                        <label for="radio-2">2</label>
                    </div>
                    <div class="align-bottom mx-2">
                        <input id="radio-3" type="radio" name="r_field" value="3" onclick="update()" checked>
                        <label for="radio-3">3</label>
                    </div>
                    <div class="align-bottom mx-2">
                        <input id="radio-4" type="radio" name="r_field" value="4" onclick="update()">
                        <label for="radio-4">4</label>
                    </div>
                    <div class="align-bottom mx-2">
                        <input id="radio-5" type="radio" name="r_field" value="5" onclick="update()">
                        <label for="radio-5">5</label>
                    </div>
                </div>
            </div>

            <button type="submit" id="submitButton" class="btn btn-dark">Отправить</button>
            <button type="button" class="btn btn-dark" id="upendButton">Поворот на 180</button>
        </form>
    </div>
</div>
<jsp:useBean id="jb" class="models.JavaBean" scope="session"/>
<div class="container-md">
    <%=jb.makeTable()%>
</div>
</body>
</html>
