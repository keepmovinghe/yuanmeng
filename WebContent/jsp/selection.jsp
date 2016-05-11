<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.bg_blue {
	background-color: blue;
}
</style>
</head>
<body>
	<h3>----修改全部表单元素的背景色------</h3>
	<form id="frmTest" action="#">
		<input type="button" value="Input Button"><br /> <select>
			<option value="option" />
		</select> <br />
		<textarea rows="3" cols="8"></textarea>
		<br />
		<button>Button</button>
		<br />
	</form>

	<script type="text/javascript">
		$("#frmTest :input").addClass(".bg_blue");
	</script>
</body>
</html>