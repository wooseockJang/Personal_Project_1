<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" defer="defer">
    	<!-- 수정 -->
	    function fn_save() {
			// action 속성: "/basic/dept/edit";
	    	document.detailForm.action = "/basic/faq/edit";
	    	// submit();
	    	document.detailForm.submit();
		}
    	<!-- 삭제 --> 
   		 function fn_delete() {
   			// action 속성: "/basic/dept/delete";
 	    	document.detailForm.action = "/basic/faq/delete";
 	    	// submit();
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
	    	<input type="hidden" name="fno" value="${faqVO.fno}">
	        <div class="mb-3">
	            <%-- 제목 입력양식 --%>
	            <label for="title" class="form-label">title</label>
	            <input class="form-control" placeholder="제목입력" name="title" id="title" value="${faqVO.title}"/>
	        </div>
	        
	        <div class="mb-3">
	            <%-- 내용 입력양식 --%>
	            <label for="content" class="form-label">content</label>
	            <input class="form-control" placeholder="내용입력" name="content" id="content" value="${faqVO.content}"/>
	        </div>
	        
			<%-- 수정버튼 --%>
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