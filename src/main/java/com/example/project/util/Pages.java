package com.example.project.util;

public enum Pages {
    REDIRECT("redirect:/"),
    ADMIN_HOME_INDEX("admin/index"),
    ADMIN_TYPE_INDEX("admin/type/index"),
    ADMIN_FORMAT_INDEX("admin/format/index"),
    ADMIN_MOVIES_INDEX("admin/movies/index"),
    ADMIN_COUNTRY_INDEX("admin/country/index"),
    ADMIN_BRANCH_INDEX("admin/branch/index"),
    ADMIN_HOURS_INDEX("admin/hours/index"),
    ADMIN_ROOM_INDEX("admin/room/index"),
    ADMIN_TICKET_INDEX("admin/ticket/index"),
    ADMIN_SHOWTIMES_INDEX("admin/showtimes/index"),
    // insert
    ADMIN_HOME_INSERT("admin/insert"),
    ADMIN_TYPE_INSERT("admin/type/insert"),
    ADMIN_FORMAT_INSERT("admin/format/insert"),
    ADMIN_MOVIES_INSERT("admin/movies/insert"),
    ADMIN_COUNTRY_INSERT("admin/country/insert"),
    ADMIN_BRANCH_INSERT("admin/branch/insert"),
    ADMIN_HOURS_INSERT("admin/hours/insert"),
    ADMIN_ROOM_INSERT("admin/room/insert"),
    ADMIN_TICKET_INSERT("admin/ticket/insert"),
    ADMIN_SHOWTIMES_INSERT("admin/showtimes/insert"),
    // EDIT
    ADMIN_HOME_EDIT("admin/edit"),
    ADMIN_TYPE_EDIT("admin/type/edit"),
    ADMIN_FORMAT_EDIT("admin/format/edit"),
    ADMIN_MOVIES_EDIT("admin/movies/edit"),
    ADMIN_COUNTRY_EDIT("admin/country/edit"),
    ADMIN_BRANCH_EDIT("admin/branch/edit"),
    ADMIN_HOURS_EDIT("admin/hours/edit"),
    ADMIN_ROOM_EDIT("admin/room/edit"),
    ADMIN_TICKET_EDIT("admin/ticket/edit"),
    ADMIN_SHOWTIMES_EDIT("admin/showtimes/edit"),


    //Movie
    USER_HOME_INDEX("movie/index"),
    MOVIE_DETAIL("movie/detail");


    private String uri;

    Pages(String uri) {
        this.uri = uri;
    }

    public String uri() {
        return this.uri;
    }
}
