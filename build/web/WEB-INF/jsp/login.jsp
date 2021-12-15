<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Aplikasi</title>
    </head>
    <body>
        <div>
            <h1 style="text-align: center">Silahkan Login</h1>
            <form method="GET" modelAttribute="lg" action="login/submit.html">
                <table align="center">
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="login"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">${message}</td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
