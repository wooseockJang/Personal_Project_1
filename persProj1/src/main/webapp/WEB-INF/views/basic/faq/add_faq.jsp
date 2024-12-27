<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" defer="defer">
		function fn_save() {	
			document.addForm.action = "/basic/faq/add";
			document.addForm.submit();
		}
	</script>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	
	<div class="container">
		 <!-- 유효성 체크 태그 추가 -->
		 <form:form modelAttribute="faqVO" id="addForm" name="addForm" method="post">
		 	<%-- TODO: 추가페이지 : 기본키(게시판번호) 입력(없음) : 자동생성 --%>
        	<div class="mb-3">
	            <%-- 게시판제목 입력양식 --%>
	            <label for="title" class="form-label">title</label>
	            <input class="form-control" placeholder="제목" id="title" name="title"/>
	            &nbsp;<form:errors path="title"/>	
       	    </div>
       	    
        	<div class="mb-3">
	            <%-- 게시판내용 입력양식 --%>
	            <label for="content" class="form-label">content</label>
	            <input class="form-control" placeholder="해결방법" id="content" name="content"/>
	            &nbsp;<form:errors path="content"/>	
        	<div>
        	
       	    <div class="mb-3 mt-2">
            	<button class="btn btn-primary" onclick="fn_save()">저장</button>
        	</div>
        	
    	</form:form>
	</div>
	
	
	
	
	
	
	
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>