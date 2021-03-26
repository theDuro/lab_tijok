package pl.edu.pwsztar.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.dto.CreateMovieDto;
import pl.edu.pwsztar.domain.dto.MovieDto;
import pl.edu.pwsztar.domain.dto.TrailerDto;
import pl.edu.pwsztar.domain.entity.Movie;
import pl.edu.pwsztar.domain.mapper.MovieListMapper;
import pl.edu.pwsztar.domain.mapper.MovieMapper;
import pl.edu.pwsztar.domain.mapper.TrailerMapper;
import pl.edu.pwsztar.domain.repository.MovieRepository;
import pl.edu.pwsztar.service.MovieService;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;
    private final MovieListMapper movieListMapper;
    private final MovieMapper movieMapper;
    private final TrailerMapper trailerMapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository,
                            MovieListMapper movieListMapper,
                            MovieMapper movieMapper, TrailerMapper trailerMapper) {

        this.movieRepository = movieRepository;
        this.movieListMapper = movieListMapper;
        this.movieMapper = movieMapper;
        this.trailerMapper = trailerMapper;
    }

    @Override
    public List<MovieDto> findAll() {
        List<Movie> movies = movieRepository.sortedMovies();
        return movieListMapper.mapToDto(movies);
    }

    @Override
    public void createMovie(CreateMovieDto createMovieDto) {
        Movie movie = movieMapper.mapToEntity(createMovieDto);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public TrailerDto getMovieTrailer(Long movieId) {
        Movie movie = movieRepository.getMovieTrailer(movieId);
        return trailerMapper.mapToTrailerDto(movie);
    }

}
