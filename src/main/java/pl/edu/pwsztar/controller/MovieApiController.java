package pl.edu.pwsztar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.dto.TrailerDto;
import pl.edu.pwsztar.service.MovieService;

import java.util.List;

@Controller
@RequestMapping(value="/api")
public class MovieApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieApiController.class);

    private final MovieService movieService;

    @Autowired
    public MovieApiController(MovieService movieService) {
        this.movieService = movieService;
    }

    @CrossOrigin
    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<MovieDto>> getMovies() {
        LOGGER.info("find all movies");

        List<MovieDto> moviesDto = movieService.findAll();
        return new ResponseEntity<>(moviesDto, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createMovie(@RequestBody CreateMovieDto createMovieDto) {
        LOGGER.info("create movie: {}", createMovieDto);
        movieService.createMovie(createMovieDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(value = "/movies/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
        LOGGER.info("delete movie: {}", movieId);
        movieService.deleteMovie(movieId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/movies/{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TrailerDto> getMovieTrailer(@PathVariable Long movieId) {
        LOGGER.info("delete movie: {}", movieId);
        TrailerDto trailerDto = movieService.getMovieTrailer(movieId);
        return new ResponseEntity<>(trailerDto,HttpStatus.OK);
    }

}
