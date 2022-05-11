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
        <link rel="stylesheet" href="<c:url value='/rsc/css/style.css'/>">
        <link rel="stylesheet" href="<c:url value='/rsc/css/form.css'/>">
    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>
       
        

        <main>
            <form action="" method="post">
                <fieldset>
                    <legend>Event</legend>

                    <div class="form-row">
                      
                    </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer01">Titre</label>
                            <input type="text" class="form-control is-valid" id="validationServer01" name="titre"
                                   placeholder="Titre" value="<c:out value="${requestScope.event.titre}"/>" required>
                           <br><br>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer02">Lieu</label>
                            <input type="text" class="form-control is-valid" id="validationServer02" name="lieu"
                                   placeholder="Lieu" value="<c:out value="${requestScope.event.lieu}"/>" required>
                            <br><br>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationServer02">Date</label>
                            <input type="text" class="form-control is-valid" id="validationServer03" name="date_event"
                                   placeholder="JJ/MM/AAAA" value="<c:out value="${requestScope.event.date_event}"/>" required>
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
