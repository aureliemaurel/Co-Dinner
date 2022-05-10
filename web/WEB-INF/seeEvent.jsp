<%-- 
    Document   : seeEvent
    Created on : 9 mai 2022, 12:01:45
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                <%@include file="./jspf/header.jspf" %>
        <main>
            <h2>Participants</h2>
            <c:forEach var="participants" items="${requestScope.participants}" varStatus="status">
              
                    <h3>${status.count}. ${requestScope.participants.nom}</h3>
                    <div>Article créé le ${requestScope.participants.prenom} par ${requestScope.participants.tel}</div>
                    <div>${requestScope.participants.remarque}</div>
                
            </c:forEach>
        </main>
        <%@include file="./jspf/footer.jspf" %>
    </body>
</html>
