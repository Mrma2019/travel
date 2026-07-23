package top.pymrma.boot.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public record PageQueryDTO(
        Integer page,
        Integer size,
        String sortField,
        String sortOrder
) {

    public Pageable toPageable() {
        int pageNum = Math.max(0, (page == null ? 1 : page) - 1);
        int pageSize = Math.min(100, Math.max(1, size == null ? 10 : size));

        String field = (sortField == null || sortField.isBlank())
                ? "id"
                : sortField;

        String order = (sortOrder == null || sortOrder.isBlank())
                ? "asc"
                : sortOrder;

        Sort sort = Sort.by(
                Sort.Direction.fromString(order),
                field
        );

        return PageRequest.of(pageNum, pageSize, sort);
    }
}