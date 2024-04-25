package model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rating")
public class Ratings implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "value_rating")
    private int valueRating;
    @ManyToOne()
    @JoinColumn(name = "series_id")
    private Series seriesList;

    public Ratings() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValueRating() {
        return valueRating;
    }

    public void setValueRating(int valueRating) {
        this.valueRating = valueRating;
    }

    public Series getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(Series seriesList) {
        this.seriesList = seriesList;
    }
}
