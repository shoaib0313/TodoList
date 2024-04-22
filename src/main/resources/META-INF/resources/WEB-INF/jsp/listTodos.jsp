<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>List Todos Page</title>

</head>
<body>
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
						<th><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete </a></th>
						<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update </a></td>
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
