package org.tinker.cms.repository.tk.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.tinker.cms.repository.tk.model.Watch;
import org.tinker.cms.repository.tk.model.WatchExample;
import tk.mybatis.mapper.common.Mapper;

public interface WatchMapper extends Mapper<Watch> {
    int deleteByExample(WatchExample example);

    List<Watch> selectByExample(WatchExample example);

    int updateByExampleSelective(@Param("record") Watch record, @Param("example") WatchExample example);

    int updateByExample(@Param("record") Watch record, @Param("example") WatchExample example);
}