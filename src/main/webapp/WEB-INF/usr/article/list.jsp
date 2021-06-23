<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageTitle"  value="게시물 리스트"/>
<%@ include file="../part/head.jspf" %>
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
					<c:forEach items="${articles}" var="article">
					<div>
						번호 : ${article.id}<br>
						작성일 : ${article.regDate}<br>
						수정일 : ${article.updateDate}<br>
						제목 : ${article.title}<br>
						내용 : ${article.body}<br>
					</div>
					<br>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>
<%@ include file="../part/foot.jspf" %>