package org.tinker.payment.server.repository.tk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tinker.payment.server.repository.tk.model.PayRecord;
import org.tinker.payment.server.repository.tk.model.PayRecordExample;
import tk.mybatis.mapper.common.Mapper;

public interface PayRecordMapper extends Mapper<PayRecord> {
    int deleteByExample(PayRecordExample example);

    List<PayRecord> selectByExample(PayRecordExample example);

    int updateByExampleSelective(@Param("record") PayRecord record, @Param("example") PayRecordExample example);

    int updateByExample(@Param("record") PayRecord record, @Param("example") PayRecordExample example);
}