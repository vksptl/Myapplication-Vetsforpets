package com.vikas.myapplication;

/**
 *
 */
public class Disease {

    private String detail;
    private String heading;

    public void addDetail(String detail) {
        this.detail=this.detail+"\n"+detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
}
