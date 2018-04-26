package com.jackie.mybatis.pagination.interceptor;

import org.apache.ibatis.session.RowBounds;

/**
 * Created by jackie on 10/31/2016.
 */
public interface Dialect {
    String composite(String oldSql, RowBounds rowBounds);
}
