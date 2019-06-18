package org.tinker.payment.server.repository.tk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tinker.payment.server.repository.tk.model.PayType;
import org.tinker.payment.server.repository.tk.model.PayTypeExample;
import tk.mybatis.mapper.common.Mapper;

public interface PayTypeMapper extends Mapper<PayType> {
    int deleteByExample(PayTypeExample example);

    List<PayType> selectByExample(PayTypeExample example);

    int updateByExampleSelective(@Param("record") PayType record, @Param("example") PayTypeExample example);

    int updateByExample(@Param("record") PayType record, @Param("example") PayTypeExample example);
}