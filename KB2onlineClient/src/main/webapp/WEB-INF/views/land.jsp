<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <c:forEach var="line" items="${map.map}">
        <c:forEach var="entry" items="${line}">
            <c:if test="${entry.type.id == 1}">
                <img src='<c:url value="/images/water.png"></c:url>' />
            </c:if>
            <c:if test="${entry.type.id == 2}">
                <img src='<c:url value="/images/land.png"></c:url>' />
            </c:if>
            <c:if test="${entry.type.id == 3}">
                <img src='<c:url value="/images/forest_0.png"></c:url>' />
            </c:if>
            <c:if test="${entry.type.id == 4}">
                <img src='<c:url value="/images/stone_0.png"></c:url>' />
            </c:if>
        </c:forEach>
        <br/>
    </c:forEach>
</body>
</html>
