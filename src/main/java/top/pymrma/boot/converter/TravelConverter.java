package top.pymrma.boot.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import top.pymrma.boot.entity.Travel;
import top.pymrma.boot.vo.TravelVO;

@Mapper(componentModel = "spring")
public interface TravelConverter {

    @Mapping(target = "coverUrl", qualifiedByName = "convertToWebPath")
    TravelVO toVO(Travel travel);

    @Named("convertToWebPath")
    default String convertToWebPath(String coverUrl) {
        return "http://localhost:8080/file/" + coverUrl.replace("\\", "/");
    }
}
