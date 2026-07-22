package top.pymrma.boot.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "time_line")
public class TimeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Type type;

    private String date;

    private String title;

    private String description;

    private String icon;

    private String travelId;

    private String photoId;

    @Embedded
    private Location location;

    public enum Type {
        FLIGHT("flight"),
        ARRIVAL("arrival"),
        PHOTO("photo"),
        STORY("story"),
        ACHIEVEMENT("achievement");

        private final String value;

        Type(String value) {
            this.value = value;
        }
    }

    @Embeddable
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Location {
        private Double lat;
        private Double lng;
        private String name;
    }
}
