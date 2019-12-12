package bex.myarrivalsservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullPage {
    private int id;

    private String name;
    private String title;
    private String description;
    private String h1;
    private String url;
    private String mainText;

    private AllHeaders header;
    private boolean footer;
    private boolean extraContent;
    private AllAdvantages advantages;

    public FullPage() {
    }

    public FullPage(int id, String name, String title, String description, String h1, String url, String mainText, AllHeaders header, boolean footer, boolean extraContent, AllAdvantages advantages) {
        this.id = id;
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

    public FullPage(Page page, AllHeaders headers, AllAdvantages advantages){
        this.id = page.getId();
        this.name = page.getName();
        this.title = page.getTitle();
        this.description = page.getDescription();
        this.h1 = page.getH1();
        this.url = page.getUrl();
        this.mainText = page.getMainText();
        this.header = headers;
        this.footer = false;
        this.extraContent = false;
        this.advantages = advantages;
    }
}
