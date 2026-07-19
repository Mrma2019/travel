package top.pymrma.boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private String location;
    private LocalDateTime takenAt;
    private String travelId;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> tags;
    private Long size;
    private Integer width;
    private Integer height;
    private LocalDateTime createdAt;
    private String story;
    private String storyTitle;
    private LocalDateTime storyUpdatedAt;
}
