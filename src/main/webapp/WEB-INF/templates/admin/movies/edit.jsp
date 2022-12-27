<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="../layout/header.jsp" %>
<style>
    .erorr {
        color: red;
    }
    .mr-5 { margin-right:3rem!important; }
</style>
<!-- Main content -->
<section class="content">

    <!-- Default box -->
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">Chỉnh sửa mới phim</h3>

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
            <div class="row">
                <form:form action="insert" modelAttribute="view" method="post">
                    <form:input path="id" cssClass="form-control" type="hidden" value="${view.id}"/>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="">Tên phim</label>
                            <form:input path="name" cssClass="form-control" placeholder="Tên phim"/>
                        </div>

                        <div class="form-group">
                            <label for="">Giá</label>
                            <form:input path="price" cssClass="form-control" placeholder="Giá"/>
                        </div>
                        <div class="form-group">
                            <label for="">Diễn viên</label>
                            <form:input path="performer" cssClass="form-control" placeholder="Diễn viên"/>
                        </div>
                        <div class="form-group">
                            <label for="">Thời lượng (Phút)</label>
                            <form:input path="time" type="number" cssClass="form-control" placeholder="Thời lượng"/>
                        </div>
                        <div class="form-group">
                            <label for="">Mô tả</label>
                            <form:textarea path="description" cssClass="form-control" rows="3"/>
                        </div>
                        <div class="form-group">
                            <label for="">Trạng thái</label>
                            <div class="radio">
                                <label> <form:radiobutton path="status" value="1"/>Hiển
                                    thị
                                </label>
                            </div>
                            <div class="radio">
                                <label> <form:radiobutton path="status" value="0"/>Ẩn
                                </label>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-success">Cập nhật</button>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="">Thể loại</label>
                            <div class="form-group">
                                <c:forEach items="${type}" var="r">
                                    <label class="mr-5">
                                        <form:checkbox path="type_id" value="${r.id}"/>
                                            ${r.name}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">Quốc gia</label>
                            <div class="form-group">
                                <c:forEach items="${country}" var="r">
                                    <label class="mr-5">
                                        <form:checkbox path="country_id" value="${r.id}"/>
                                            ${r.name}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">Loại phim</label>
                            <div class="form-group">
                                <c:forEach items="${format}" var="r">
                                    <label class="mr-5">
                                        <form:checkbox path="format_id" value="${r.id}"/>
                                            ${r.name}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="">Ảnh</label>
                            <form:input path="image" cssClass="form-control" placeholder="Ảnh phim"/>
                        </div>

                    </div>
                </form:form>
            </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">Footer</div>
        <!-- /.box-footer-->
    </div>
    <!-- /.box -->

</section>
<!-- /.content -->
<%@ include file="../layout/footer.jsp" %>