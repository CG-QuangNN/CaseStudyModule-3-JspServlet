<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css">
</head>
<body>
<jsp:include page="../common/logo.jsp"/>
<jsp:include page="../common/menu.jsp"/>
<div class="container" style="overflow-x: auto">
    <div class="d-flex" style="justify-content: flex-end;">
        <a href="customer?action=create" class="btn btn-primary mb-2 btn-lg">Create Customer</a>
    </div>
    <table id="example" class="table table-striped" style="width:100%">
        <thead>
        <tr>
            <th>Code</th>
            <th>Type</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Gender</th>
            <th>Id Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.customerCode}</td>
                <td>${customer.customerTypeName}</td>
                <td>${customer.customerName}</td>
                <td>${customer.customerBirthday}</td>
                <td>${customer.customerGender ? 'Nam' : 'Nữ'}</td>
                <td>${customer.customerIdCard}</td>
                <td>${customer.customerPhone}</td>
                <td>${customer.customerEmail}</td>
                <td>${customer.customerAddress}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="../common/footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });
</script>
</body>
</html>