<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="wl" uri="http://www.springframework.org/tags/form" %>
<tags:bootstrap/>
<html>
<head>
  <title>Edit Game</title>
</head>
<body>

  <c:choose>
    <c:when test="${empty game}">
      <h1>Game not found</h1>
    </c:when>
    <c:otherwise>
      <div class="m-4">
        <div class="border">
          <div class="bg-primary p-sm-2">
            <h2 class="text-white">Editing ${game.title}</h2>
          </div>
          <div class="p-sm-3 border-top">
            <wl:form method="post" modelAttribute="game">
              <div class="mb-3">
                <wl:label path="title" cssClass="form-label">Game Title</wl:label>
                <wl:input path="title" cssClass="form-control"/>
                <wl:errors path="title" cssClass="text-danger"></wl:errors>
              </div>

              <div class="mb-3">
                <wl:label path="description" cssClass="form-label">Game Description</wl:label>
                <wl:input path="description" cssClass="form-control"/>
                <wl:errors path="description" cssClass="text-danger"></wl:errors>
              </div>

              <div class="mb-3">
                <wl:label path="steamId" cssClass="form-label">SteamID</wl:label>
                <wl:input path="steamId" cssClass="form-control"/>
                <wl:errors path="steamId" cssClass="text-danger"></wl:errors>
              </div>

              <div class="d-flex flex-row justify-content-center mb-2">
                <button class="btn btn-primary">Edit game</button>
              </div>
            </wl:form>
          </div>
        </div>
      </div>
    </c:otherwise>
  </c:choose>
</body>
</html>
