package top.pymrma.boot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "photos")
@JsonIgnoreProperties(ignoreUnknown = true)
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

    private Long travelId;

    @ElementCollection(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<String> tags;

    private Long size;
    private Integer width;
    private Integer height;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String story;
    private String storyTitle;
    @UpdateTimestamp
    private LocalDateTime storyUpdatedAt;
}
