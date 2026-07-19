package top.pymrma.boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String countryCode;
    private String city;
    private Double lat;
    private Double lng;
    private LocalDate startDate;
    private LocalDate endDate;
    private String title;
    private String story;
    private List<String> photos;
    private List<String> tags;
    private Integer rating;
    private String coverUrl;
    private LocalDateTime createdAt;
}
