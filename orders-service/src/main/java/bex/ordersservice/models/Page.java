package bex.ordersservice.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="pages")
@Getter
@Setter
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
