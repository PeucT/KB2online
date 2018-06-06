<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page trimDirectiveWhitespaces="true" %>
<html>
<head>
  <title>Kings Bounty 2 Online</title>
  <link rel="stylesheet"
        href="/resources/css/custom.css" />
</head>
<body>
    <div class="gameField">
    <c:forEach var="line" items="${map.map}">
        <div class="row">
        <c:forEach var="entry" items="${line}">
            <div class="entry">
            <c:if test="${entry.mapObjectType == 1}">
                <c:if test="${entry.terrainType == 1}">
                    <img src='<c:url value="/resources/images/water.png"></c:url>'/>
                </c:if>
                <c:if test="${entry.terrainType == 2}">
                    <img src='<c:url value="/resources/images/land.png"></c:url>'/>
                </c:if>
                <c:if test="${entry.terrainType == 3}">
                    <img src='<c:url value="/resources/images/forest_0.png"></c:url>'/>
                </c:if>
                <c:if test="${entry.terrainType == 4}">
                    <img src='<c:url value="/resources/images/stone_0.png"></c:url>'/>
                </c:if>
            </c:if>
            <c:if test="${entry.mapObjectType == 2}">
                <img src='<c:url value="/resources/images/gold_chest_glade.png"></c:url>'/>
            </c:if>
            <c:if test="${entry.mapObjectType == 3}">
                <img src='<c:url value="/resources/images/barracks_glade.png"></c:url>'/>
            </c:if>
            </div>
        </c:forEach>
        </div>

    </c:forEach>
    </div>
    <script src="/resources/scripts/custom.js"></script>
</body>
</html>
