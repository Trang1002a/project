<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ include file="../layout/header.jsp" %>
<style>
    .erorr {
        color: red;
    }

    .mr-5 {
        margin-right: 3rem !important;
    }
</style>
<!-- Main content -->
<section class="content">

    <!-- Default box -->
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">Thêm mới lịch chiếu</h3>

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
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="">Tên phim</label>
                            <form:select path="movies_id" cssClass="form-control">
                                <form:options items="${movies}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </div>

                        <div class="form-group">
                            <label for="">Chi nhánh</label>
                            <form:select path="branch_id" cssClass="form-control">
                                <form:options items="${branch}" itemLabel="name" itemValue="id"/>
                            </form:select>
                        </div>

                        <div class="form-group">
                            <label for="">Phòng chiếu</label>
                            <div class="form-group">
                                <c:forEach items="${room}" var="r">
                                    <label class="mr-5">
                                        <form:checkbox path="room_id" value="${r.id}"/>
                                            ${r.name}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success">Thêm mới</button>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="">Giờ chiếu</label>
                            <div class="form-group">
                                <c:forEach items="${hours}" var="r">
                                    <label class="mr-5">
                                        <form:checkbox path="hours_id" value="${r.id}"/>
                                            ${r.name}
                                    </label>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="">Ngày chiếu</label>
                            <form:input path="movie_day" type="date" cssClass="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="">Mã lịch chiếu</label>
                            <form:input path="name" cssClass="form-control" placeholder="Mã lịch chiếu"/>
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