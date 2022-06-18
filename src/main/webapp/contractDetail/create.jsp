<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
    <h1>Create Contract Detail</h1>
</div>
<div class="container">
    <form action="contract-detail?action=create" method="post">
        <div class="row mb-3">
            <label for="contract_id" class="col-sm-2 col-form-label">Contract Id</label>
            <div class="col-sm-10">
                <select name="contract_id" class="form-select" id="contract_id">
                    <c:forEach var="contractId" items="${contractDetailCreateResponseDto.contractIdList}">
                        <option value="${contractId}">${contractId}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row mb-3">
            <label for="attach_service_id" class="col-sm-2 col-form-label">Attach Service Id</label>
            <div class="col-sm-10">
                <select name="attach_service_id" class="form-select" id="attach_service_id">
                    <c:forEach var="attachServiceId" items="${contractDetailCreateResponseDto.attachServiceIdList}">
                        <option value="${attachServiceId}">${attachServiceId}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row mb-3">
            <label for="quantity" class="col-sm-2 col-form-label">Total Money</label>
            <div class="col-sm-10">
                <input type="number" name="quantity" class="form-control" id="quantity">
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>
</body>
</html>