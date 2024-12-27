<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<html>
<head>
	<script type="text/javascript" defer="defer">
		function fn_egov_link_page(pageNo) {
			/* 1) 페이지번호를 받기: 0 -> 1,2(클릭), pageNo(클릭한 번호) */
				document.listForm.pageIndex.value = pageNo; // *컨트롤러로 전송(input 태그)
			/* 2) 재조회(다시 전체조회): /basic/dept */
				document.listForm.action = "/basic/faq";
			/* 3) submit() 실행 */
				document.listForm.submit();
		}
		
		/* 검색 버튼 클릭시 실행될 함수 */
		function fn_egov_selectList() {
			/* 1) 페이지번호를 1번으로 전송(컨트롤러) */
				document.listForm.pageIndex.value = 1;
			/* 2) action 속성(다시 전체조회): "/basic/dept" */
				document.listForm.action = "/basic/faq";
			/* 3) submit() 실행 */
				document.listForm.submit();
			/* 4) (참고) input에서 검색어(searchKeyword)를 컨트롤러로 전송 */
		}
		
		function fn_select(fno) {
			// 1) 부서번호(dno) -> 상세조회로 전달
			document.listForm.fno.value = fno;
			// 2) action = "/basic/dept/edition";
			document.listForm.action = "/basic/faq/edition";
			// 3) sumbit();
			document.listForm.submit();
		}
	</script>
</head>
<body>
	<jsp:include page="/common/header.jsp"></jsp:include>
	
	<div class="container">
	
		<form action="listForm" name="listForm" method="get">
			<input type="hidden" name="fno">
			
			<div class="input-group mb-3 mt-3">
  				<input type="text" class="form-control" placeholder="검색어를 입력하세요" id="searchKeyword" name="searchKeyword" onkeypress="fn_egov_selectList()">
 				<button class="btn btn-dark" type="button" onclick="fn_egov_selectList()">검색</button>
			</div>
			
			<table class="table">
					 <thead> 
					    <tr>
					      <th scope="col">fno</th>
					      <th scope="col">title</th>
					      <th scope="col">content</th>
					  </tr>
					  </thead>
					  <tbody>
					  	<c:forEach var="data" items="${faqs}">
					  		<tr>
					      		<td>
				      				<a href="javascript:fn_select('<c:out value="${data.fno}"></c:out>')">
				      					<c:out value="${data.fno}"></c:out>
				      				</a>
				      			</td>
					      		<td><c:out value="${data.title}"></c:out></td>
					      		<td><c:out value="${data.content}"></c:out></td>
					    	</tr>
					  	</c:forEach> 
					  </tbody>
				</table>
			
			<!-- 페이징 번호 -->
			<!-- (참고) https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte:ptl:view:paginationtag -->
			<div id="paging" class="text-center">
            	<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
         	    <input type="hidden" id="pageIndex" name="pageIndex" />
         	</div>
         	
		</form>
		
	</div>
	
	<jsp:include page="/common/footer.jsp"></jsp:include>
</body>
</html>
