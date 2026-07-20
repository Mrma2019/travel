package top.pymrma.boot.dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class PageQueryDTO {
    private Integer page = 1;
    private Integer size = 10;
    private String sortField = "id";
    private String sortOrder = "asc";

    public Pageable toPageable() {
        int pageNum = Math.max(0, (page == null ? 1 : page) - 1);
        int pageSize = Math.min(100, Math.max(1, size == null ? 10 : size));

        Sort sort = Sort.by(
                Sort.Direction.fromString(sortOrder),
                sortField
        );

        return PageRequest.of(pageNum, pageSize, sort);
    }
}