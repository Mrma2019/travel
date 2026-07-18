package top.pymrma.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.pymrma.boot.utils.JWTUtil;

@SpringBootTest
class TravelApplicationTests {

    @Autowired
    public JWTUtil jwtUtil;

    @Test
    void contextLoads() {
        String s = jwtUtil.generateToken("pymrma@163.com");
        System.out.println(s);
    }

}
