package org.tinker.order.server.repository.tk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tinker.order.server.repository.tk.model.UncompletedOrder;
import org.tinker.order.server.repository.tk.model.UncompletedOrderExample;

import tk.mybatis.mapper.common.Mapper;

public interface UncompletedOrderMapper extends Mapper<UncompletedOrder> {
    int deleteByExample(UncompletedOrderExample example);

    List<UncompletedOrder> selectByExample(UncompletedOrderExample example);

    int updateByExampleSelective(@Param("record") UncompletedOrder record, @Param("example") UncompletedOrderExample example);

    int updateByExample(@Param("record") UncompletedOrder record, @Param("example") UncompletedOrderExample example);
}