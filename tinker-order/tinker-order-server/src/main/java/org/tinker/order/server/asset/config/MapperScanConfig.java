package org.tinker.order.server.asset.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@tk.mybatis.spring.annotation.MapperScan("org.tinker.order.server.repository.tk.mapper")
@org.mybatis.spring.annotation.MapperScan("org.tinker.order.server.repository.custom.mapper")
public class MapperScanConfig {

}
