package com.cja.app.base;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

@ContextConfiguration(locations = { "classpath:base.xml" })
public abstract class BeanTest extends AbstractJUnit38SpringContextTests{

	//测试基础类
}
