<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" defer="defer">
		function fn_save() {
			// 1) 컨트롤러 함수 : 저장함수 실행 : /basic/dept/add
			document.addForm.action = "/basic/dept/add";
			// 2) submit() 실행
			document.addForm.submit();
		}
	</script>
</head>
<body>
	<!-- 머리말 -->
	<jsp:include page="/common/header.jsp"></jsp:include>
	
	<!-- 본문 -->
	<div class="container">
		 <!-- 유효성 체크 태그 추가 -->
		 <form:form modelAttribute="deptVO" id="addForm" name="addForm" method="post">
		 	<%-- TODO: 추가페이지 : 기본키(게시판번호) 입력(없음) : 자동생성 --%>
        	<div class="mb-3">
	            <%-- 게시판제목 입력양식 --%>
	            <label for="dname" class="form-label">dname</label>
	            <input class="form-control" placeholder="부서명" id="dname" name="dname"/>
	            &nbsp;<form:errors path="dname"/>	
       	    </div>
       	    
        	<div class="mb-3">
	            <%-- 게시판내용 입력양식 --%>
	            <label for="loc" class="form-label">loc</label>
	            <input class="form-control" placeholder="부서위치" id="loc" name="loc"/>
	            &nbsp;<form:errors path="loc"/>
        	<div>
        	
       	    <div class="mb-3 mt-2">
            	<button class="btn btn-primary" onclick="fn_save()">저장</button>
        	</div>
    	</form:form>
	</div>
	
	<!-- 꼬리말 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
