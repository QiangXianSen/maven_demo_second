package com.tz.core;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

//@Intercepts({ @Signature(type = Executor.class, method = "update", args = {
//MappedStatement.class, Object.class }) })
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }),
   @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class })
 })
public class ExamplePlugin implements Interceptor {
	public Object intercept(Invocation invocation) throws Throwable {
		
		System.out.println("=================="+invocation);
		System.out.println("=================="+invocation.getTarget().getClass().getName());
		System.out.println("=================="+invocation.getMethod());
		System.out.println("=================="+invocation.getArgs());
		MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
		System.out.println(statement.getId());
		
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		System.out.println("**********************"+target);
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		System.out.println("333333333333333333333333"+properties);
	}
}