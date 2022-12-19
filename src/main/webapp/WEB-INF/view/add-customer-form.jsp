<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new customer</title>
</head>
<body>


<form:form action="saveCustomer" modelAttribute="customer" method="post" >
    <table>
        <tbody>
        <form:hidden path="ID"/>

        <tr>
            <td><label> FIRST NAME: </label></td>
            <td> <form:input path="first_name" /> </td>
        </tr>

        <tr>
            <td><label> LAST NAME: </label></td>
            <td> <form:input path="last_name" /> </td>
        </tr>

        <tr>
            <td><label> EMAIL: </label></td>
            <td> <form:input path="email" /> </td>
        </tr>

        <tr>
            <td><label></label></td>
            <td> <input type="submit" value="SAVE"> </td>
        </tr>

        </tbody>

    </table>


</form:form>

<p>
    <a href="list"> BACK TO LIST</a>
</p>



</body>
</html>
