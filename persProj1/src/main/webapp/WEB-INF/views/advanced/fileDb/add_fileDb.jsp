<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" defer="defer">
		function fn_save() {
			document.addForm.action = "/advanced/fileDb/add";
			
            document.addForm.submit();
		}
	</script>
</head>
<body>
   <jsp:include page="/common/header.jsp" />

	<div class="container">
		<form id="addForm" name="addForm" method="post" enctype="multipart/form-data">
		
			<div class="mb-3">
	            <%-- 제목 입력양식 --%>
	            <label for="fileTitle" class="form-label">fileTitle</label>
	            <input class="form-control" id="fileTitle" name="fileTitle" placeholder="제목" />
        	</div>
        	
        	<div class="mb-3">
	            <%-- 내용 입력양식 --%>
	            <label for="fileContent" class="form-label">fileContent</label>
	            <input class="form-control" id="fileContent" name="fileContent" placeholder="내용입력" />
        	</div>
        	
        	<div class="input-group">
				<input type="file" class="form-control" id="image" name="image">
			    <button class="btn btn-primary" type="button" onclick="fn_save()">저장</button>
			</div>
			
		</form>
	</div>
	
   <jsp:include page="/common/footer.jsp" />
</body>
</html>