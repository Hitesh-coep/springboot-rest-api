package net.imbd.app.springboot.controller;

import com.sun.net.httpserver.Headers;
import net.imbd.app.springboot.bean.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    //From here Java Bean as JSON is returned.
    //https://localhost:8080/movie
    @GetMapping("/movie")
    public Movie getMovie(){
        return new Movie(1,"The Shawshank Redemption", "Thriller & Mystery");
    }

    //ResponseEntity is used to manipulate or return the complete HTTP response including HTTP Status Code, Header, Body
    //Similarly we can use ResponseEntity as return type in other methods as well.
    @GetMapping("movieres")
    public ResponseEntity<Movie> getMovieUsingResponseEntity(){
        Movie movie = new Movie(1,"The Shawshank Redemption", "Thriller & Mystery");
        //return new ResponseEntity<>(movie,HttpStatus.OK);
        //return ResponseEntity.ok(movie);
        //Using another overloaded ok method to return header and body.
        return ResponseEntity.ok().header("custom-header","moviename").body(movie);
    }

    //From here Array List as JSON is returned.
    //https://localhost:8080/movies
    @GetMapping("/movies")
    public List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1,"The Shawshank Redemption", "Thriller & Mystery"));
        movies.add(new Movie(2,"The Godfather", "Crime & Drama"));
        movies.add(new Movie(3,"The Dark Knight", "Action & Crime & Drama"));
        movies.add(new Movie(4,"The Godfather: Part 2", "Crime & Drama"));
        return movies;
    }

    //From here whatever values we get in path variable and then JSON is returned.
    //https://localhost:8080/movies/1/Harry/Adventure
    @GetMapping("movies/{ranking}/{name}/{genre}")
    public Movie moviePathVariable(@PathVariable ("ranking") int movieRank, @PathVariable("name") String movieName, @PathVariable("genre") String genre){
        return new Movie(movieRank,movieName, genre);
    }

    //From here requested parameters as JSON are returned.
    //https://localhost:8080/movies
    @GetMapping("movies/query")
    public Movie movieRequestParameters(@RequestParam int movieRank, @RequestParam String movieName, @RequestParam String genre){
        return new Movie(movieRank,movieName,genre);
    }

    //This REST API handles the incoming POST requests.
    //https://localhost:8080/movies/create
    @PostMapping("movies/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie){
        System.out.println(movie.getMovieRanking());
        System.out.println(movie.getTitle());
        System.out.println(movie.getGenre());
        return movie;
    }

    // This REST API handles the PUT requests
    @PutMapping("movies/{rank}/update")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable("rank") int movieRank){
        System.out.println(movie.getTitle());
        System.out.println(movie.getGenre());
        return movie;
    }

    // This REST API handles the DELETE request
    @DeleteMapping("movies/{rank}/delete")
    public String deleteMovie(@PathVariable("rank") int movieRank){
        System.out.println(movieRank);
        return "Movie Deleted Successfully!!!";
    }
}
