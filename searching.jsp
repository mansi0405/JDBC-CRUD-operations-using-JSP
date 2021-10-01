<%-- 
    Document   : delete
    Created on : 1 Oct, 2021, 11:40:32 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

       <!DOCTYPE html>
<html>
    <body>
        <h3>Searching -Form</h3>
        <hr>
        <form action="Search" method="get">
            <table border="0">
            <tr>
                <td>ENTER STUDENT_NO To SEARCH</td><td><input type="text" name="STUDENT_NO"/></td>
            </tr>
            
                <td><input type="submit" value="search"/></td>
            </tr>
            </table>
        </form>
        <hr>
        <a href="index.html">Home</a>
        <a href=update.jsp>update</a>
    </body>
</html>


