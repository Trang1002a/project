<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header.jsp"%>
<!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Vé xem</h3>

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
                
                
                <form action="" method="POST" class="form-inline" role="form">
                
                  <div class="form-group">
                    <label class="sr-only" for="">label</label>
                    <input type="email" class="form-control" id="" placeholder="Input field">
                  </div>
                  <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                </form>
                
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th>STT</th>
                      <th>Mã vé</th>
                      <th>Tên phim</th>
                      <th>SDT</th>
                      <th>Tên khách hàng</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>#123</td>
                      <td>Avatar</td>
                      <td>0987654321</td>
                      <td>Ng Van A</td>
                      <td>
                        
                        <button type="button" class="btn btn-success" data-toggle="modal" href='#modal-id'>Chi tiết</button>
                        
                      </td>
                    </tr>
                  </tbody>
                </table>

                <div class="modal fade" id="modal-id">
                  <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Chi tiết vé #123</h4>
                        <h6>KH: Ng Van A - SDT: 0987654321</h6>
                      </div>
                      <div class="modal-body">
                        <table class="table table-hover">
                          <thead>
                            <tr>
                              <th>STT</th>
                              <th>Tên phim</th>
                              <th>Thể loại</th>
                              <th>Rạp</th>
                              <th>Phòng</th>
                              <th>Số ghế</th>
                              <th>Giờ chiếu</th>
                              <th>Giá vé</th>
                            </tr>
                          </thead>
                          <tbody>
                            <tr>
                              <td>1</td>
                              <td>Avatar</td>
                              <td>Hài</td>
                              <td>BHD - Mỹ Đình</td>
                              <td>25 Ghế</td>
                              <td>A1, A2</td>
                              <th>7:20</th>
                              <td>100000đ</td>
                            </tr>
                          </tbody>
                        </table>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                      </div>
                    </div>
                  </div>
                </div>
                
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