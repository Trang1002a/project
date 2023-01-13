<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="layout/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
    input[type="checkbox"] {
        /* Add if not using autoprefixer */
        -webkit-appearance: none;
        appearance: none;
        /* For iOS < 15 to remove gradient background */
        background-color: #fff;
        /* Not removed via appearance */
        margin: 0;
        font: inherit;
        color: currentColor;
        width: 1.15em;
        height: 1.15em;
        border: 0.15em solid currentColor;
        border-radius: 0.15em;
        transform: translateY(-0.075em);
        display: grid;
        place-content: center;
    }

    input[type="checkbox"]::before {
        content: "";
        width: 0.65em;
        height: 0.65em;
        transform: scale(0);
        transition: 120ms transform ease-in-out;
        box-shadow: inset 1em 1em var(--form-control-color);
        background-color: green;
    }

    input[class="checkboxRed"]::before {
        content: "";
        width: 0.65em;
        height: 0.65em;
        transform: scale(0);
        transition: 120ms transform ease-in-out;
        box-shadow: inset 1em 1em var(--form-control-color);
        background-color: red;
    }

    input[type="checkbox"]:checked::before {
        transform: scale(1);
    }
</style>
<script>
    $(document).ready(function(){
        dem = 0;
        price = $("#price").val();
        $(".checkbox").change(function() {
            if(this.checked) {
                dem++
            } else {
                dem--
            }
            total_price = dem * price;
            $("#total_ticket").html(dem);
            $("#total_price").html(total_price);

        });
    });
</script>
<section id="amy-page-header" class="amy-page-header">
    <img src="<c:url value="/wp/wp-content/uploads/sites/2/2022/05/img_26.jpg" />" alt="Kubo and the Two Strings"/>
</section>

<section class="main-content amy-movie single-movie layout-full has-banner">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="page-content">

                    <article id="post-79"
                             class="post-79 amy_movie type-amy_movie status-publish amy_genre-cartoon amy_genre-comic amy_actor-alexander-cattly amy_actor-cartin-hollia amy_actor-greta-garbo amy_director-grace-belly amy_director-mae-west">

                        <div class="entry-showtime single-cinema">
                            <div class="clearfix">
                                <h3 class="info-name amy-title">Chọn ghế ngồi</h3>
                            </div>
                            <div class="showtime text-center">
                                <form:form action="book" modelAttribute="req" method="post">
                                    <div>
                                        <h3>Tên phim: <a href="">${view.name_movie}</a></h3>
                                        <form:input path="movie" type="hidden" value="${view.name_movie}"/>
                                        <form:input path="ticket_id" type="hidden" value="#${view.id}-${view.hour_id}"/>
                                        <form:input path="room" type="hidden" value="${view.rooms_name}"/>
                                        <form:input path="movie_day" type="hidden" value="${view.movie_day}"/>
                                        <form:input path="branch" type="hidden" value="${view.branch_name}"/>
                                        <form:input path="price" type="hidden" value="${view.price}"/>
                                        <form:input path="hour_id" type="hidden" value="${view.hour_id}"/>

                                        <p>Phòng chiếu: ${view.rooms_name} - ${view.total} ghế</p>
                                        <p>Suất chiếu: ${view.hour} - Ngày chiếu: ${view.movie_day}</p>
                                        <p>Chi nhánh: ${view.branch_name}</p>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-8">
                                            <p>Để chọn ghế vui lòng chọn ghế ưa thích theo icon <br/>
                                                Click tiếp vào ghế đã chọn để xoá lựa chọn</p>
                                            <p>
                                            <div class="checkbox">
                                                <label class="mr-5">
                                                    <input type="checkbox" name="checkbox"
                                                           class="checkboxRed" checked disabled/>
                                                    Ghế đã đặt
                                                </label>

                                                <label class="">
                                                    <input type="checkbox" name="checkbox" checked
                                                           disabled/>
                                                    Ghế đã chọn
                                                </label>
                                            </div>
                                            <div>
                                                <c:set var="index" scope="page" value="0"/>
                                                <c:forEach var="r" items="${view.slot}">
                                                    <c:if test="${index == view.col}">
                                                        <c:set var="index" scope="page" value="0"/><br/><br/>
                                                    </c:if>

                                                    <c:if test="${r.check == true}">
                                                        <label class="mr-5">
                                                            <input type="checkbox" name="checkbox"
                                                                   class="checkboxRed" checked disabled/>${r.name}
                                                        </label>
                                                    </c:if>
                                                    <c:if test="${r.check != true}">
                                                        <label class="mr-5">
                                                            <input type="checkbox" name="slot" class="checkbox"
                                                                   value="${r.name}" id="${r.name}" />${r.name}
                                                        </label>
                                                    </c:if>
                                                    <c:set var="index" value="${index + 1}" scope="page"/>
                                                </c:forEach>
                                                <div class="form-group w-80" >
                                                    <input id="content" type="text"
                                                           name="phoneNumber" class="form-control" placeholder="Số điện thoại ...">
                                                </div>
                                            </div>

<%--                                            <div>--%>
<%--                                                <label class="">--%>
<%--                                                    <input type="checkbox" name="checkbox"/>--%>
<%--                                                </label>--%>
<%--                                                <label class="">--%>
<%--                                                    <input type="checkbox" name="checkbox"--%>
<%--                                                           class="checkboxRed" checked disabled/>--%>
<%--                                                </label>--%>
<%--                                            </div>--%>

                                        </div>
                                        <div class="col-md-4">
                                            <div class="entry-item">
                                                <img src="<c:url value="/static/images/${view.image}"/>"
                                                     alt="" width="200px">
                                                <div class="mt-5">

                                                    <p>Số lượng: <span id="total_ticket">0</span> vé</p>
                                                    <hr/>
                                                    <p>Tổng tiền: <span id="total_price">0</span>đ</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-success">Đặt vé</button>
                                </form:form>
                            </div>
                        </div>


                    </article>
                </div>
            </div>
        </div>
    </div>
</section>


<%@ include file="layout/footer.jsp" %>