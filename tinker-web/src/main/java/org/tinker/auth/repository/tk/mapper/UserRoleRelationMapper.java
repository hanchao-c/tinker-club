package org.tinker.auth.repository.tk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tinker.auth.repository.tk.model.UserRoleRelation;
import org.tinker.auth.repository.tk.model.UserRoleRelationExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserRoleRelationMapper extends Mapper<UserRoleRelation> {
    int deleteByExample(UserRoleRelationExample example);

    List<UserRoleRelation> selectByExample(UserRoleRelationExample example);

    int updateByExampleSelective(@Param("record") UserRoleRelation record, @Param("example") UserRoleRelationExample example);

    int updateByExample(@Param("record") UserRoleRelation record, @Param("example") UserRoleRelationExample example);
}