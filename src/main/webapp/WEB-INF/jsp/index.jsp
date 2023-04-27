<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:bootstrap/>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <div class="m-4">
    <table class="table table-bordered">

      <thead>
      <tr>
        <th>ID</th>
        <th>Title</th>
      </tr>
      </thead>

      <tbody>
      <c:forEach items="${gameList}" var="game">
        <tr>
          <td>${game.id}</td>
          <td>${game.title}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>