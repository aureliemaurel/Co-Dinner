<%-- 
    Document   : event
    Created on : 11 mai 2022, 11:27:24
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event</title>
      
        <link rel="stylesheet" href="<c:url value='/rsc/css/form.css'/>">
    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>
       
        

        <main>
            <form action="" method="post">
                <fieldset>
                    <legend>Event</legend>

                    <div>
                        <div >
                            <label for="titre">Titre</label>
                            <input type="text" id="titre" name="titre"
                                   placeholder="Titre" value="<c:out value="${requestScope.event.titre}"/>" required>
                           <br><br>
                        </div>
                        <div>
                            <label for="lieu">Lieu</label>
                            <input type="text"  id="lieu" name="lieu"
                                   placeholder="Lieu" value="<c:out value="${requestScope.event.lieu}"/>" required>
                            <br><br>
                        </div>
                        <div>
                            <label for="date_event">Date</label>
                            <input type="text"  id="date_event" name="date_event"
                                   placeholder="AAAA-MM-JJ" value="<c:out value="${requestScope.event.date_event}"/>" required>
                        <br><br>
                        </div>
                    </div>
                    <div>
                        <input type="submit" value="Envoyer">
                    </div>
                </fieldset>

            </form>

        </main>

    </body>
</html>
