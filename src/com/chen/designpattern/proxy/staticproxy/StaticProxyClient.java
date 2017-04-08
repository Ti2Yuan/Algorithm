/**
 * 
 */
package com.chen.designpattern.proxy.staticproxy;

/**
 * 静态代理：由程序员创建或特定工具自动生成源代码，再对其编译。在程序运行前，代理类的.class文件就已经存在了。
 */
public class StaticProxyClient {

	
	public static void main(String[] args) {
		BankAccount bankAccount = new MyBankAccount();
		
		BankTeller bankTeller = new BankTeller(bankAccount);
		
		bankTeller.query();
		
		System.out.println();
		
		bankTeller.take();
		
		System.out.println();
		
		bankTeller.add();
		
	}

}
