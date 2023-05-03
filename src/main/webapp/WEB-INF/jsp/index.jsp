<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:bootstrap/>
<html>
<head>
  <title>Games</title>
  <script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
  <div class="m-lg-5">
    <form method="get" action="/game/search/">
      <div class="input-group mb-3">
        <input id="search-input" type="text" class="form-control" placeholder="Search a game..."
               aria-label="Search a game" name="title">
        <div class="input-group-append">
          <button class="btn btn-outline-primary">Search</button>
        </div>
      </div>
    </form>

    <table class="table table-bordered">

      <thead>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Actions</th>
      </tr>
      </thead>

      <tbody>
      <c:forEach items="${gameList}" var="game">
        <tr>
          <td>${game.id}</td>
          <td><a href="/game/${game.id}">${game.title}</a></td>
          <td>
            <button class="btn btn-danger delete-game-btn" data-id="${game.id}">Delete</button>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>