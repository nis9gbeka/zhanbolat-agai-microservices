package bex.myarrivalsservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
    private int id;

    private String name;
    private String title;
    private String description;
    private String h1;
    private String url;
    private String mainText;

    private boolean header;
    private boolean footer;
    private boolean extraContent;
    private boolean advantages;

    public Page(){}

    public Page(String name, String title, String description, String h1, String url, String mainText, boolean header, boolean footer, boolean extraContent, boolean advantages) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.h1 = h1;
        this.url = url;
        this.mainText = mainText;
        this.header = header;
        this.footer = footer;
        this.extraContent = extraContent;
        this.advantages = advantages;
    }

}
