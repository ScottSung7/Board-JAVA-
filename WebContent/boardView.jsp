<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO" %>
<%@ page import="board.BoardDTO" %>
<%@ page import="com.service.BoardService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/custom.css">
	<title>JSP Ajax 실시간 회원제 채팅 서비스</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</head>
<body>
	<%
		String userID = null;
		if(session.getAttribute("userID") !=null){
			userID = (String)session.getAttribute("userID");
		}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>	
			<a class="navbar-brand" href="index.jsp">실시간 회원제 채팅 서비스</a>	
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">메인</a>
				<li class="active"><a href="boardView.jsp">자유게시판</a>
			</ul>
			<%
				if(userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">접속하기<span class="caret"></span>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
						<li><a href="update.jsp">회원정보 수정</a></li>
					</ul>	
					</a>
				</li>			
			</ul>
			<%
				} else{
			%>
					<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">회원관리<span class="caret"></span>
					</a>
				</li>			
			</ul>
			<%
				}
			BoardService service = new BoardService();			
			List<BoardDTO> boardList = service.getList();
			%>
			
		</div>
	</nav>
	<div class="container">
		<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="5" style=text-align: center;><h4>자유게시판</h4></th>
				<tr>
					<th style="background-color: #fafafafa; color: #000000; width:70px; text-align: center;""><h5>번호</h5></th>
					<th style="background-color: #fafafafa; color: #000000; text-align: center;"><h5>제목</h5></th>
					<th style="background-color: #fafafafa; color: #000000; text-align: center;"><h5>작성자</h5></th>
					<th style="background-color: #fafafafa; color: #000000; width:100p; text-align: center;"><h5>작성날짜</h5></th>
					<th style="background-color: #fafafafa; color: #000000; width:70px; text-align: center;"><h5>조회수</h5></th>				
				</tr>			
			</thead>
			<tbody>
			<%
				for(int i = 0; i< boardList.size();i++){
					BoardDTO board = boardList.get(i);
				
			%>
			
				<tr>
					<td><%= board.getBoardID() %></td>
					<td style="text-align: left;"><a href="boardShow.jsp?boardID=<%= board.getBoardID() %>"><%= board.getBoardTitle() %></a></td>
					<td><%= board.getUserID() %></td>	
					<td><%= board.getBoardDate() %></td>
					<td><%= board.getBoardHit() %></td>		
				</tr>
					<%
				}
				%>
				<tr>
					<td colspan="5"><a href="boardWrite.jsp" class="btn btn-parimary pull-right" type="submit">글쓰기</a>
				</tr>
			</tbody>	
		</table>
	</div>
	
</body>
</html>