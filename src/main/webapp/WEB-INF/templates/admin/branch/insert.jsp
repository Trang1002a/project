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
<script>

    var dem = 0;
    function addRoom() {
        dem++
        var name = document.getElementById("room_name").value;
        var row = document.getElementById("room_row").value;
        var col = document.getElementById("room_col").value;
        let rows = $("#newValue").html();
        rows += '<p id="'+dem+'" name="room" value="111">' +
            'Phòng <label name="room['+dem+'].name" value="'+name+'">' + name + '<label/>, '+ row + ' hàng, ' + col + ' cột   ' +
            '<button type="button" class="btn btn-danger" onclick="deleteRoom('+dem+')"> - </button>' +
            '</p> ';
        $("#newValue").html(rows);
    }

    function deleteRoom(val) {
        var x = '#'+val;
        $(x).remove();
        // var x = document.getElementById("branchChange").value;
        // document.getElementById("newValue").innerHTML = "You selected: " + x;
        // console.log(x);

    }
</script>
<!-- Main content -->
<section class="content">

    <!-- Default box -->
    <div class="box">
        <div class="box-header with-border">
            <h3 class="box-title">Thêm mới chi nhánh</h3>

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
                            <label for="">Tên chi nhánh</label>
                            <form:input path="name" cssClass="form-control" placeholder="Tên chi nhánh"/>
                        </div>
                        <div class="form-group">
                            <label for="">Tên viết tắt</label>
                            <form:input path="short_name" cssClass="form-control" placeholder="Tên viết tắt"/>
                        </div>

                        <div class="form-group">
                            <label for="">Số điện thoại</label>
                            <form:input path="phone_number" cssClass="form-control" placeholder="Số điện thoại"/>
                        </div>

                        <div class="form-group">
                            <label for="">Địa chỉ</label>
                            <form:input path="address" cssClass="form-control" placeholder="Địa chỉ"/>
                        </div>

                        <label for="">Phòng chiếu</label>
                        <div class="form-group" id="newValue">
                            <form:input path="room" value="{}"/>123
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

                        <button type="submit" class="btn btn-success">Thêm mới</button>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="">Tên phòng</label>
                            <input type="text" id="room_name" class="form-control" value="">
                        </div>
                        <div class="form-group">
                            <label for="">Số hàng</label>
                            <input type="text" id="room_row" class="form-control" value="">
                        </div>

                        <div class="form-group">
                            <label for="">Số cột</label>
                            <input type="text" id="room_col" class="form-control" value="">
                        </div>

                        <button type="button" class="btn btn-success" onclick="addRoom()">Thêm phòng</button>
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