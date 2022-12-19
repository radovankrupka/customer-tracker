<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.springdemo.util.SortUtils" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Customer List</title>
</head>
<body>

<h1>CUSTOMER LIST</h1>

<input type="button" value="Add customer"
onclick="window.location.href='addCustomer'; return false"
/>

<form:form action="search" method="get">

    Search for customer: <input type="text" name="searchText">
    <input type="submit" value="SEARCH">

</form:form>

<!-- construct sort links -->
<c:url var="sortLinkFirstName" value="/customer/list">
    <c:param name="sort" value="<%= SortUtils.FIRST_NAME %>" />
</c:url>

<c:url var="sortLinkLastName" value="/customer/list">
    <c:param name="sort" value="<%=SortUtils.LAST_NAME %>" />
</c:url>

<c:url var="sortLinkEmail" value="/customer/list">
    <c:param name="sort" value="<%= SortUtils.EMAIL %>" />
</c:url>

<c:url var="sortLinkID" value="/customer/list">
    <c:param name="sort" value="<%= SortUtils.ID %>" />
</c:url>



<table id = "customers" class="table table-primary table-hover mx-auto w-75" >
    <tr>
        <th><a href="${sortLinkID}">ID</a></th>
        <th><a href="${sortLinkFirstName}">Name</a></th>
        <th><a href="${sortLinkLastName}">Surname</a></th>
        <th><a href="${sortLinkEmail}">Email</a></th>
        <th></th>


    </tr>


    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.ID}</td>
            <td>${customer.first_name}</td>
            <td>${customer.last_name}</td>
            <td>${customer.email}</td>
            <td>
                <c:url var="updateLink" value="/customer/updateCustomer">
                    <c:param name="ID" value="${customer.ID}"/>
                </c:url>
                <a href="${updateLink}"> UPDATE </a> ||

                <c:url var="deleteLink" value="/customer/deleteCustomer">
                    <c:param name="ID" value="${customer.ID}"/>
                </c:url>
                <a onclick="if (!(confirm('Are you sure you want to delete customer?'))) return false" href="${deleteLink}"> DELETE </a>

            <%-- <a href="updateCustomer?ID=${customer.ID}"> UPDATE </a>--%>

            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>
