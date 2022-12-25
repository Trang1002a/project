<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../layout/header.jsp" %>
<div class="box">
	<div class="box-header with-border">
		<h3 class="box-title"></h3>
		<form action="" method="get" class="form-inline"
			  role="form">
			<div class="form-group">
				<input id="content" type="text"
					   name="name" class="form-control" placeholder="Tìm kiếm ...">
			</div>
			<button type="submit" class="btn btn-primary">
				<i class="fa fa-search" aria-hidden="true"></i>
			</button>
			<a href="${pageContext.request.contextPath}/admin/country/insert"
			   class="btn btn-success btn-sm">Thêm mới</a>
		</form>
		<div class="box-tools pull-right">
			<button type="button" class="btn btn-box-tool"
					data-widget="collapse" data-toggle="tooltip" title="Collapse">
				<i class="fa fa-minus"></i>
			</button>
			<button type="button" class="btn btn-box-tool" data-widget="remove"
					data-toggle="tooltip" title="Remove">
				<i class="fa fa-times"></i>
			</button>
		</div>
	</div>
	<div class="box-body">
		<table class="table table-hover">
			<thead>
			<tr>
				<th>Id</th>
				<th>Country Name</th>
				<th>Short Name</th>
				<th>Status</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${view}" var="v">
				<tr>
					<td>${v.id}</td>
					<td>${v.name}</td>
					<td>${v.short_name}</td>
					<td>
						<c:choose>
							<c:when test="${v.status == true}">
								<span class="label label-success">Hiện thị</span>
							</c:when>
							<c:when test="${v.status == false}">
								<span class="label label-danger">Ẩn</span>
							</c:when>
						</c:choose>
					</td>
					<td>
						<a class="btn btn-small btn-success"
						   href="${pageContext.request.contextPath}/admin/country/edit?id=${v.id}">Sửa</a>
						<a class="btn btn-small btn-danger" data-toggle="modal" href='#modal-id-${v.id}'>Xóa</a>
					</td>
				</tr>
				<div class="modal fade" id="modal-id-${v.id}">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button v="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
								</button>
								<h4 class="modal-title">Bạn có chắc xóa: ${v.name}</h4>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
								<a type="button"
								   href="${pageContext.request.contextPath}/admin/country/delete?id=${v.id}"
								   class="btn btn-danger">Xóa</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /.box-body -->
	<!-- /.box-footer-->
	<div class="box-footer text-center">
		<nav aria-label="Page navigation ">
			<ul class="pagination">
				<c:forEach begin="1" end="${Math.ceil(totalItems/page)}" var="i">
					<li class="page-item">
						<a class="page-link" id="${i}"
						   href="${pageContext.request.contextPath}/admin/type?<c:if test="${name != ''}">name=${name}&</c:if>page=${i}">${i}</a>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</div>
</div>
<%@ include file="../layout/footer.jsp" %>