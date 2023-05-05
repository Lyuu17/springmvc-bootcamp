<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="wl" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<tags:bootstrap/>
<html>
<head>
  <title><fmt:message key="label.game.edit"/></title>
</head>
<body>

  <c:choose>
    <c:when test="${empty game}">
      <h1><fmt:message key="label.game.notfound"/></h1>
    </c:when>
    <c:otherwise>
      <div class="m-4">
        <div class="border">
          <div class="bg-primary p-sm-2">
            <h2 class="text-white"><fmt:message key="label.editing"/> ${game.title}</h2>
          </div>
          <div class="p-sm-3 border-top">
            <wl:form method="post" modelAttribute="game">
              <div class="mb-3">
                <wl:label path="title" cssClass="form-label"><fmt:message key="label.game.title"/></wl:label>
                <wl:input path="title" cssClass="form-control"/>
                <wl:errors path="title" cssClass="text-danger"></wl:errors>
              </div>

              <div class="mb-3">
                <wl:label path="description" cssClass="form-label"><fmt:message
                    key="label.game.description"/></wl:label>
                <wl:input path="description" cssClass="form-control"/>
                <wl:errors path="description" cssClass="text-danger"></wl:errors>
              </div>

              <div class="mb-3">
                <wl:label path="steamId" cssClass="form-label">SteamID</wl:label>
                <wl:input path="steamId" cssClass="form-control"/>
                <wl:errors path="steamId" cssClass="text-danger"></wl:errors>
              </div>

              <div class="d-flex flex-row justify-content-center mb-2">
                <button class="btn btn-primary"><fmt:message key="label.game.edit"/></button>
              </div>
            </wl:form>
          </div>
        </div>
      </div>
    </c:otherwise>
  </c:choose>
</body>
</html>
