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

					<form action="" method="POST" role="form">
						<legend>Thêm mới phim</legend>

						<div class="form-group">
							<label for="">Tên phim</label> <input type="text"
								class="form-control" id="" placeholder="Input field">
						</div>

						<div class="form-group">
							<label for="">Thể loại</label> <select name="" id="input"
								class="form-control" required="required">
								<option value="">Hài</option>
								<option value="">Hành động</option>
							</select>
						</div>

						<div class="form-group">
							<label for="">Loại phim</label> <select name="" id="input"
								class="form-control" required="required">
								<option value="">2D</option>
								<option value="">3D</option>
							</select>
						</div>

						<div class="form-group">
							<label for="">Quốc gia</label> <select name="" id="input"
								class="form-control" required="required">
								<option value="">Việt Nam</option>
								<option value="">Trung Quốc</option>
							</select>
						</div>

						<div class="form-group">
							<label for="">Giá vé</label> <input type="text"
								class="form-control" id="" placeholder="Input field">
						</div>

						<div class="form-group">
							<label for="">Ảnh phim</label> <input type="file"
								class="form-control" id="" placeholder="Input field">
						</div>

						<div class="form-group">
							<label for="">Diễn Viên</label> <input type="text"
								class="form-control" id="" placeholder="Input field">
						</div>

						<div class="form-group">
							<label for="">Thời lượng</label> <input type="text"
								class="form-control" id="" placeholder="Input field">
						</div>
						
						<div class="form-group">
							<label for="">Mô tả</label>
							<textarea name="" id="input" class="form-control" rows="3" required="required"></textarea>
						</div>


						<button type="submit" class="btn btn-primary">Submit</button>
					</form>

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

<%@ include file="../layout/footer.jsp"%>