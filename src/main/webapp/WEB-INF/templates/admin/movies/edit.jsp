<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="../layout/header.jsp" %>
<style>
    .erorr {
        color: red;
    }
</style>
<!-- Main content -->
<section class="content">

    <!-- Default box -->
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">Sửa mới phim</h3>

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
                <div class="col-md-12">

                    <form:form action="insert" modelAttribute="view" method="post">
                        <form:input path="id" cssClass="form-control" type="hidden" value="${view.id}"/>
                        <div class="form-group">
                            <label for="">Tên phim</label>
                            <form:input path="name" cssClass="form-control" placeholder="Tên phim" value="${view.name}"/>
                        </div>
                        <div class="form-group">
                            <label for="">Thể loại</label>
                            <form:select path="type_id" cssClass="form-control">
                                <form:options items="${type}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="">Quốc gia</label>
                            <form:select path="country_id" cssClass="form-control">
                                <form:options items="${country}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="">Loại phim</label>
                            <form:select path="format_id" cssClass="form-control">
                                <form:options items="${format}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </div>
                        <div class="form-group">
                            <label for="">Giá</label>
                            <form:input path="price" cssClass="form-control" placeholder="Giá" value="${view.price}"/>
                        </div>
                        <div class="form-group">
                            <label for="">Ảnh</label>
                            <form:input path="image" cssClass="form-control" placeholder="Ảnh phim" value="${view.image}"/>
                        </div>
                        <div class="form-group">
                            <label for="">Diễn viên</label>
                            <form:input path="performer" cssClass="form-control" placeholder="Diễn viên" value="${view.performer}"/>
                        </div>
                        <div class="form-group">
                            <label for="">Thời lượng</label>
                            <form:input path="time" cssClass="form-control" placeholder="Thời lượng" value="${view.time}"/>
                        </div>
                        <div class="form-group">
                            <label for="">Mô tả</label>
                            <form:textarea path="description" cssClass="form-control" rows="3" value="${view.description}"/>
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
                    </form:form>

                </div>
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