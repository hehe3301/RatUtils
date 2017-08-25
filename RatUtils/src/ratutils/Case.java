package ratutils;

import java.util.ArrayList;
import java.util.List;

public class Case
{
    private String case_id;
    private String client;
    private String system;
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
    private Boolean completed; // has the case been completed

    public Case(String case_id, String client, String system, String platform, Boolean code_red, String language) {
        this.case_id = case_id;
        this.client = client;
        this.system = system;
        this.platform = platform;
        this.code_red = code_red;
        this.language = language;
        this.assigned_rats= new ArrayList<>();

        this.fr = false; //Friend Request
        this.sysconf = false; //System confirmed status
        this.wr = false; //Wing Request
        this.bc = false; //Rat to report if bacon is toasty
        this.prep = false; //Prep status
        this.sys = false; //Rat to report if in system
        this.inst = false; //Rat to report if in instance with client
        this.completed = false; // has the case been completed
    }

    public void addRat(String rat_name)
    {
        this.assigned_rats.add(rat_name);
    }

    public List<String> getAssigned_rats() {
        return assigned_rats;
    }

    public String getCase_id() {
        return case_id;
    }

    public String getClient() {
        return client;
    }

    public String getPlatform() {
        return platform;
    }

    public String getLanguage() {
        return language;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Boolean getCode_red() {
        return code_red;
    }

    public void setCode_red(Boolean code_red) {
        this.code_red = code_red;
    }

    public Boolean getFr() {
        return fr;
    }

    public void setFr(Boolean fr) {
        this.fr = fr;
    }

    public Boolean getSysconf() {
        return sysconf;
    }

    public void setSysconf(Boolean sysconf) {
        this.sysconf = sysconf;
    }

    public Boolean getWr() {
        return wr;
    }

    public void setWr(Boolean wr) {
        this.wr = wr;
    }

    public Boolean getBc() {
        return bc;
    }

    public void setBc(Boolean bc) {
        this.bc = bc;
    }

    public Boolean getPrep() {
        return prep;
    }

    public void setPrep(Boolean prep) {
        this.prep = prep;
    }

    public Boolean getSys() {
        return sys;
    }

    public void setSys(Boolean sys) {
        this.sys = sys;
    }

    public Boolean getInst() {
        return inst;
    }

    public void setInst(Boolean inst) {
        this.inst = inst;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}