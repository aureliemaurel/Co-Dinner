<%-- 
    Document   : showevents
    Created on : 12 mai 2022, 09:35:28
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShowEvents</title>
    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>
        <main>
            <h2>Liste Events, Participants et Foods</h2>
            
            <h3>liste des Events</h3>
            <c:forEach var="event" items="${requestScope.events}" varStatus="status">

                <h3>${status.count}. ${pageScope.event.titre}</h3>
                <div>Event créé le ${pageScope.event.date_event} chez ${pageScope.event.lieu}</div>

            </c:forEach>


                <h3>liste des Participants</h3>
            <c:forEach var="guest" items="${requestScope.users}" varStatus="status">

                <h3>${status.count}. ${pageScope.guest.name} </h3>

            </c:forEach>
                
                
                <h3>liste des Foods</h3>
            <c:forEach var="food" items="${requestScope.foods}" varStatus="status">

                <h3>${status.count}.on a pour entree:  ${pageScope.food.entree} et le Boisson y a que:  ${pageScope.food.boisson} </h3>

            </c:forEach>



        </main>
        <%@include file="./jspf/footer.jspf" %>
    </body>
</html>
