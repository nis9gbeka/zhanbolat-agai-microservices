package bex.packsservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "advantages")
@Setter
@Getter
public class Advantage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String body;

    public Advantage() {}

    public Advantage(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
