<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Cookie[] cookies = request.getCookies();
if(cookies != null && cookies.length > 0){
	for(int i =0; i < cookies.length; i++){
		if(cookies[i].getName().equals("name")){
			Cookie cookie = new Cookie("name", "");
			/* cookie 삭제 효과 - expire : session  */
			 cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
}

%>
</head>
<body>
<h1>쿠키 삭제</h1>
</body>
</html>