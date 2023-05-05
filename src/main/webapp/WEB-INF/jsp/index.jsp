<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tags:bootstrap/>
<html>
<head>
  <title><fmt:message key="label.game.games"/></title>
  <script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
  <div class="m-lg-5">
    <tags:alertSuccess/>

    <div class="d-flex flex-row justify-content-center mb-2">
      <button class="btn btn-primary" id="add-game-btn"><fmt:message key="label.game.add"/></button>
    </div>

    <form method="get" action="/game/search/">
      <div class="input-group mb-3">
        <input id="search-input" type="text" class="form-control"
               placeholder="<fmt:message key="label.game.search.placeholder"/>"
               aria-label="Search a game" name="title">
        <div class="input-group-append">
          <button class="btn btn-outline-primary"><fmt:message key="label.game.search"/></button>
        </div>
      </div>
    </form>

    <table class="table table-bordered">

      <thead>
      <tr>
        <th class="text-center">ID</th>
        <th><fmt:message key="label.title"/></th>
        <th class="text-center"><fmt:message key="label.actions"/></th>
      </tr>
      </thead>

      <tbody>
      <c:forEach items="${gameList}" var="game">
        <tr>
          <td class="text-center align-middle">${game.id}</td>
          <td class="col-10 align-middle"><a href="/game/${game.id}">${game.title}</a></td>
          <td class="d-flex flex-row justify-content-center">
            <button class="btn btn-primary edit-game-btn" data-id="${game.id}"><fmt:message key="label.edit"/></button>
            <button class="btn ms-sm-2 btn-danger delete-game-btn" data-id="${game.id}"><fmt:message
                key="label.delete"/></button>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>