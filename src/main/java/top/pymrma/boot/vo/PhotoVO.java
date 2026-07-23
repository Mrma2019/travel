package top.pymrma.boot.vo;

import java.util.List;

public record PhotoVO(
        String title,
        String description,
        String url,
        String thumbnailUrl,
        String location,
        String takenAt,
        Long travelId,
        List<String> tags,
        Long size,
        Integer width,
        Integer height,
        String createdAt,
        String story,
        String storyTitle,
        String storyUpdatedAt
) {
}
