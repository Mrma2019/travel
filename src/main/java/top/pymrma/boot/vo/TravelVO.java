package top.pymrma.boot.vo;

import java.time.LocalDate;
import java.util.List;

public record TravelVO(
        Long id,
        String country,
        String countryCode,
        String city,
        Double lat,
        Double lng,
        LocalDate startDate,
        LocalDate endDate,
        String title,
        String story,
        List<String> tags,
        Integer rating,
        String coverUrl,
        String createdAt
) {

    public TravelVO {
        rating = rating == null ? 0 : rating;
    }
}
