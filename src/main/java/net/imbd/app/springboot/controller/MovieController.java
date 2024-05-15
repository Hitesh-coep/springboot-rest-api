package net.imbd.app.springboot.controller;

import net.imbd.app.springboot.bean.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @GetMapping("/movie")
    public Movie getMovie(){
        Movie movie = new Movie(1,"The Shawshank Redemption", "Thriller & Mystery");
        return movie;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"The Shawshank Redemption", "Thriller & Mystery"));
        movies.add(new Movie(2,"The Godfather", "Crime & Drama"));
        movies.add(new Movie(3,"The Dark Knight", "Action & Crime & Drama"));
        movies.add(new Movie(4,"The Godfather: Part 2", "Crime & Drama"));
        return movies;
    }
    @GetMapping("movies/{ranking}/{name}/{genre}")
    public Movie moviePathVariable(@PathVariable ("ranking") int movieRank, @PathVariable("name") String movieName, @PathVariable("genre") String genre){
        return new Movie(movieRank,movieName, genre);
    }
}
