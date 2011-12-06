<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <jsp:include page="header.jsp"></jsp:include>
		
		<p class="center">Click <a href="cats/1">here</a> to see some funny cats</p>

        <table id="cats" style="width: auto;" class="center">
		<c:forEach items="${cats}" var="cat">
		  <tr>
		      <td><fmt:formatNumber type="number" pattern="0.0" value="${ cat.value.rating }" /></li></td>
		      <td><a href="cats/${cat.value.id}"><img height="100px" src="<c:url value="/resources/cats/${cat.value.fileName}" />" alt="Funny Cat"
                title="Funny Cat" /></a></td>
          </tr>
		</c:forEach>
		</table>

	</div>
</body>
</html>
