package top.pymrma.boot.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import top.pymrma.boot.converter.utils.FileUrlResolver;
import top.pymrma.boot.entity.Photo;
import top.pymrma.boot.vo.PhotoVO;

@Mapper(componentModel = "spring", uses = FileUrlResolver.class)
public interface PhotoConverter {

    @Mapping(target = "url", qualifiedByName = "toUrl")
    @Mapping(target = "takenAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "createdAt", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "storyUpdatedAt", dateFormat = "yyyy-MM-dd")
    PhotoVO toVO(Photo photo);


}
