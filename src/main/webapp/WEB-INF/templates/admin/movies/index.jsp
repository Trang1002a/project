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
            <a href="${pageContext.request.contextPath}/admin/movies/insert"
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
                <th>Tên phim</th>
                <th>Ảnh</th>

                <th>Giá</th>
                <th>Thời lượng</th>

                <th>Trạng thái</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${view}" var="v">
                <tr>
                    <td>${v.id}</td>
                    <td>${v.name}</td>
                    <td>${v.image}</td>

                    <td>${v.price}</td>
                    <td>${v.time}</td>

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
                        <a class="btn btn-small btn-warning" data-toggle="modal" href='#modal-id-detail-${v.id}'>Chi
                            tiết</a>
                        <a class="btn btn-small btn-success"
                           href="${pageContext.request.contextPath}/admin/movies/edit?id=${v.id}">Sửa</a>
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
                                   href="${pageContext.request.contextPath}/admin/movies/delete?id=${v.id}"
                                   class="btn btn-danger">Xóa</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="modal-id-detail-${v.id}">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button v="button" class="close" data-dismiss="modal" aria-hidden="true">&times;
                                </button>
                                <h4 class="modal-title">Chi tiết phim: ${v.name}</h4>
                            </div>
                            <div class="modal-body">
                                <p>Diễn viên: ${v.performer}</p>
                                <p>Mô tả: ${v.description}</p>
                                <h4>Thể loại</h4>
                                <c:forEach items="${v.type}" var="r">
                                    ${r.name},
                                </c:forEach>

                                <h4>Quốc gia</h4>
                                <c:forEach items="${v.country}" var="r">
                                    ${r.name},
                                </c:forEach>

                                <h4>Loại phim</h4>
                                <c:forEach items="${v.format}" var="r">
                                    ${r.name},
                                </c:forEach>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                                <a type="button"
                                   href="${pageContext.request.contextPath}/admin/branch/delete?id=${v.id}"
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