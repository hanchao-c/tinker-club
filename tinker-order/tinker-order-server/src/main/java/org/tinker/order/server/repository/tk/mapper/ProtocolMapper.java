package org.tinker.order.server.repository.tk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tinker.order.server.repository.tk.model.Protocol;
import org.tinker.order.server.repository.tk.model.ProtocolExample;
import tk.mybatis.mapper.common.Mapper;

public interface ProtocolMapper extends Mapper<Protocol> {
    int deleteByExample(ProtocolExample example);

    List<Protocol> selectByExample(ProtocolExample example);

    int updateByExampleSelective(@Param("record") Protocol record, @Param("example") ProtocolExample example);

    int updateByExample(@Param("record") Protocol record, @Param("example") ProtocolExample example);
}