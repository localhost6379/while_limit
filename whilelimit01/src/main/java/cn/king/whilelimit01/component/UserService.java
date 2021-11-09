package cn.king.whilelimit01.component;


import cn.king.whilelimit01.dao.UserRepository;
import cn.king.whilelimit01.pojo.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: wjl@king.cn
 * @time: 2021/2/9 19:07
 * @version: 1.0.0
 * @description:
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

    /**
     * @author: wjl@king.cn
     * @time: 2021/2/10 9:44
     * @param: pageSize 每页多少条
     * @param: sleepTime 每隔多长时间查询一次数据库。设置<=0的数代表没有休眠。
     * @param: command
     * @return: void
     * @description: TODO 注意，偏移量要持久化到数据库并加载到缓存
     * @why:
     */
    public void poll(Integer pageSize, Long sleepTime, Command command) throws Exception {
        int pageNumber = 0;
        List<User> userList = userRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
        while (!CollectionUtils.isEmpty(userList)) {
            command.execute(userList);
            pageNumber++;
            userList = userRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        }
    }

}
