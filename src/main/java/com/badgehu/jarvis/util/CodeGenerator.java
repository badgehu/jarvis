package com.badgehu.jarvis.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: qiyu
 * @date: 2020/1/3 11:49
 * @description:
 */
@Configuration
public class CodeGenerator {

    @Bean(name = "generator")
    public AutoGenerator autoGenerator() {
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig());
        autoGenerator.setDataSource(dataSourceConfig());
        autoGenerator.setPackageInfo(packageConfig());
        autoGenerator.setStrategy(strategyConfig());
        autoGenerator.setTemplate(templateConfig());
        return autoGenerator;
    }

    @Bean(name = "globalConfig")
    @ConfigurationProperties(prefix = "stark.global")
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setServiceName("%sService");
        return globalConfig;
    }


    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "stark.datasource")
    public DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        return dataSourceConfig;
    }

    @Bean(name = "packageConfig")
    @ConfigurationProperties(prefix = "stark.package")
    public PackageConfig packageConfig() {
        return new PackageConfig();
    }

    @Bean(name = "strategyConfig")
    @ConfigurationProperties(prefix = "stark.strategy")
    public StrategyConfig strategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        return strategyConfig;
    }

    @Bean(name = "templateConfig")
    @ConfigurationProperties(prefix = "stark.template")
    public TemplateConfig templateConfig() {
        return new TemplateConfig();
    }
}
