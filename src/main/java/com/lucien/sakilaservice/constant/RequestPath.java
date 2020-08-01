package com.lucien.sakilaservice.constant;

public class RequestPath {
    public static final String HELLO = "/hello";

    public static final String GET_ALL_ACTORS = "/api/actors";
    public static final String GET_ACTOR = "/api/actor/{id}";
    public static final String GET_ACTOR_BY_FILTER = "/api/actor";
    public static final String CREATE_ACTOR = "/api/actor/create";
    public static final String UPDATE_ACTOR = "/api/actor/{id}/update";
    public static final String DELETE_ACTOR = "/api/actor/{id}/delete";
}
