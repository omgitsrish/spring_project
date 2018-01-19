<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sv" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${status == null }">
<h4>Add employee to a project</h4>
<sv:form action="${pageContext.request.contextPath }/addNewEmpToProject" method="GET" modelAttribute="employee" >
Select employee : <sv:select path = "emp_name">
                     <sv:option value = "NONE" label = "Select"/>
                     <sv:options items = "${listOfEmp}" itemValue="emp_id" itemLabel="emp_name" />
                  </sv:select>   
                  <input type="submit" value="Add to project"/>
</sv:form>
</c:if>

<c:if test='${status == "fromEmp" }'>
	Add <c:out value="${emp_name }" /> to a project?
	<a href="${pageContext.request.contextPath }/addNewEmpToProject"><input type="button" value="Yes"></a>
	<a href="${pageContext.request.contextPath }/employee"> <input type="button" value="No"></a>
</c:if>
<c:if test='${status == "true" }'>
<h3> Select a project </h3>

<sv:form action="${pageContext.request.contextPath }/addEmployeeToDb" method="GET" modelAttribute="project">
				 <sv:select path = "proj_name">
                     <sv:option value = "NONE" label = "Select"/>
                     <sv:options items = "${listOfProjects}" itemValue="proj_id" itemLabel="proj_name"/>
                  </sv:select>
                  <sv:input type="date" path="proj_start_date"  placeholder="From date" />
                  <sv:input type="date" path="proj_end_date" placeholder="To date" />
                  <input type="submit" value="Add to project" />   
</sv:form>
	
	
	
</c:if>


</body>
</html>