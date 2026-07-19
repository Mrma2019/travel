package top.pymrma.boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> tags;
    private Integer rating = 0;
    private String coverUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
