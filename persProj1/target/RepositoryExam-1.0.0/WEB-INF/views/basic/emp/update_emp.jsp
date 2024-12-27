<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- 수정 -->
    <script type="text/javascript" defer="defer">
    	<!-- 수정 -->
		function fn_save() {
	    	document.detailForm.action = "/basic/emp/edit";
	    	document.detailForm.submit();
		}
		<!-- 삭제 -->
		function fn_delete() {
 	    	document.detailForm.action = "/basic/emp/delete";
 	    	document.detailForm.submit();
		}
    </script>
    

</head>
<body>
	<%--  머리말  --%>
	<jsp:include page="/common/header.jsp"/>
	
	<%--  본문 : 수정/추가 : form/input 태그 --%>
	<div class="container">
	<%--    수정 form --%>
	    <form id="detailForm" name="detailForm" method="post">
	        <div class="mb-3">
	        	<input type="hidden" name="eno" value="${empVO.eno}">
	            <%-- 제목 입력양식 --%>
	            <label for="ename" class="form-label">ename</label>
	            <input 
	                   class="form-control"
	                   placeholder="제목입력" value="${empVO.ename}" name="ename" id="ename"/>
	        </div>
	        
	        <div class="mb-3">
	            <%--            내용 입력양식 --%>
	            <label for="job" class="form-label">job</label>
	            <input 
	                   class="form-control"
	                   placeholder="내용입력" value="${empVO.job}" name="job" id="job"/>
	        </div>
	        
	        <div class="mb-3">
	            <%--             제목 입력양식 --%>
	            <label for="manager" class="form-label">manager</label>
	            <input 
	                   class="form-control"
	                   placeholder="제목입력" value="${empVO.manager}" name="manager" id="manager"/>
	        </div>
	        
	        <div class="mb-3">
	            <%--            내용 입력양식 --%>
	            <label for="hiredate" class="form-label">hiredate</label>
	            <input 
	                   class="form-control"
	                   placeholder="내용입력" value="${empVO.hiredate}" name="hiredate" id="hiredate"/>
	        </div>
	        
	        <div class="mb-3">
	            <%--             제목 입력양식 --%>
	            <label for="salary" class="form-label">salary</label>
	            <input 
	                   class="form-control"
	                   placeholder="제목입력" value="${empVO.salary}" name="salary" id="salary"/>
	        </div>
	        
	        <div class="mb-3">
	            <%--            내용 입력양식 --%>
	            <label for="commission" class="form-label">commission</label>
	            <input 
	                   class="form-control"
	                   placeholder="내용입력" value="${empVO.commission}" name="commission" id="commission"/>
	        </div>
	        
	        <div class="mb-3">
	            <%--            내용 입력양식 --%>
	            <label for="dno" class="form-label">dno</label>
	            <input 
	                   class="form-control"
	                   placeholder="내용입력" value="${empVO.dno}" name="dno" id="dno"/>
	        </div>
	        
	<%--     수정버튼       --%>
	        <div class="mb-3">
	            <button class="btn btn-warning" onclick="fn_save()">수정</button>
	                        
	            <button class="btn btn-danger" onclick="fn_delete()">삭제</button>
	        </div>
	    </form>
	</div>
	
	<%--  꼬리말  --%>
	<jsp:include page="/common/footer.jsp"/>

</body>
</html>
