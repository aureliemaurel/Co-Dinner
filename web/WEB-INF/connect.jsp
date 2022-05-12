<%-- 
    Document   : Connect
    Created on : 9 mai 2022, 11:52:51
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Caveat&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="<c:url value='/rsc/css/form.css'/>">
    </head>
    <body>
        <%@include file="./jspf/header.jspf" %>
        
        <main>
            <fieldset>
                <legend>Connexion</legend>
                <form action="" method="post">
                    <div class="input-groupe">
                        <label for="email">Email<span class="required">*</span></label>
                        <input type="text" id="email" name="email" value="<c:out value="${requestScope.user.email}"/>">
                        <span class="error">${requestScope.errors.email}</span>
                    </div>
                    <div class="input-groupe">
                        <label for="pwd">Mot de passe<span class="required">*</span></label>
                        <input type="password" id="pwd" name="pwd">
                        <span class="error">${requestScope.errors.pwd}</span>
                    </div>
                    <c:forEach var="message" items="${requestScope.connectMessage}">
                        <div class="${message.key}"><c:out value="${message.value}"/></div>
                    </c:forEach>
                    <div class="send">
                        <input type="submit" value="Envoyer">
                    </div>
                </form>
            </fieldset>
        </main>
        <%@include file="./jspf/footer.jspf" %>
  
    </body>
</html>

