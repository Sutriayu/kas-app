<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="include.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <title>Home</title>
    </head>
    <body>
        <div class="app p-2">
            <h1>Data Kas Kelas</h1>
            <h4><a href="kas-form.html">Bayar Kas</a></h4>
            <table class="table table-striped table-bordered">
                <tr class="thead-dark">
                    <th>ID</th>
                    <th>Nim</th>
                    <th>Nama</th>
                    <th>Tanggal</th>
                    <th>Bayar</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${listKas}" var="kas"> 
                    <tr>
                        <td>${kas.id}</td>
                        <td>${kas.nim}</td>
                        <td>${kas.nama}</td>
                        <td>${kas.tanggal}</td>
                        <td>${kas.bayar}</td>
                        <td>
                            <button class="btn btn-primary"
                                    onclick="window.location.href = 'kas-form.html?action=edit&id=${kas.id}'">
                                Edit    
                            </button>
                            <button class="btn btn-danger"
                                    onclick="window.location.href = 'kas-form.html?action=delete&id=${kas.id}'">
                                Delete    
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/login.html"/>Logout</a>
    </div>
</body>
</html>
