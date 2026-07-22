package top.pymrma.boot.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import top.pymrma.boot.entity.Travel;
import top.pymrma.boot.converter.utils.FileUrlResolver;
import top.pymrma.boot.vo.TravelVO;

@Mapper(componentModel = "spring", uses = FileUrlResolver.class)
public interface TravelConverter {

    @Mapping(target = "coverUrl", qualifiedByName = "toUrl")
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm:ss")
    TravelVO toVO(Travel travel);
}
