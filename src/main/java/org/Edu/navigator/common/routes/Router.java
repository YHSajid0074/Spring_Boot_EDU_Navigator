package org.Edu.navigator.common.routes;

public class Router {

    //Coordinator
    public static final String COORDINATOR = ApiConstants.BASE_URL_V1 + "/coordinator";
    public static final String CREATE_COORDINATOR="/create-coordinator";
    public static final String GET_COORDINATOR_BY_ID="/get-coordinator"+"/{id}";
    public static final String UPDATE_COORDINATOR="/update-coordinator";
    public static final String DELETE_COORDINATOR="/delete-coordinator"+"/{id}";
    public static final String GET_ALL_COORDINATOR="/get-all-coordinator";


    //User
    public static final String COURSE=ApiConstants.BASE_URL_V1 + "/course";
    public static final String CREATE_COURSE="/create-course";
    public static final String GET_ALL_COURSES="/get-all-cours";
    public static final String GET_COURSE_BY_ID="/get-course"+"/{id}";
    public static final String UPDATE_COURSE="/update-course";
    public static final String DELETE_COURSE="/delete-course"+"/{id}";


    //Director
    public static final String DIRECTOR=ApiConstants.BASE_URL_V1 + "/director";
    public static final String CREATE_DIRECTOR="/create-director";
    public static final String GET_ALL_DIRECTOR="/get-all-director";
    public static final String GET_DIRECTOR_BY_ID="/get-directors"+"/{id}";
    public static final String GET_DIRECTOR_BY_NAME="/get-directors"+"/{name}";
    public static final String UPDATE_DIRECTOR="/update-director";
    public static final String DELETE_DIRECTOR="/delete-director";


    //Trainee
    public static final String TRAINEE=ApiConstants.BASE_URL_V1 + "/trainee";
    public static final String CREATE_TRAINEE="/create-trainee";
    public static final String GET_ALL_TRAINEE="/get-all-trainee";
    public static final String GET_TRAINEE_BY_ID="/get-trainee"+"/{id}";
    public static final String UPDATE_TRAINEE="/update-trainee";
    public static final String DELETE_TRAINEE="/delete-trainee"+"/{id}";


    //Trainer
    public static final String TRAINER=ApiConstants.BASE_URL_V1 + "/trainer";
    public static final String CREATE_TRAINER="/create-trainer";
    public static final String GET_ALL_TRAINER="/get-all-trainer";
    public static final String GET_TRAINER_BY_ID="/get-trainer"+"/{id}";
    public static final String UPDATE_TRAINER="/update-trainer";
    public static final String DELETE_TRAINER="/delete-trainer"+"/{id}";


}
