<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="wl" uri="http://www.springframework.org/tags/form" %>
<tags:bootstrap/>
<html>
<head>
  <title>Add a new Game</title>
</head>
<body>

  <div class="m-4">
    <div class="border">
      <div class="bg-primary p-sm-2">
        <h2 class="text-white">New Game</h2>
      </div>
      <div class="p-sm-3 border-top">
        <wl:form method="post" modelAttribute="game">
          <div class="mb-3">
            <wl:label path="title" cssClass="form-label">Game Title</wl:label>
            <wl:input path="title" cssClass="form-control"/>
          </div>

          <div class="mb-3">
            <wl:label path="description" cssClass="form-label">Game Description</wl:label>
            <wl:input path="description" cssClass="form-control"/>
          </div>

          <div class="mb-3">
            <wl:label path="steamId" cssClass="form-label">SteamID</wl:label>
            <wl:input path="steamId" cssClass="form-control"/>
          </div>

          <div class="d-flex flex-row justify-content-center mb-2">
            <button class="btn btn-primary">Add game</button>
          </div>
        </wl:form>
      </div>
    </div>
  </div>
</body>
</html>
