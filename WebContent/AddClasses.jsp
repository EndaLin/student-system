<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

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
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
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
                            <li><a tabindex="-1" href="#">My Account</a></li>
                            <li class="divider"></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="/StuSys/LogoutServlet">Logout</a></li>
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
            <li><a href="/StuSys/showAllClasses.jsp">班级信息管理</a></li>
            <li ><a href="/StuSys/AddStudent.jsp">学生信息录入</a></li>
            <li ><a href="/StuSys/showCourse.jsp">课程信息管理</a></li>
            <li ><a href="/StuSys/assignmentCourse.jsp">学生排课管理</a></li>                       
            <li ><a href="/StuSys/showStuById.jsp">学生信息查询(个人)</a></li>
            <li ><a href="/StuSys/showStuByClass.jsp">学生信息查询(班级)</a></li>
            <li ><a href="/StuSys/AddScoreMess.jsp">录入学生成绩信息(批量)</a></li>
            <li ><a href="/StuSys/checkAccount.jsp">管理员账号审核</a></li>            
        </ul>
        </c:if>
                     <!-- 学生功能模块 -->
        <c:if test="${user.type == 1 }">
        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>学生成绩管理<i class="icon-chevron-up"></i></a>
        <ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a href="/StuSys/checkScore.jsp">查询个人成绩</a></li>
            <li ><a href="/StuSys/sortScore.jsp">成绩排名管理</a></li>
        </ul>
        </c:if>
    </div>

	<div class="content">

		<div class="header">

			<h1 class="page-title">Add Classes</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="index.jsp">Home</a> <span class="divider">/</span></li>
			<li><a href="Classes.jsp">Classes</a> <span class="divider">/</span></li>
			<li class="active">Add Classes</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<div class="well">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<form action="/StuSys/AddClasses" id="tab" method="post">
								<label>Class name</label> <input type="text" name="name"
									class="input-xlarge"> 
									<label>Grade</label> <input type="text" name="grade"
									class="input-xlarge"> 
								<div class="btn-toolbar">
									<button type="submit" class="btn btn-primary">
										<i class="icon-save"></i> Add
									</button>
								</div>
							</form>
							<div style="color: red;">${message}${message=""}</div>
						</div>
						<div class="tab-pane fade" id="profile"></div>
					</div>

				</div>

				<footer>
				<hr>

				<p class="pull-right">
					<a href="#" title="" target="_blank">解释权归本小组所有</a>
				</p>


				<p>
					&copy; 2018 <a href="#" target="_blank">Xiao</a>
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
</html>