<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="wl" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav class="navbar navbar-expand-lg bg-light border-bottom">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Steam</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <security:authorize access="isAuthenticated()">
        <div class="nav-item dropdown ms-auto">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <security:authentication property="principal.username"/>
          </a>
          <ul class="dropdown-menu">
            <li>
              <wl:form method="post" action="/logout" cssClass="m-0">
                <button class="dropdown-item"><fmt:message key="label.logout.button"/></button>
              </wl:form>
            </li>
          </ul>
        </div>
      </security:authorize>

      <security:authorize access="isAnonymous()">
        <div class="nav-item dropdown ms-auto">
          <a href="/login">
            <button class="btn btn-primary"><fmt:message key="label.login.button"/></button>
          </a>
        </div>
      </security:authorize>
    </div>
  </div>
</nav>