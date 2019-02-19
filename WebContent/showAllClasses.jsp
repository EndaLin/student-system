<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*" %>
<%@ page language="java" import="me.domain.Classes" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>学生信息管理平台</title>
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">

		<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
		<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

		<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

		<style type="text/css">
			#line-chart {
				height: 300px;
				width: 800px;
				margin: 0px auto;
				margin-top: 1em;
			}
			
			.brand {
				font-family: georgia, serif;
			}
			
			.brand .first {
				color: #ccc;
				font-style: italic;
			}
			
			.brand .second {
				color: #fff;
				font-weight: bold;
			}
		</style>

		<link rel="shortcut icon" href="../assets/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
	</head>

	<body class="">
		<!-- 分页操作-->
		<% 
         ArrayList<Classes> list = (ArrayList<Classes>)request.getSession().getAttribute("clist");
         int page_current = 1; //当前页数
         int page_begin = 0;  //起始点,注意:下标从0开始
         int page_end = 9;   //终点,每页十条信息
         int total_count = 0;
         if(list != null)
            total_count = list.size();   //信息的总量
         int page_total = total_count / 10 + (total_count % 10 != 0 ? 1 : 0);
         if(request.getParameter("begin") != null) {
        	 page_current = Integer.parseInt(request.getParameter("begin"));  //获取当前页数
                        }
         page_begin = (page_current - 1) * 10;
         page_end = page_begin + 9 > total_count ? total_count : page_begin + 9;
         request.getSession().setAttribute("page_current", page_current);  //保存到session中
         request.getSession().setAttribute("page_total", page_total);
    %>

		<!--<![endif]-->

		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav pull-right">

					<li id="fat-menu" class="dropdown">
						<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i> ${user.account}
							<i class="icon-caret-down"></i>
						</a>

						<ul class="dropdown-menu">
							<li>
								<a tabindex="-1" href="#">My Account</a>
							</li>
							<li class="divider"></li>
							<li class="divider visible-phone"></li>
							<li>
								<a tabindex="-1" href="/StuSys/LogoutServlet">Logout</a>
							</li>
						</ul>
					</li>

				</ul>
				<a class="brand" href="/StuSys/index.jsp"><span class="first">学生信息</span> <span class="second">管理系统</span></a>
			</div>
		</div>

		<div class="sidebar-nav">
			<form class="search form-inline">
				<input type="text" placeholder="Welcome...">
			</form>
			<!-- 管理员功能模块 -->
			<c:if test="${user.type == 0 }">
				<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>信息管理<i class="icon-chevron-up"></i></a>
				<ul id="dashboard-menu" class="nav nav-list collapse in">
					<li>
						<a href="/StuSys/showAllClasses.jsp">班级信息管理</a>
					</li>
					<li>
						<a href="/StuSys/AddStudent.jsp">学生信息录入</a>
					</li>
					<li>
						<a href="/StuSys/showCourse.jsp">课程信息管理</a>
					</li>
					<li>
						<a href="/StuSys/assignmentCourse.jsp">学生排课管理</a>
					</li>
					<li>
						<a href="/StuSys/showStuById.jsp">学生信息查询(个人)</a>
					</li>
					<li>
						<a href="/StuSys/showStuByClass.jsp">学生信息查询(班级)</a>
					</li>
					<li>
						<a href="/StuSys/AddScoreMess.jsp">录入学生成绩信息(批量)</a>
					</li>
					<li>
						<a href="/StuSys/checkAccount.jsp">管理员账号审核</a>
					</li>
				</ul>
			</c:if>
			<!-- 学生功能模块 -->
			<c:if test="${user.type == 1 }">
				<a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>学生成绩管理<i class="icon-chevron-up"></i></a>
				<ul id="accounts-menu" class="nav nav-list collapse in">
					<li>
						<a href="/StuSys/checkScore.jsp">查询个人成绩</a>
					</li>
					<li>
						<a href="/StuSys/sortScore.jsp">成绩排名管理</a>
					</li>
				</ul>
			</c:if>
		</div>

		<!--content-->
		<div class="content">

			<div class="header">

				<h1 class="page-title">Class</h1>
			</div>

			<ul class="breadcrumb">
				<li>
					<a href="index.jsp">Home</a> <span class="divider">/</span></li>
				<li class="active">Classes</li>
			</ul>

			<div class="container-fluid">
				<div class="row-fluid">

					<div class="btn-toolbar">
						<button class="btn btn-primary">
						<i class="icon-plus"></i> <a href="/StuSys/AddClasses.jsp">New Classes</a>
					</button>
						<div class="btn-group"></div>
					</div>
					<div class="well">
						<table class="table">
							<thead>
								<tr>
									<th>Class ID</th>
									<th>Class Name</th>
									<th>grade</th>
									<th style="width: 26px;"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="p" items="${clist}" begin="<%=page_begin %>" end="<%=page_end %>">
									<tr>
										<td>${p.cid}</td>
										<td>${p.cname}</td>
										<td>${p.grade }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="pagination">
						<ul>
							<c:if test="${sessionScope.page_current != 1 }">
								<li>
									<a href="/StuSys/showAllClasses.jsp?begin=${sessionScope.page_current - 1 }">Prev</a>
								</li>
							</c:if>
							<c:if test="${sessionScope.page_current != sessionScope.page_total }">
								<li>
									<a href="/StuSys/showAllClasses.jsp?begin=${sessionScope.page_current + 1 }">Next</a>
								</li>
							</c:if>
						</ul>
						当前页数 : ${sessionScope.page_current } / ${sessionScope.page_total }
					</div>
					<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 id="myModalLabel">Delete Confirmation</h3>
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
							<button class="btn btn-danger" data-dismiss="modal">Delete</button>
						</div>
					</div>
					<footer>
						<hr>

						<p class="pull-right">
							<a href="#" title="" target="_blank">解释权归本小组所有</a>
						</p>

						<p>
							&copy; 2018
							<a href="#" target="_blank">Xiao</a>
						</p>
					</footer>
				</div>
			</div>
		</div>

		<script src="lib/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript">
			$("[rel=tooltip]").tooltip();
			$(function() {
				$('.demo-cancel-click').click(function() {
					return false;
				});
			});
		</script>

	</body>

</html>