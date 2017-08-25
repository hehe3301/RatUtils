package ratutils;

import java.util.List;

public class Case
{
    private String case_id;
    private String client;
    private String system;
    private String platform;
    private Boolean code_red;
    private String language;
    private List<String> assigned_rate;

    private Boolean fr; //Friend Request
    private Boolean wr; //Wing Request
    private Boolean prep; //Prep status
    private Boolean sysconf; //System confirmed status
    private Boolean sys; //Rat to report if in system
    private Boolean bc; //Rat to report if bacon is toasty
    private Boolean inst; //Rat to report if in instance with client

}