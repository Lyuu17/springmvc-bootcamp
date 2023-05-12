<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="wl" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
  <title><fmt:message key="label.login.title"/></title>
  <tags:bootstrap/>
</head>
<body>
  <div class="container d-flex align-items-center min-vh-100">
    <div class="row col-lg-5 align-middle align-items-center m-auto ">
      <c:if test="${not empty error or not empty message}">
        <h5 class="text-danger mb-3">${error}${message}</h5>
      </c:if>

      <wl:form method="post">
        <div class="mb-3">
          <label for="username" class="form-label"><fmt:message key="label.user"/></label>
          <input type="text" id="username" name="username" class="form-control"/>
        </div>

        <div class="mb-3">
          <label for="password" class="form-label"><fmt:message key="label.password"/></label>
          <input type="password" id="password" name="password" class="form-control"/>
        </div>

        <security:csrfInput/>

        <div class="d-flex flex-row justify-content-center mb-2">
          <button class="btn btn-primary"><fmt:message key="label.login.button"/></button>
        </div>
      </wl:form>
    </div>
  </div>
</body>
</html>
