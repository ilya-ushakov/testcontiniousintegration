<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>This is just small application </title>
</head>
<body>
 
<h2>Demo Asynch</h2>

<c:url var="addUrl" value="/add"/>

<form:form method="post" action="${addUrl}" commandName="employee">

    <table>
        <tr>
            <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
            <td><form:input path="lastname" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.add"/>"/>
            </td>
        </tr>
    </table>
</form:form>

<c:url var="showEmplUrl" value="/showEmpl"/>
<form:form method="post" action="${showEmplUrl}" commandName="employee">

    <table>
        <tr>
            <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
            <td><form:input path="lastname" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.find"/>"/>
            </td>
        </tr>
    </table>
</form:form>



<h3>Employees</h3>
<c:if  test="${!empty employeeList}">
    <table class="data">
        <tr>
            <th>Name</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${employeeList}" var="emp">
            <tr>
                <td>${emp.lastname}, ${emp.firstname} </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
 
</body>
</html>