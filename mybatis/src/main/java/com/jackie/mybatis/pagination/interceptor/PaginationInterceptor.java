package com.jackie.mybatis.pagination.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * Created by jackie on 10/31/2016.
 */
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PaginationInterceptor implements Interceptor {
    private static final int MAPPED_STATEMENT = 0;
    private static final int ROW_BOUNDS = 2;
    private static final int PARAMETER = 1;
    private final String dialectClass;
    private Dialect dialect;

    public PaginationInterceptor(String dialectClass) {
        this.dialectClass = dialectClass;
        Object o = ClassUtil.newInstance(dialectClass);
        this.dialect = (Dialect) o;
    }


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();

        if (args[ROW_BOUNDS] != null) {
            MappedStatement ms = (MappedStatement) args[MAPPED_STATEMENT];
            RowBounds rowBounds = (RowBounds) args[ROW_BOUNDS];
            Object parameter = args[PARAMETER];

            SqlSource sqlSource = ms.getSqlSource();
            BoundSql boundSql = sqlSource.getBoundSql(parameter);
            String sql = boundSql.getSql();
            String newSql = dialect.composite(sql, rowBounds);
            ClassUtil.setValue(boundSql, "sql", newSql);
            ClassUtil.setValue(ms, "sqlSource", new SqlSource() {
                @Override
                public BoundSql getBoundSql(Object parameterObject) {
                    return boundSql;
                }
            });
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
