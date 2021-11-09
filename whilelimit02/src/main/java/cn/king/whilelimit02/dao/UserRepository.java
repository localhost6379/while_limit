package cn.king.whilelimit02.dao;

import cn.king.whilelimit02.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author: wjl@king.cn
 * @time: 2021/2/9 9:49
 * @version: 1.0.0
 * @description:
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    /*查询pageSize个status=1的User*/
    @Query(value = "select * from tb_user where status = :status limit :pageSize", nativeQuery = true)
    List<User> findByStatus(Byte status, Integer pageSize);

}
