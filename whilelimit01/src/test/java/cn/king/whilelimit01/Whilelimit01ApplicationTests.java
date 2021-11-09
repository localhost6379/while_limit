package cn.king.whilelimit01;

import cn.king.whilelimit01.component.UserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class Whilelimit01ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test01() throws Exception {
        userService.poll(UserService.PAGE_SIZE_10,
                UserService.SLEEP_TIME_1,
                userList -> userList.forEach(user -> log.info(JSON.toJSONString(user))));
    }



}
