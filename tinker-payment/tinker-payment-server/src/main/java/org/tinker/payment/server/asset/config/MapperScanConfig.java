package org.tinker.payment.server.asset.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@tk.mybatis.spring.annotation.MapperScan("org.tinker.payment.server.repository.tk.mapper")
@org.mybatis.spring.annotation.MapperScan("org.tinker.payment.server.repository.custom.mapper")
public class MapperScanConfig {

}
