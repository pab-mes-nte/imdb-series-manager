package model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "series_log")
public class SeriesLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "log_description")
    private String description;

    public SeriesLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
