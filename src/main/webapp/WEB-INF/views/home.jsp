<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>fileUpload</title>
</head>
<body>
<form enctype="multipart/form-data" method="post" action="<c:url value='/upload'/>">
 <div>
   <label for="file"><h1>Choose file to upload</h1></label><br/>
   <input type="file" id="file" name="file" multiple><br/>
   <input type="submit"/>
   <input type="hidden" id="flag" value="${fileuploadFlag}"/> 
 </div>
</form>
<script>
window.onload = function() {
	var flag = document.getElementById("flag").value;
	if(flag === "y") {
		alert("file upload success");
	}
}
</script>
</body>
</html>