<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header.jsp"%>
    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Thêm mới phim</h3>

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
                    <label class="sr-only" for="">Tên phim</label>
                    <input type="email" class="form-control" id="" placeholder="Tên phim">
                  </div>

                  <div class="form-group">
                    <label class="sr-only" for="">Thể loại</label>
                    <select name="" id="input" class="form-control" required="required">
                      <option value="">Hài</option>
                      <option value="">Hành động</option>
                  </select>
                  </div>

                  <div class="form-group">
                    <label class="sr-only" for="">Quốc gia</label>
                    <select name="" id="input" class="form-control" required="required">
                      <option value="">Việt Nam</option>
                      <option value="">Mỹ</option>
                  </select>
                  </div>
                
                  
                
                  <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                </form>
                <br>
                
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th>STT</th>
                      <th>Tên phim</th>
                      <th>Ảnh</th>
                      <th>Thể loại</th>
                      <th>Quốc gia</th>
                      <th>Giá vé</th>
                      <th>Diễn viên</th>
                      <th>Thời lượng phim</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>Avatar</td>
                      <td>
                        <img src="" alt="">
                      </td>
                      <td>Hài</td>
                      <td>Việt Nam</td>
                      <td>
                        150000đ
                      </td>
                      <td>Diễn viên A</td>
                      <td>60:00</td>
                      <td>
                        
                        <button type="button" class="btn btn-success">Sửa</button>
                        <button type="button" class="btn btn-danger">Xóa</button>
                        
                      </td>
                    </tr>
                  </tbody>
                </table>
                
                
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