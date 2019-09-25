package com.xzy.basis.modules.base.service;

import com.xzy.basis.modules.base.query.PageQuery;

import java.util.List;

/**
 * 通用接口
 *
 * @author xzy
 * @date 2019/9/2 16:21
 */
public interface IService<T> {
    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    List<T> queryAll();

    /**
     * 条件查询
     *
     * @param entity 条件
     * @return 结果
     */
    List<T> queryList(T entity);

    /**
     * 根据条件查询一条数据
     *
     * @param entity 条件
     * @return 结果
     */
    T queryOne(T entity);

    /**
     * 根据id查询一条数据
     *
     * @param id id
     * @return 结果
     */
    T queryById(Object id);

    /**
     * 根据条件分页查询
     *
     * @param entity    条件
     * @param pageQuery 分页条件
     * @return 结果
     */
    List<T> queryList(T entity, PageQuery pageQuery);

    /**
     * 新增数据
     *
     * @param entity 传入值
     * @return 数据库改变的行数
     */
    int create(T entity);

    /**
     * 更新
     *
     * @param entity 传入的数据
     * @return 数据库改变的行数
     */
    int updateAll(T entity);

    /**
     * 更新
     *
     * @param entity 传入的数据
     * @return 数据库改变的行数
     */
    int updateNotNull(T entity);

    /**
     * 根据条件删除数据
     * @param entity 条件
     * @return 数据库改变的行数
     */
    int delete(T entity);

    /**
     * 根据id删除数据
     * @param id id
     * @return 数据库改变的行数
     */
    int deleteById(Object id);

    /**
     * 求和
     * @param entity 求和条件
     * @return 结果
     */
    int count(T entity);

}
