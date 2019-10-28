package bex.ordersservice.models;

import java.util.Date;

public class Orderr {

    private String packkId;
    private String city;
    private Date date_time;
    public Orderr(String packkId, String city, Date date) {
        this.packkId = packkId;
        this.city = city;
        this.date_time = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPackkId() {
        return packkId;
    }

    public void setPackkId(String packkId) {
        this.packkId = packkId;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }
}
