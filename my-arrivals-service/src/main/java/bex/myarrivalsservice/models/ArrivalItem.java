package bex.myarrivalsservice.models;

import java.util.Date;

public class ArrivalItem {

    private String city;
    private String packk;
    private String desc;
    private Date date_time;

    public ArrivalItem(String city, String packk, String desc, Date date_time) {
        this.city = city;
        this.packk = packk;
        this.desc = desc;
        this.date_time = date_time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPackk() {
        return packk;
    }

    public void setPackk(String packk) {
        this.packk = packk;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }
}
