<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.yhr.exam.exam2.dto.Article" %>
<%
List<Article> articles = (List<Article>)request.getAttribute("articles");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP BOARD</title>
<!-- 모바일에서 디자인이 축소되지 않게 하기 위한 코드 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css"
	rel="stylesheet" type="text/css" />

<link href="https://cdn.jsdelivr.net/npm/daisyui@1.4.0/dist/full.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/font.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resource/common.css" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
</head>
<body>
	<section class="section section-article-write px-4">
		<div class="container mx-auto">
			<div class="card bordered shadow-lg">
				<div class="card-title">
					<a href="javascript:history.back();" class="cursor-pointer">
						<i class="fas fa-chevron-left"></i>
					</a>
					<span>게시물 리스트</span>
				</div>
				<div class ="px-4 py-4">
					<%  for(Article article : articles) {%>
					<div>
						번호 : <%=article.getId() %><br>
						작성일 : <%=article.getRegDate() %><br>
						수정일 : <%=article.getUpdateDate() %><br>
						제목 : <%=article.getTitle() %><br>
						내용 : <%=article.getBody() %><br>
					</div>
					<br>
					<% } %>
				</div>
			</div>
		</div>
	</section>
</body>
</html>