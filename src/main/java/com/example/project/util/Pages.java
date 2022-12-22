package com.example.project.util;

public enum Pages {
    REDIRECT("redirect:/"),
    ADMIN_HOME_INDEX("admin/index"),
    ADMIN_TYPE_INDEX("admin/type/index"),
    ADMIN_FOMAT_INDEX("admin/fomat/index"),
    ADMIN_COUNTRY_INDEX("admin/country/index"),
    ADMIN_BRANCH_INDEX("admin/branch/index"),
    ADMIN_HOURS_INDEX("admin/hours/index"),
    ADMIN_ROOM_INDEX("admin/room/index"),
    ADMIN_TICKET_INDEX("admin/ticket/index"),
    ADMIN_SHOWTIMES_INDEX("admin/showtimes/index");

    private String uri;

    Pages(String uri) {
        this.uri = uri;
    }

    public String uri() {
        return this.uri;
    }
}
