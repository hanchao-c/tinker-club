package org.tinker.auth.repository.tk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tinker.auth.repository.tk.model.RolePermissionRelation;
import org.tinker.auth.repository.tk.model.RolePermissionRelationExample;
import tk.mybatis.mapper.common.Mapper;

public interface RolePermissionRelationMapper extends Mapper<RolePermissionRelation> {
    int deleteByExample(RolePermissionRelationExample example);

    List<RolePermissionRelation> selectByExample(RolePermissionRelationExample example);

    int updateByExampleSelective(@Param("record") RolePermissionRelation record, @Param("example") RolePermissionRelationExample example);

    int updateByExample(@Param("record") RolePermissionRelation record, @Param("example") RolePermissionRelationExample example);
}