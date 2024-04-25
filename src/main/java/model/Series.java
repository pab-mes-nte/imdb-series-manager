package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "series")
public class Series implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "rated")
    private String rated;
    @Column(name = "poster")
    private String poster;
    @Column(name = "plot")
    private String plot;
    @Column(name = "metascore")
    private int metascore;
    @Column(name = "imbd_rating")
    private int imbdRating;
    @Column(name = "imdb_votes")
    private int imdbVotes;
    @Column(name = "awards")
    private String awards;
    @Column(name = "total_seasons")
    private int totalSeasons;
    @Column(name = "released")
    private LocalDate released;
    @ManyToMany(mappedBy = "seriesList", fetch = FetchType.EAGER)
    private List<Actor> actors;
    @ManyToMany(mappedBy = "seriesList", fetch = FetchType.EAGER)
    private List<Country> countries;
    @ManyToMany(mappedBy = "seriesList", fetch = FetchType.EAGER)
    private List<Category> categories;
    @ManyToMany(mappedBy = "seriesList", fetch = FetchType.EAGER)
    private List<Director> directors;
    @OneToMany(mappedBy = "seriesList", fetch = FetchType.EAGER)
    private List<Language> languages;
    @ManyToMany(mappedBy = "seriesList", fetch = FetchType.EAGER)
    private List<Writer> writers;
    @OneToMany(mappedBy = "seriesList", fetch = FetchType.EAGER)
    private List<Ratings> ratings;

    public Series() {
    }

    @Override
    public String toString() {
        return "Series{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rated='" + rated + '\'' +
                ", poster='" + poster + '\'' +
                ", plot='" + plot + '\'' +
                ", metascore=" + metascore +
                ", imbdRating=" + imbdRating +
                ", imdbVotes=" + imdbVotes +
                ", awards='" + awards + '\'' +
                ", totalSeasons=" + totalSeasons +
                ", released=" + released +
                ", actors=" + actors +
                ", countries=" + countries +
                ", categories=" + categories +
                ", directors=" + directors +
                ", languages=" + languages +
                ", writers=" + writers +
                ", ratings=" + ratings +
                '}';
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

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getMetascore() {
        return metascore;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public int getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(int imbdRating) {
        this.imbdRating = imbdRating;
    }

    public int getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public LocalDate getReleased() {
        return released;
    }

    public void setReleased(LocalDate released) {
        this.released = released;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }
}
