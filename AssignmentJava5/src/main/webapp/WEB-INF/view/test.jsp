<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <tr>
        <th>Ten</th>
        <th>Tuoi</th>
    </tr>
    <c:forEach items="${list}" var="sp">
        <tr>
            <td>${sp[0]}</td>
            <td>${sp[1]}</td>
        </tr>
    </c:forEach>

</table>

<c:set var="soLuong" value=""/>
<c:forEach items="${list}" var="element" varStatus="status">
    <c:set var="soLuong" value="${soLuong}${element[1]}"/>
    <c:if test="${!status.last}">
        <c:set var="soLuong" value="${soLuong}, "/>
    </c:if>
</c:forEach>
<c:set var="tenDienThoai" value=""/>
<c:forEach items="${list}" var="element" varStatus="status">
    <c:set var="temp" value="${element[0].split(',')}"/>
    <c:forEach items="${temp}" var="item">
        <c:set var="formattedItem" value="${item.trim()}"/>
        <c:set var="tenDienThoai" value="${tenDienThoai}'${formattedItem}'"/>
        <c:if test="${!status.last}">
            <c:set var="tenDienThoai" value="${tenDienThoai}, "/>
        </c:if>
    </c:forEach>
</c:forEach>
${tenDienThoai}
${soLuong}