<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${status == null }">
<h4>Add employee to a project</h4>
<form action="${pageContext.request.contextPath }/addtoproject?emp_name=<c:out value="${emp_name }" />" method="GET" >
Enter employee name : <input type="text" name="emp_name" /> <br>
<input type="submit" value="Go" />
</form>
</c:if>

<c:if test='${status == "fromEmp" }'>
	Add <c:out value="${emp_name }" /> to a project?
	<a href="${pageContext.request.contextPath }/addNewEmpToProject"><input type="button" value="Yes"></a>
	<a href="${pageContext.request.contextPath }/employee"> <input type="button" value="No"></a>
</c:if>
<c:if test='${status == "true" }'>
<h3> Select a project </h3>
	<c:forEach var="p" items="${list }">
		<a href="#"><c:out value="${p.getProj_name() }" /> </a>
	</c:forEach>
</c:if>


</body>
</html>