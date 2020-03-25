package com.badgehu.jarvis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CodeGeneratorConfig {

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
    @ConfigurationProperties(prefix = "jarvis.global")
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setServiceName("%sService");
        return globalConfig;
    }


    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "jarvis.datasource")
    public DataSourceConfig dataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        return dataSourceConfig;
    }

    @Bean(name = "packageConfig")
    @ConfigurationProperties(prefix = "jarvis.package")
    public PackageConfig packageConfig() {
        return new PackageConfig();
    }

    @Bean(name = "strategyConfig")
    @ConfigurationProperties(prefix = "jarvis.strategy")
    public StrategyConfig strategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        return strategyConfig;
    }

    @Bean(name = "templateConfig")
    @ConfigurationProperties(prefix = "jarvis.template")
    public TemplateConfig templateConfig() {
        return new TemplateConfig();
    }
}
