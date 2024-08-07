package com.wl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mpi = new MybatisPlusInterceptor();
        //添加分页拦截器
        mpi.addInnerInterceptor(new PaginationInnerInterceptor());
        //添加乐观锁拦截器
        mpi.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        // 防止全表更新与删除 ,主要影响的是 update 和 delete 语句.不论是xml方式还是编码方式都会拦截
        mpi.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return mpi;
    }

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() {
        // 暂不开启SQL监控
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setFilters("stat");
//        return druidDataSource;
        return new DruidDataSource();
    }
}