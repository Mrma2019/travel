package top.pymrma.boot.vo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TravelVO {
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
    private List<String> tags;
    private Integer rating = 0;
    private String coverUrl;
    private LocalDateTime createdAt;
}
