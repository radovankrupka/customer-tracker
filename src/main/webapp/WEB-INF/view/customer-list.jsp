
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Customer List</title>
</head>
<body>

<h1>CUSTOMER LIST</h1>

<table id = "customers" class="table table-primary table-hover mx-auto w-75" >
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <%--<th></th><th></th><th></th>--%>

    </tr>


    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.ID}</td>
            <td>${customer.first_name}</td>
            <td>${customer.last_name}</td>
            <td>${customer.email}</td>
        </tr>
    </c:forEach>


</table>

</body>
</html>
