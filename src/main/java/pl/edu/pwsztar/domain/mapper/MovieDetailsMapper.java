package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.DetailsMovieDto;
import pl.edu.pwsztar.domain.entity.Movie;

@Component
public class MovieDetailsMapper implements Converter<DetailsMovieDto, Movie> {

        @Override
        public DetailsMovieDto convert(Movie movie) {
                DetailsMovieDto detailsMovieDto = new DetailsMovieDto();
                detailsMovieDto.setTitle(movie.getTitle());
                detailsMovieDto.setVideoId(movie.getVideoId());
                detailsMovieDto.setImage(movie.getImage());
                detailsMovieDto.setYear(movie.getYear());
                return detailsMovieDto;
        }


/*
public DetailsMovieDto mapToDto(Movie movie) {
        DetailsMovieDto detailsMovieDto = new DetailsMovieDto();

        detailsMovieDto.setTitle(movie.getTitle());
        detailsMovieDto.setVideoId(movie.getVideoId());
        detailsMovieDto.setImage(movie.getImage());
        detailsMovieDto.setYear(movie.getYear());

        return detailsMovieDto;
    }
*/
}
