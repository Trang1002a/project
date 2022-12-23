<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../layout/header.jsp"%>
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
          <h3 class="box-title">Thêm mới thể loại</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                    title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
        <div class="box-body">
          <div class="row">
            <div class="col-md-12">
                
                <form:form action="insert" modelAttribute="type" method="post">

						<div class="form-group">
							<label for="">Quốc gia</label>
							<form:input path="name" cssClass="form-control" />
							<form:errors path="name" cssClass="erorr" />
						</div>
						<div class="form-group">
							<label for="">Tên viết tắt</label>
							<form:input path="short_name" cssClass="form-control" />
							<form:errors path="short_name" cssClass="erorr" />
						</div>

						<div class="form-group">
							<label for="">Trạng thái</label>
							<div class="radio">
								<label> <form:radiobutton path="status" value="1" />Hiển
									thị
								</label>
							</div>
							<div class="radio">
								<label> <form:radiobutton path="status" value="0" />Ẩn
								</label>
							</div>


							<form:errors path="status" cssClass="erorr" />
						</div>

						<button type="submit" class="btn btn-primary">Thêm mới</button>
					</form:form>
                
            </div>
          </div>
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          Footer
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
<%@ include file="../layout/footer.jsp"%>