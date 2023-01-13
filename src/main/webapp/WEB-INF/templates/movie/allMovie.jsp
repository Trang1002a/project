<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="layout/header.jsp"%>
<section>
    <div class="container">
        <form action="" method="get" class="form-inline"
              role="form">
            <div class="form-group">
                <input id="content" type="text"
                       name="name" class="form-control" placeholder="Tên phim">
            </div>
            <button type="submit" class="btn btn-primary">
                <i class="fa fa-search" aria-hidden="true">Tìm kiếm</i>
            </button>
        </form>
    </div>
</section>

<section
        class="elementor-section elementor-top-section elementor-element elementor-element-e615b68 elementor-section-boxed elementor-section-height-default elementor-section-height-default"
        data-id="e615b68" data-element_type="section">
    <div class="elementor-container elementor-column-gap-default">
        <div class="elementor-column elementor-col-100 elementor-top-column elementor-element elementor-element-a503e51"
             data-id="a503e51" data-element_type="column">
            <div class="elementor-widget-wrap elementor-element-populated">
                <div class="elementor-element elementor-element-46cb6f1 elementor-widget elementor-widget-Amy_V2_Movie_Heading"
                     data-id="46cb6f1" data-element_type="widget" data-widget_type="Amy_V2_Movie_Heading.default">
                    <div class="elementor-widget-container">
                        <div class="amy-heading text-center has-seperator    seperator-1 ">
                            <header class="entry-header"><span class="seperator seperator-left"></span>
                                <h2 class="title-heading"><span class="title">Now Playing</span>
                                </h2><span class="seperator seperator-right"></span>
                            </header>
                        </div>
                    </div>
                </div>
                <div class="elementor-element elementor-element-f8ea438 elementor-widget elementor-widget-Amy_Movie_Grid"
                     data-id="f8ea438" data-element_type="widget" data-widget_type="Amy_Movie_Grid.default">
                    <div class="elementor-widget-container">
                        <div class="amy-shortcode amy-mv-grid layout1">
                            <div class="row amy-ajax-content">
                                <c:forEach items="${view}" var="v">
                                <div class="col-md-15 grid-item">
                                    <article class="entry-item" onclick="">
                                        <div class="entry-thumb">
                                            <img class="" src="<c:url value="/static/images/${v.image}"/>"
                                                 alt="Kubo and the Two Strings" />
                                            <div class="right-info">
                                                <span class="pg">
                                                    G </span>
                                            </div>
                                        </div>
                                        <div class="entry-content">
                                            <h4 class="entry-title">
                                                ${v.name} </h4>
                                            <div class="entry-date">
                                                Release: ${v.movie_day} </div>
                                            <div class="entry-button">
                                                <a href="https://player.vimeo.com/video/51834631">
                                                    <i aria-hidden="true" class="fa fa-play"></i>
                                                    Trailer </a>
                                                <a href="${pageContext.request.contextPath}/movie/detail?id=${v.id}">
                                                    <i aria-hidden="true" class="fa fa-exclamation"></i>
                                                    Detail </a>
                                            </div>
                                        </div>
                                        <div class="pic-caption open-left">
                                            <h4 class="entry-title">
                                                <a href="${pageContext.request.contextPath}/movie/detail?id=${v.id}">
                                                        ${v.name} </a>
                                            </h4>
                                            <span class="pg">
                                                G </span>
                                            <div class="desc-mv">
                                                <p>
                                                    <span>Release: </span>
                                                        ${v.movie_day}
                                                </p>

                                                <p>
                                                    <span>Format: </span>
                                                        ${v.format}
                                                </p>

                                                <p>
                                                    <span>Type: </span>
                                                        ${v.type}
                                                </p>

                                                <p>
                                                    <span>Duration: </span>
                                                        ${v.time} minutes
                                                </p>

<%--                                                <p>--%>
<%--                                                    <span>Language: </span>--%>
<%--                                                    English--%>
<%--                                                </p>--%>
                                            </div>


                                            <div class="entry-button">
                                                <a href="https://player.vimeo.com/video/51834631"
                                                   class="fancybox.iframe amy-fancybox">
                                                    <i aria-hidden="true" class="fa fa-play"></i>
                                                    Trailer </a>
                                                <a href="movie/kubo-and-the-two-strings/index.html">
                                                    <i aria-hidden="true" class="fa fa-exclamation"></i>
                                                    Detail </a>
                                            </div>
                                        </div>
                                    </article>
                                </div>
                                </c:forEach>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<%@ include file="layout/footer.jsp"%>