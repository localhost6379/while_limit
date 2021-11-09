package cn.king.whilelimit02.component;

import cn.king.whilelimit02.dao.UserRepository;
import cn.king.whilelimit02.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: wjl@king.cn
 * @time: 2021/02/15 17:40
 * @version: 1.0.0
 * @description:
 * @why:
 */
@Service
public class UserService {

    public static final Integer PAGE_SIZE_10 = 10;
    public static final Integer PAGE_SIZE_20 = 20;
    public static final Long SLEEP_TIME_1 = 1000L;
    public static final Long SLEEP_TIME_2 = 2000L;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void poll(Integer pageSize, Long sleepTime, Command command) throws Exception {
        List<User> userList = userRepository.findByStatus((byte) 1, pageSize);
        while (!CollectionUtils.isEmpty(userList)) {
            command.execute(userList);
            userList.forEach(user -> {
                user.setStatus((byte) -1);
                userRepository.save(user);
            });
            userList = userRepository.findByStatus((byte) 1, pageSize);
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        }
    }

}
