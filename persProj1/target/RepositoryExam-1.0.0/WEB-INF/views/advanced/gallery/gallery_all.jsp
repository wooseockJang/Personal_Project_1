<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 페이징 처리를 위한 태그라이브러리 -->
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %> 
<html>
<head>
	<script type="text/javascript" defer="defer">
		/* 페이지 번호 클릭시 실행될 함수 */
		function fn_egov_link_page(pageNo) {		
				document.listForm.pageIndex.value = pageNo; 
			
				document.listForm.action = "/advanced/gallery";
			
				document.listForm.submit();
		}
		
		/* 검색 버튼 클릭시 실행될 함수 */
		function fn_egov_selectList() {
				document.listForm.pageIndex.value = 1;
	
				document.listForm.action = "/advanced/gallery";
			
				document.listForm.submit();
		}
	</script>
</head>
<body>
   <%-- 머리말 --%>
   <jsp:include page="/common/header.jsp" />
   
   <%-- 본문 --%>
   <div class="container">
      <form action="listForm" name="listForm" method="get">
         <!-- 검색어 입력양식 -->
         <div class="input-group mb-3 mt-3">
            <input type="text" class="form-control" id="searchKeyword" name="searchKeyword" placeholder="제목을 입력하세요." onkeypress="fn_egov_selectList()">
            <button class="btn btn-primary" type="button" onclick="fn_egov_selectList()">검색</button>
         </div>

		<!-- 부트스트랩 1행 -->
        <div class="row">
			   <!-- 부트스트랩 1열: 3칸 => TODO: 열 반복 -->
               <c:forEach var="data" items="${galaxy}">
	               <div class="col-3">
	                  <%-- TODO: 카드 --%>
	                  <div class="card" style="width: 18rem;">
	                     <img src="<c:out value="${data.galleryFileUrl}"/>" class="card-img-top" alt="이미지">
	                     <div class="card-body">
	                        <h5 class="card-title"><c:out value="${data.galleryTitle}" /></h5>
	                        <a href="#" class="btn btn-primary">Go somewhere</a>
	                     </div>
	                  </div>
	               </div>
               </c:forEach>
         </div>
         
         <div id="paging" class="text-center">
            	<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
         	    <input type="hidden" id="pageIndex" name="pageIndex" />
         </div>
         
      </form>
   </div>
   
   <%-- 꼬리말 --%>
   <jsp:include page="/common/footer.jsp" />

</body>
</html>
