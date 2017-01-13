package com.jackie.mybatis.demo.interceptor;

import org.apache.ibatis.session.RowBounds;

/**
 * Created by jackie on 10/31/2016.
 */
public class MysqlDialect implements Dialect {

    @Override
    public String composite(String oldSql, RowBounds rowBounds) {
        int offset = rowBounds.getOffset();
        int limit = rowBounds.getLimit();
        StringBuilder sqlBuilder = new StringBuilder(oldSql);
        sqlBuilder.append(" ")
                .append("limit ")
                .append(offset)
                .append(",")
                .append(limit);
        return sqlBuilder.toString();
    }
}
