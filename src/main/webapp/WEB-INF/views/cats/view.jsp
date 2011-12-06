<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <jsp:include page="../header.jsp"></jsp:include>

		<div id="rating" class="center">
			<span class="number"><a href="<c:url value="/ranking/${cat.id}/1" />">1</a></span> 
			<span class="number"><a href="<c:url value="/ranking/${cat.id}/2" />">2</a></span> 
			<span class="number"><a href="<c:url value="/ranking/${cat.id}/3" />">3</a></span> 
			<span class="number"><a href="<c:url value="/ranking/${cat.id}/4" />">4</a></span> 
			<span class="number"><a	href="<c:url value="/ranking/${cat.id}/5" />">5</a></span>
		</div>
		
		<p class="center">
            [ Rating: <fmt:formatNumber type="number" pattern="0.0" value="${ cat.rating }" /> ]
        </p>

		<div id="holder" class="center">
			<a href="${next}"><img height="400px" src="<c:url value="/resources/cats/${cat.fileName}" />" alt="Funny Cat"
				title="Funny Cat" /></a>
		</div>
	</div>
</body>
</html>
