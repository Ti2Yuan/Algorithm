package com.chen.junit;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

public class AnotationTest {

	/**
	 * @Test����һ����ͨ�ķ�������Ϊһ�����Է���
	 *    @Test(expected=XX.class)
	 *    @Test(timeout=����)
	 * @BeforeClass�����������еķ�������ǰ��ִ�У�static����
	 * @AfterClass�����������еķ�������ǰ��ִ�У�static����
	 * @Before������ÿ�����Է���������ǰִ��һ��
	 * @After������ÿ�����Է��������к�ִ��һ��
	 * @Ignore�������εķ����ᱻ��������������
	 * @RunWith�����Ը��Ĳ���������org.junit.runner.Runner
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
