package top.pymrma.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pymrma.boot.common.LoginUser;
import top.pymrma.boot.common.ResultEnum;
import top.pymrma.boot.common.ResultMap;
import top.pymrma.boot.dto.LoginDTO;
import top.pymrma.boot.entity.User;
import top.pymrma.boot.services.UserService;
import top.pymrma.boot.utils.JWTUtil;
import top.pymrma.boot.vo.LoginVO;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final UserService userService;

    @PostMapping
    public ResultMap login(@RequestBody LoginDTO dto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                dto.getEmail(),
                dto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        String jwt = jwtUtil.generateToken(dto.getEmail());

        User user = new User();
        user.setEmail(loginUser.getUsername());
        user.setPassword(loginUser.getPassword());

        LoginVO loginVO = new LoginVO(jwt, user);

        return new ResultMap<>(ResultEnum.SUCCESS, loginVO);
    }
}
