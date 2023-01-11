<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="layout/header.jsp" %>
<script>

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
                        <div class="row amy-single-movie">
                            <div class="col-md-4 col-sm-4">
                                <div class="entry-thumb">
                                    <img class=""
                                         src="<c:url value="/static/images/${view.movies.image}"/>"
                                         alt="Kubo and the Two Strings"/>
                                </div>
                            </div>
                            <div class="col-md-8 col-sm-8">
                                <div class="entry-info">
                                    <h1 class="entry-title p-name" itemprop="name headline">
                                        <a href="index.html" rel="bookmark" class="u-url url"
                                           itemprop="url">
                                            ${view.movies.name} </a>
                                    </h1>


                                    <div class="entry-pg">
                                        <span class="pg">G</span>

                                        <span class="duration">
                                            <i class="fa fa-clock-o"></i>
                                            ${view.movies.time} minutes</span>
                                    </div>

                                    <ul class="info-list">
                                        <li>
                                            <label>
                                                Type:
                                            </label>
                                            <span>
                                                <a href="../../actor/alexander-cattly/index.html">${view.movies.type_id}</a></span>
                                        </li>

                                        <li>
                                            <label>
                                                Format:
                                            </label>
                                            <span>
                                                <a href="../../director/grace-belly/index.html">${view.movies.format_id}</a> </span>
                                        </li>

                                        <li>
                                            <label>
                                                Price:
                                            </label>
                                            <span>
                                                <a href="../../genre/cartoon/index.html">${view.movies.price}</a>
                                            </span>
                                        </li>



                                        <li>
                                            <label>
                                                Country:
                                            </label>
                                            <span>
                                                ${view.movies.country_id} </span>
                                        </li>

                                        <li>
                                            <label>
                                                IMDB Rating:
                                            </label>
                                            <span>
                                                8.5 </span>
                                        </li>


                                    </ul>
                                </div>

                                <div class="entry-action">
                                    <div class="mrate  no-rate">
                                    </div>
                                    <div class="entry-share">
                                        <label>Share:</label>
                                        <ul class="amy-social-links clearfix">
                                            <li>
                                                <a href="https://www.facebook.com/sharer.php?u=http://demo.amytheme.com/movie/demo/elementor-single-cinema/movie/kubo-and-the-two-strings/"
                                                   class="fab fa-facebook" target="_blank"></a></li>
                                            <li>
                                                <a href="http://www.twitter.com/share?url=http://demo.amytheme.com/movie/demo/elementor-single-cinema/movie/kubo-and-the-two-strings/"
                                                   class="fab fa-twitter" target="_blank"></a></li>
                                            <li>
                                                <a href="http://pinterest.com/pin/create/button/?url=http://demo.amytheme.com/movie/demo/elementor-single-cinema/movie/kubo-and-the-two-strings/"
                                                   class="fab fa-pinterest" target="_blank"></a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>

                                <div class="entry-content e-content" itemprop="description articleBody">
                                    <h3 class="info-name amy-title">Synopsis</h3>
                                    <p>${view.movies.description}</p>
                                </div>
                            </div>
                        </div>

                        <div class="entry-showtime single-cinema">
                            <div class="clearfix">
                                <h3 class="info-name amy-title">Showtime</h3>
                            </div>
                            <div class="showtime row">
                                <div class="col-4">
                                    <div class="list-group" id="list-tab" role="tablist">
                                        <c:forEach var="v" items="${view.branch}" varStatus="index">
                                            <a class="list-group-item list-group-item-action <c:if test="${index.index == 0}">active</c:if>"
                                               id="list-${v.branch_id}-list" data-toggle="list"
                                               href="#list-${v.branch_id}"
                                               role="tab" aria-controls="home">${v.branch_name}</a>
                                        </c:forEach>
                                    </div>
                                </div>

                                <div class="col-8">
                                    <div class="tab-content" id="nav-tabContent">
                                        <c:forEach var="v" items="${view.branch}" varStatus="index">
                                            <div class="showtime-item single-cinema tab-pane fade <c:if test="${index.index == 0}">show active</c:if>"
                                                 id="list-${v.branch_id}" role="tabpanel"
                                                 aria-labelledby="list-${v.branch_id}-list">
                                                <c:forEach var="d" items="${v.day_hours}">
                                                    <div class="st-item">
                                                        <div class="st-title"><label>${d.movie_day}</label>
                                                        </div>
                                                        <ul>
                                                            <c:forEach var="h" items="${d.hours}">
                                                                <li style="background: none !important; padding: 0!important;">
                                                                        <a style="margin-top: 0!important;" href="${pageContext.request.contextPath}/movie/bookTicket?id=${d.id}&&hour=${h.id}"
                                                                       class="amy-buy-ticket"
                                                                       target="_blank">${h.name}</a></li>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </c:forEach>
                                    </div>
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