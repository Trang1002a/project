<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="layout/header.jsp" %>
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
<%--<section id="amy-page-header" class="amy-page-header">--%>
<%--    <img src="<c:url value="/wp/wp-content/uploads/sites/2/2022/05/img_26.jpg" />" alt="Kubo and the Two Strings"/>--%>
<%--</section>--%>

<section class="main-content amy-movie single-movie layout-full has-banner">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="page-content">

                    <article id="post-79"
                             class="post-79 amy_movie type-amy_movie status-publish amy_genre-cartoon amy_genre-comic amy_actor-alexander-cattly amy_actor-cartin-hollia amy_actor-greta-garbo amy_director-grace-belly amy_director-mae-west">

                        <div class="entry-showtime single-cinema">
                            <div class="clearfix">
                                <h3 class="info-name amy-title">Tìm kiếm vé xem</h3>
                            </div>
                            <div class="showtime text-center">
                                <form action="" method="get" class="form-inline"
                                      role="form">
                                    <div class="form-group">
                                        <input id="content" type="text"
                                               name="phone_number" class="form-control" placeholder="Số điện thoại ...">
                                        <input id="content1" type="text"
                                               name="ticket_id" class="form-control" placeholder="Mã vé ...">
                                    </div>
                                    <button type="submit" class="btn btn-primary">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </form>

                                <div class="showtime text-center">
                                    <c:forEach var="v" items="${view}">
                                    <div>
                                        <h3>Tên phim: <a href="">${v.movie}</a></h3>
                                        <p>Phòng chiếu: ${v.room}</p>
                                        <p>Suất chiếu: ${v.hour_id} - Ngày chiếu: ${v.movie_day}</p>
                                        <p>Ghế: ${v.slot}</p>
                                        <p>Chi nhánh: ${v.branch}</p>
                                        <p>Mã vé: #${v.id}</p>
                                        <p>Tổng tiền: ${v.total_price}</p>
                                    </div>
                                    </c:forEach>

                                </div>
                            </div>
                        </div>


                    </article>
                </div>
            </div>
        </div>
    </div>
</section>


<%@ include file="layout/footer.jsp" %>