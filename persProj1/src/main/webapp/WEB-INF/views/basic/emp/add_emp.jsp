<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" defer="defer">
	function fn_save(){
		// 1) 컨트롤러 함수 : 저장함수 실행 : /basic/emp/add
		document.addForm.action = "/basic/emp/add";
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
		 <form id="addForm" name="addForm" method="post">
		 	<%-- TODO: 추가페이지 : 기본키(게시판번호) 입력(없음) : 자동생성 --%>
        	<div class="mb-3">
	            <%-- 게시판제목 입력양식 --%>
	            <label for="dname" class="form-label">ename</label>
	            <input class="form-control" placeholder="게시판제목" id="ename" name="ename"/>	
       	    </div>
       	    <div class="mb-3">
	            <%-- 게시판내용 입력양식 --%>
	            <label for="loc" class="form-label">job</label>
	            <input class="form-control" placeholder="관리자" id="job" name="job"/>
        	<div>
        	<div class="mb-3">
	            <%-- 게시판내용 입력양식 --%>
	            <label for="loc" class="form-label">manager</label>
	            <input class="form-control" placeholder="관리자" id="manager" name="manager"/>
        	<div>
        	<div class="mb-3">
	            <%-- 게시판제목 입력양식 --%>
	            <label for="dname" class="form-label">hiredate</label>
	            <input class="form-control" placeholder="입사일" id="hiredate" name="hiredate"/>	
       	    </div>
       	    <div class="mb-3">
	            <%-- 게시판제목 입력양식 --%>
	            <label for="dname" class="form-label">salary</label>
	            <input class="form-control" placeholder="월급" id="salary" name="salary"/>	
       	    </div>
       	    <div class="mb-3">
	            <%-- 게시판제목 입력양식 --%>
	            <label for="dname" class="form-label">commission</label>
	            <input class="form-control" placeholder="상여금" id="commission" name="commission"/>	
       	    </div>
       	    <div class="mb-3">
	            <%-- 게시판제목 입력양식 --%>
	            <label for="dname" class="form-label">dno</label>
	            <input class="form-control" placeholder="부서번호" id="dno" name="dno"/>	
       	    </div>
       	    <div class="mb-3 mt-2">
            	<button class="btn btn-primary" onclick="fn_save()">저장</button>
        	</div>
    	</form>	
	</div>
	
	
	<!-- 꼬리말 -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
