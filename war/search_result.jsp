<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">
		<div class="col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Suggestions</h3>
				</div>
				<div class="panel-body"></div>
				<table class="table table-hover" id="dev-table">
					<thead>
						<tr>
							<th>Catgory</th>
							<th>Information</th>
							<th>Creation Date</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${info}" var="suggestion">
							<tr>
								<td><c:out value="${ suggestion.category}"></c:out></td>
								<td><a
									href='<c:out value="${ suggestion.information}" ></c:out>'
									target="#"> <c:out value="${ suggestion.information}"></c:out>
								</a></td>
								<td><c:out value="${ suggestion.createDate}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
