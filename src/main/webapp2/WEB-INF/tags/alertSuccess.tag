<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="alertMessageSuccess" type="java.lang.String"--%>
<c:if test="${not empty alertMessageSuccess}">
  <div class="alert alert-success alert-dismissible fade show" role="alert">
      ${alertMessageSuccess}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
</c:if>