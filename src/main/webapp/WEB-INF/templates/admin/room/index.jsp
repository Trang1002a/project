<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header.jsp"%>
<!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Thêm mới phòng chiếu</h3>

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
                
                <form action="" method="POST" role="form">
                
                    <div class="form-group">
                        <label for="">Tên phòng</label>
                        <input type="text" class="form-control" id="" placeholder="Input field">
                    </div>

                    <div class="form-group">
                      <label for="">Hàng ghế</label>
                      <input type="number" class="form-control" id="" placeholder="5">
                  </div>

                  <div class="form-group">
                    <label for="">Dãy ghế</label>
                    <input type="number" class="form-control" id="" placeholder="5">
                </div>

                    <div class="form-group">
                      <label for="">Trạng thái</label>
                      <div class="radio">
                        <label>
                          <input type="radio" name="status" id="input" value="" checked="checked">
                          Hiển thị
                        </label>
                      </div>
                      <div class="radio">
                        <label>
                          <input type="radio" name="status" id="input" value="">
                          Tạm ẩn
                        </label>
                      </div>
                      
                  </div>
                
                    <button type="submit" class="btn btn-primary">Thêm mới</button>
                </form>
                
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