package top.pymrma.boot.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import top.pymrma.boot.entity.User;
import top.pymrma.boot.vo.UserVO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mapping(target = "status", qualifiedByName = "statusConverter")
    UserVO toVO(User user);

    List<UserVO> toVOList(List<User> users);

    default String map(LocalDateTime localDateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(dtf);
    }

    @Named("statusConverter")
    default String statusConverter(Integer status) {
        return status == 0 ? "active" : "disabled";
    }

}
