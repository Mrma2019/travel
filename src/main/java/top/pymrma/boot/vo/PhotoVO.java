package top.pymrma.boot.vo;

import lombok.Data;

import java.util.List;

@Data
public class PhotoVO {
    private String title;
    private String description;
    private String url;
    private String thumbnailUrl;
    private String location;
    private String takenAt;
    private String travelId;
    private List<String> tags;
    private Long size;
    private Integer width;
    private Integer height;
    private String createdAt;
    private String story;
    private String storyTitle;
    private String storyUpdatedAt;
}
