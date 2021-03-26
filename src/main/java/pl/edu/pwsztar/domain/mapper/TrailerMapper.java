package pl.edu.pwsztar.domain.mapper;

import org.springframework.stereotype.Component;
import pl.edu.pwsztar.domain.dto.TrailerDto;
import pl.edu.pwsztar.domain.entity.Movie;

@Component
public class TrailerMapper {

    public TrailerDto mapToTrailerDto(Movie movie){
        return new TrailerDto(movie.getTitle(), movie.getVideoId());
    }
}
