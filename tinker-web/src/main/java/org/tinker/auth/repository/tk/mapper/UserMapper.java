package org.tinker.auth.repository.tk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tinker.auth.repository.tk.model.User;
import org.tinker.auth.repository.tk.model.UserExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    int deleteByExample(UserExample example);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}