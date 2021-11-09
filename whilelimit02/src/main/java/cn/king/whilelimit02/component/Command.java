package cn.king.whilelimit02.component;


import cn.king.whilelimit02.pojo.User;

import java.util.List;

/**
 * @author: wjl@king.cn
 * @time: 2021/2/9 19:07
 * @version: 1.0.0
 * @description:
 */
public interface Command {

    void execute(List<User> userList) throws Exception;

}
