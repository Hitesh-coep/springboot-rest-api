package net.imbd.app.springboot.bean;

public class Movie {
    private int movieRanking;
    private String title;
    private String genre;

    public Movie(int movieRanking, String title, String genre) {
        this.movieRanking = movieRanking;
        this.title = title;
        this.genre = genre;
    }

    public void setMovieRanking(int movieRanking) {
        this.movieRanking = movieRanking;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMovieRanking() {
        return movieRanking;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}
