//package model.joinentity;
//
//import jakarta.persistence.*;
//import model.Actor;
//import model.Series;
//
//@Entity
//@Table(name = "actor_series") // Nombre de la tabla de uniónic class ActorSeries {
//
//public class ActorSeries {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "series_id")
//    private Series series;
//
//    @ManyToOne
//    @JoinColumn(name = "actor_id")
//    private Actor actor;
//
//    public ActorSeries() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Series getSeries() {
//        return series;
//    }
//
//    public void setSeries(Series series) {
//        this.series = series;
//    }
//
//    public Actor getActor() {
//        return actor;
//    }
//
//    public void setActor(Actor actor) {
//        this.actor = actor;
//    }
//}
