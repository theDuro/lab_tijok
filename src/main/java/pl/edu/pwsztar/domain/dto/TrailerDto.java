package pl.edu.pwsztar.domain.dto;

public class TrailerDto {
    private String title;
    private String videoId;

    public TrailerDto() {
    }

    public TrailerDto(String title, String videoId) {
        this.title = title;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public String getVideoId() {
        return videoId;
    }
}
