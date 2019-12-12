package bex.myarrivalsservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Advantage {
    private int id;

    private String title;
    private String body;

    public Advantage() {}

    public Advantage(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
