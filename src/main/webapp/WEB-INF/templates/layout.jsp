<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!doctype html>
<html lang="en">
  <head>
  <script src="https://kit.fontawesome.com/5646d8b8f0.js" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <title>eStore</title>
    <!-- Bootstrap core CSS -->
    <!-- jsp파일들은 서버쪽에있기때문에 아래 경로를 이렇게 하면안돼 
    위의 c 라이브러리로 쓴거다.
    servlet-context 16줄 참고-->
    <!-- Custom styles for this template -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  </head>
  <body>
  
<!-- 타이틀 부분도 이렇게 수정해!!-->
<title><tiles:insertAttribute name ="title"></tiles:insertAttribute></title>

	<div>
	<!-- 이 부분에 menu, body, footer라는 attribute를 집어넣겠다.! -->
		<tiles:insertAttribute name ="menu"></tiles:insertAttribute>
		<tiles:insertAttribute name ="body"></tiles:insertAttribute>
		<tiles:insertAttribute name ="footer"></tiles:insertAttribute>
	</div>  
  

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
<script src="<c:url value="resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>