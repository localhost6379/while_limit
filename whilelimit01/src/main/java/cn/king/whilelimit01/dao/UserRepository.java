package cn.king.whilelimit01.dao;


import cn.king.whilelimit01.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: wjl@king.cn
 * @time: 2021/2/9 9:49
 * @version: 1.0.0
 * @description:
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

}
