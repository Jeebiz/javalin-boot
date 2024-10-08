/**
 * Copyright (C) 2018 Hiwepy (http://hiwepy.io).
 * All Rights Reserved.
 */
package io.javalin.boot.api.dao;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.javalin.boot.api.dao.entities.PaginationEntity;
import io.javalin.boot.api.dao.entities.PairModel;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 通用Dao接口
 *
 * @param <T> 持有的实体对象
 * @author <a href="https://github.com/wandl">wandl</a>
 */
public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
    /**
     * 更新数据状态
     *
     * @param id
     * @param status
     * @return
     */
    int setStatus(@Param("id") Serializable id, @Param("status") Serializable status);

    /**
     * 分页查询
     *
     * @param model
     * @return
     */
    List<T> getPagedList(Page<T> page, @Param("model") PaginationEntity<T> model);

    /**
     * 无分页查询
     *
     * @param t
     * @return
     */
    List<T> getEntityList(T t);

    /**
     * 统计记录数
     *
     * @param t
     * @return
     */
    Long getCount(T t);

    /**
     * 根据唯一ID编码获取记录数
     *
     * @param uid
     * @return
     */
    Long getCountByUid(@Param("uid") Serializable uid);

    /**
     * 根据编码获取记录数
     *
     * @param code
     * @param origin
     * @return
     */
    Long getCountByCode(@Param("code") String code, @Param("origin") Object origin);

    /**
     * 根据名称获取记录数
     *
     * @param name
     * @param origin
     * @return
     */
    Long getCountByName(@Param("name") String name, @Param("origin") Object origin);

    Long getCountByParent(@Param("parent") Object parent);

    /**
     * 通过指定key查询对应的唯一值
     *
     * @param key
     * @return
     */
    String getValue(@Param("key") String key);

    /**
     * 通过指定key查询多个值
     *
     * @param key
     * @return
     */
    Map<String, String> getValues(@Param("key") String key);

    /**
     * 根据key查询该分组下的基础数据
     *
     * @param key
     * @return
     */
    List<PairModel> getPairValues(@Param("key") String key);

    /**
     * 查询一组键值对数据
     *
     * @param key
     * @return
     */
    List<PairModel> getPairList();

}
