package com.badgehu.jarvis.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @auther: badgehu
 * @date: 2019/9/18 17:47
 * @description:
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(T entity) {
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(T entity, Wrapper<T> updateWrapper) {
        return super.update(entity, updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(T entity) {
        return super.updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}
