package pl.edu.pwsztar.domain.dto;

import java.io.Serializable;

public class UpdateMovieDto implements Serializable {
    private String title;
    private String image;
    private Integer year;
    private String videoId;
    private UpdateMovieDto(UpdateMovieDto.Builder builder){
        title = builder.title;
        image = builder.image;
        year = builder.year;
        videoId = builder.videoId;

    }
    public static final class Builder {
        private String title;
        private String image;
        private Integer year;
        private String videoId;
        public UpdateMovieDto.Builder title(String title) {
            this.title = title;
            return this;
        }

        public UpdateMovieDto.Builder movieId(String videoId) {
            this.videoId = videoId;
            return this;
        }
        public UpdateMovieDto.Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public UpdateMovieDto.Builder image(String image) {
            this.image = image;
            return this;
        }


        public Builder() {
        }

        public UpdateMovieDto build() {
            return new UpdateMovieDto(this);
        }
    }


    public UpdateMovieDto() {
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getYear() {
        return year;
    }

    public String getVideoId() {
        return videoId;
    }

    @Override
    public String toString() {
        return "CreateMovieDto{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", year=" + year +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
