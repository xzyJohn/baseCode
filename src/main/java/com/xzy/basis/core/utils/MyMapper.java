package com.xzy.basis.core.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 此接口不能被扫描到
 *
 * @author xzy
 * @date 2019/9/2 14:56
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
