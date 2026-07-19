package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pymrma.boot.entity.LoginUser;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.converter.UserConverter;
import top.pymrma.boot.dto.LoginDTO;
import top.pymrma.boot.services.UserService;
import top.pymrma.boot.utils.JWTUtil;
import top.pymrma.boot.vo.LoginVO;
import top.pymrma.boot.vo.UserVO;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping
    public ResultMap login(@RequestBody LoginDTO dto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                dto.getEmail(),
                dto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        //生成token
        String jwt = jwtUtil.generateToken(dto.getEmail());

        UserVO userVO = userConverter.toVO(loginUser.getUser());
        LoginVO loginVO = new LoginVO(jwt, userVO);

        return new ResultMap<>(ResultEnum.SUCCESS, loginVO);
    }
}
