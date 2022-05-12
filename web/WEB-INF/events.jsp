<%-- 
    Document   : events
    Created on : 11 mai 2022, 20:05:39
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>
        <main>
            <h2>Voici nos events</h2>
            <c:forEach var="event" items="${requestScope.events}" varStatus="status">
                
                <events>
                    <h3>${status.count}. ${pageScope.event.titre}</h3>
                    <div>Event créé le ${pageScope.event.date_event} chez ${pageScope.event.lieu}</div>
                    
                </events>
            </c:forEach>
        </main>
        <%@include file="./jspf/footer.jspf" %>
    </body>
</html>
