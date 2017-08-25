package ratutils;

import java.util.List;

public class Case
{
    private String case_id;
    private String client;
    private String system;
    private String distance;
    private String platform;
    private Boolean code_red;
    private String language;
    private List<String> assigned_rats;

    private Boolean fr; //Friend Request
    private Boolean sysconf; //System confirmed status
    private Boolean wr; //Wing Request
    private Boolean bc; //Rat to report if bacon is toasty
    private Boolean prep; //Prep status
    private Boolean sys; //Rat to report if in system
    private Boolean inst; //Rat to report if in instance with client

}