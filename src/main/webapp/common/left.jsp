<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main  <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="<%=request.getContextPath()%>/userList">사용자리스트</a></li>
		<li class="active"><a href="<%=request.getContextPath()%>/userPagingList?page=1&pageSize=10">사용자페이징 리스트</a></li>
		<li class="active"><a href="<%=request.getContextPath()%>/lprodList">lprod리스트</a></li>
	</ul>
</div>