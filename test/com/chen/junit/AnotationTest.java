package com.chen.junit;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

public class AnotationTest {

	/**
	 * @Test：将一个普通的方法修饰为一个测试方法
	 *    @Test(expected=XX.class)
	 *    @Test(timeout=毫秒)
	 * @BeforeClass：它会在所有的方法运行前被执行，static修饰
	 * @AfterClass：它会在所有的方法运行前被执行，static修饰
	 * @Before：会在每个测试方法被运行前执行一次
	 * @After：会在每个测试方法被运行后执行一次
	 * @Ignore：所修饰的方法会被测试运行器忽略
	 * @RunWith：可以更改测试运行器org.junit.runner.Runner
	 */
	
	@Test(expected=ArithmeticException.class)
	public void testDivide(){
		assertEquals(1, new Calculate().divide(3, 0));
	}
	
	@Ignore("...")
	@Test(expected=TestTimedOutException.class,timeout=2000)
	public void testWhile(){
		while(true){
			System.out.println("run forever...");
		}
	}
}
