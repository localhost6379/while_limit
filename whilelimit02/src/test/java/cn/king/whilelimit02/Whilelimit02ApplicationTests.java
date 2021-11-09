package cn.king.whilelimit02;

import cn.king.whilelimit02.component.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Whilelimit02ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test01() throws Exception {
        userService.poll(3, 1000L, userList -> userList.forEach(System.err::println));
    }

}
