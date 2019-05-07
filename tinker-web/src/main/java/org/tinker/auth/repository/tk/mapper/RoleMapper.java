package org.tinker.auth.repository.tk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tinker.auth.repository.tk.model.Role;
import org.tinker.auth.repository.tk.model.RoleExample;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {
    int deleteByExample(RoleExample example);

    List<Role> selectByExample(RoleExample example);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);
}