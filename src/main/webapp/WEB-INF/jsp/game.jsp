<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tags:bootstrap/>
<html>
<head>
  <c:choose>
    <c:when test="${empty game}">
      <title><fmt:message key="label.game.notfound"/></title>
    </c:when>
    <c:otherwise>
      <title>${game.title}</title>
    </c:otherwise>
  </c:choose>
  <script type="text/javascript" src="/js/main.js"></script>
</head>
<body>

  <c:choose>
    <c:when test="${empty game}">
      <h1><fmt:message key="label.game.notfound"/></h1>
    </c:when>
    <c:otherwise>
      <div class="m-4">
        <tags:alertSuccess/>

        <div class="border">
          <div class="bg-primary p-sm-2">
            <h2 class="text-white">${game.title}</h2>
          </div>
          <div class="d-flex flex-column" id="game-data-container-row" data-steamid="${game.steamId}">
            <div class="d-flex flex-row border-bottom" id="game-data-container-col" data-steamid="${game.steamId}">
              <div class="flex-column w-75 mb-2 mt-2 border-start">
                <div class="p-sm-2">
                  <ul class="list-group">
                    <li class="list-group-item">GameID: ${game.id}</li>
                    <li class="list-group-item">SteamID: ${game.steamId}</li>
                  </ul>
                </div>
                <div class="p-sm-3 border-top">
                  <p>${game.description}</p>
                </div>
              </div>
            </div
          </div>
        </div>
      </div>
    </c:otherwise>
  </c:choose>
</body>
</html>
