<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 페이징 처리를 위한 태그라이브러리 -->
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %> 
<html>
<head>
	<script type="text/javascript" defer="defer">
		/* 페이지 번호 클릭시 실행될 함수 */
		function fn_egov_link_page(pageNo) {		
				document.listForm.pageIndex.value = pageNo; // 컨트롤러로 전송됨
			
				document.listForm.action = "/advanced/fileDb";
			
				document.listForm.submit(); // 서버로 전송
		}
		
		/* 검색 버튼 클릭시 실행될 함수 */
		function fn_egov_selectList() {
				document.listForm.pageIndex.value = 1; // 컨트롤러로 전송됨
	
				document.listForm.action = "/advanced/fileDb";
			
				document.listForm.submit(); // 서버로 전송
		}
		/* 뒤로가기 함수 */
		function fn_back() {
			document.listForm.pageIndex.value = 1; // 페이지 인덱스를 1로 설정하여 첫 페이지로 돌아감
			
			document.listForm.searchKeyword.value = ""; // 검색어를 비워 전체 목록을 요청함

			document.listForm.action = "/advanced/fileDb";
		
			document.listForm.submit(); // 서버로 전송
		}
		/* Enter 키를 눌렀을 때 검색 실행 */
		function handleKeyPress(event) {
            if (event.key === 'Enter') {
                event.preventDefault(); // 기본 동작을 막음
                fn_egov_selectList(); // fn_egov_selectList() 함수의 실행
            }
        }
		/* 삭제 버튼 클릭시 실행 함수 : uuid(기본키) */
		function fn_delete(id) {
			document.listForm.uuid.value = id; // jsp -> 컨트롤러로 전송
			
			// get -> post 변경
			document.listForm.method = "post";
			
			document.listForm.action = "/advanced/fileDb/delete";
			
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
      	 <!-- uuid 전송용 -->
      	 <input type="hidden" name="uuid">
         <!-- 검색어 입력양식 -->
         <div class="input-group mb-3 mt-3">
            <input type="text" class="form-control" id="searchKeyword" name="searchKeyword" placeholder="제목을 입력하세요." onkeypress="handleKeyPress(event)">
            <button class="btn btn-primary" type="button" onclick="fn_egov_selectList()">검색</button>
            <button class="btn btn-dark" type="button" onclick="fn_back()">첫 페이지로 이동</button>
         </div>
         
		 <!-- 부트스트랩 1행 -->
         <div class="row">
		 	<!-- 부트스트랩 1열: 3칸 => TODO: 열 반복 -->
            <c:forEach var="data" items="${fileDbs}">
              <div class="col-3">
                <%-- TODO: 카드 --%>
                <div class="card" style="width: 18rem;">
                   <img src="<c:out value="${data.fileUrl}"/>" class="card-img-top" alt="이미지">
                   <div class="card-body">
                      <h5 class="card-title"><c:out value="${data.fileTitle}" /></h5>
                      <p class="card-text"><c:out value="${data.fileContent}" /></p>
                      <a href="#" class="btn btn-danger" onclick="fn_delete('${data.uuid}')">삭제</a>
                      <!-- 문자열이기에 홑따옴표('') --> 
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
   
   <%--    꼬리말--%>
   <jsp:include page="/common/footer.jsp" />

</body>
</html>
