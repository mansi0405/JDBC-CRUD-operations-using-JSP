<%-- 
    Document   : delete
    Created on : 1 Oct, 2021, 11:40:32 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

       <!DOCTYPE html>
<html>
    <body>
        <h3>Deletion-Form</h3>
        <hr>
        <form action="Deletion" method="get">
            <table border="0">
            <tr>
                <td>ENTER STUDENT_NO TO BE DELETED</td><td><input type="text" name="STUDENT_NO"/></td>
            </tr>
            
                <td><input type="submit" value="delete"/></td>
            </tr>
            </table>
        </form>
        <hr>
        <a href="index.html">Home</a>
        <a href=update.jsp>update</a>
    </body>
</html>


