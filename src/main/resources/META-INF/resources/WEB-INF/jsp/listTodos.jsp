<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>List Todos Page</title>

</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
		<a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28Minutes</a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="https://facebook.com">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
			</ul>
		</div>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/login">Logout</a></li>
		</ul>
	</nav>

	<div class="container">
		<h1>Your Todos are</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done</th>
					<th>action</th>
					<th>action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<th><a href="delete-todo?id=${todo.id}"
							class="btn btn-warning">Delete </a></th>
						<td><a href="update-todo?id=${todo.id}"
							class="btn btn-success">Update </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>



		<script type="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
		<script type="webjars/jquery/3.7.1/jquery.min.js"></script>
	</div>
</body>
</html>
