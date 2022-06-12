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
<div class="d-flex" style="justify-content: center">
    <h1>Create Customer</h1>
</div>
<div class="container">
    <form action="customer?action=create" method="post">
        <div class="row mb-3">
            <label for="customer_code" class="col-sm-2 col-form-label">Code</label>
            <div class="col-sm-10">
                <input type="text" name="customer_code" class="form-control" id="customer_code">
            </div>
        </div>

        <div class="row mb-3">
            <label for="customer_name" class="col-sm-2 col-form-label">Full Name</label>
            <div class="col-sm-10">
                <input type="text" name="customer_name" class="form-control" id="customer_name">
            </div>
        </div>

        <div class="row mb-3">
            <label for="customer_birthday" class="col-sm-2 col-form-label">Date Of Birth</label>
            <div class="col-sm-10">
                <input type="date" name="customer_birthday" class="form-control" id="customer_birthday">
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-2 col-form-label">Gender</label>
            <div class="col-sm-10">
                <label for="male" class="form-check-label">Male</label>
                <input type="radio" name="customer_gender" value="1" id="male" class="form-check-input">

                <label for="female" class=" form-check-label" style="margin-left: 50px">Female</label>
                <input type="radio" name="customer_gender" value="" id="female" class="form-check-input">
            </div>
        </div>

        <div class="row mb-3">
            <label for="customer_id_card" class="col-sm-2 col-form-label">Id Card</label>
            <div class="col-sm-10">
                <input type="text" name="customer_id_card" class="form-control" id="customer_id_card">
            </div>
        </div>

        <div class="row mb-3">
            <label for="customer_phone" class="col-sm-2 col-form-label">Phone</label>
            <div class="col-sm-10">
                <input type="text" name="customer_phone" class="form-control" id="customer_phone">
            </div>
        </div>

        <div class="row mb-3">
            <label for="customer_email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="email" name="customer_email" class="form-control" id="customer_email">
            </div>
        </div>

        <div class="row mb-3">
            <label for="customer_type_id" class="col-sm-2 col-form-label">Customer Type</label>
            <div class="col-sm-10">
                <select name="customer_type_id" class="form-select" id="customer_type_id">
                    <c:forEach var="customerType"  items="${customerTypeList}">
                        <option value="${customerType.customerTypeId}">${customerType.customerTypeName}</option>
                    </c:forEach>
<%--                    <option selected>Open this select menu</option>--%>
<%--                    <option value="1">One</option>--%>
<%--                    <option value="2">Two</option>--%>
<%--                    <option value="3">Three</option>--%>
                </select>
            </div>
        </div>

        <div class="row mb-3">
            <label for="customer_address" class="col-sm-2 col-form-label">Địa chỉ</label>
            <div class="col-sm-10">
                <input type="text" name="customer_address" class="form-control" id="customer_address">
            </div>
        </div>

        <div class="row mb-3">
            <label class="col-sm-2 col-form-label"></label>
            <div class="col-sm-10">
                <input type="submit" class="btn btn-primary btn-lg btn-block" value="Save">
            </div>
        </div>
    </form>
</div>

<jsp:include page="../common/footer.jsp"/>
</body>
</html>