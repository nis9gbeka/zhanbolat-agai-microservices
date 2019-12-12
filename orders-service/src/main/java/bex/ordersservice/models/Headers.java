package bex.ordersservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Headers {
    private String name;
    private String url;

    public Headers(){}

    public Headers(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
