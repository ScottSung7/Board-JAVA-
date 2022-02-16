<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.BoardDAO" %>
<%@ page import="board.BoardDTO" %>
<%@ page import="com.service.BoardService" %>

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
			String boardID = null;
			if (request.getParameter("boardID") !=null) {
				boardID = (String) request.getParameter("boardID");
			}
			BoardDAO boardDAO = new BoardDAO();
			BoardService service = new BoardService();
			BoardDTO board = service.getBoard(boardID);
			service.hit(boardID);
			%>
			
		</div>
	</nav>
	<div class="container">
		<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="4" style=text-align: center;><h4>게시물 보기</h4></th>
				<tr>
					<td style="background-color: #fafafa; color:#000000; width: 80px;"><h5>제목</h5></td>
					<td colspan="3"><h5><%= board.getBoardTitle() %></h5></td>
				</tr>	
				<tr>
					<td style="background-color: #fafafa; color:#000000; width: 80px;"><h5>작성자</h5></td>
					<td colspan="3"><h5><%= board.getUserID() %></h5></td>
				</tr>	
				<tr>
					<td style="background-color: #fafafa; color:#000000; width: 80px;"><h5>작성날짜</h5></td>
					<td colspan="3"><h5><%= board.getBoardDate() %></h5></td>
				</tr>		
				<tr>
					<td style="background-color: #fafafa; color:#000000; width: 80px;"><h5>조회수</h5></td>
					<td colspan="3"><h5><%= board.getBoardHit() %></h5></td>
				</tr>	
				<tr>
					<td style="vertical-align: middle; min-height: 150px; background-color: #fafafa; color:#000000; width: 80px;"><h5>글 내용</h5></td>
					<td colspan="3" style="text-align: left;"><h5><%= board.getBoardContent() %></h5></td>
				</tr>
					<tr>
					<td style="background-color: #fafafa; color:#000000; width: 80px;"><h5>첨부파일</h5></td>
					<td colspan="3"><h5><a href = "boardDownload.jsp?boardID=<%= board.getBoardID() %>"><%= board.getBoardFile() %></h5></td>
				</tr>				
			</thead>
			<tbody>
		
				<tr>
					<td colspan="5" style="text-align: right;">
					<a href="boardUpdate.jsp?boardID<%= board.getBoardID() %>" class="btn btn-primary" type="submit">수정</a>
					<a href="boardView.jsp" class="btn btn-primary">목록</a>
					<a href="boardReply.jsp?boardID<%= board.getBoardID() %>" class="btn btn-primary">답변</a>
					
				</tr>
			</tbody>	
		</table>
	</div>
	
</body>
</html>