package pestrak.mary.telegram.entity;

import javax.persistence.*;

@Entity
@Table
public class City {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique=true)
    private String city;

    private String text;

    public City() {}

    public City(String city, String text) {
        this.city = city;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
