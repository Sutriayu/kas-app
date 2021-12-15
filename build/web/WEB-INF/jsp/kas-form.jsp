<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Kas</title>
    </head>
    <body>
        <div class="container">
            <h2>Data Kas ${message}</h2>
            <div class="row">
                <div class="col-md-6">
                    <form action="kas-form.html" modelAttribute="lg" method="POST">
                        <div class="form-group">
                            <input type="text" class="form-control" name="nim" placeholder="Nim" value="${kas.nim}"/>
                        </div> 
                        <div class="form-group">
                            <input type="text" class="form-control" name="nama" placeholder="Nama" value="${kas.nama}"/>
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-control" name="tanggal" value="${kas.tanggal != null ? kas.tanggal : today}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="bayar" placeholder="Bayar" value="${kas.bayar}"/>
                        </div>
                        <div>
                            <input type="hidden" name="id" value="${kas.id != null ? kas.id : 0}"/>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>        
                <a href="${pageContext.request.contextPath}/home.html"/>Back</a>
            </div>
        </div>
    </body>
</html>
