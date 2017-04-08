/**
 * 
 */
package com.chen.designpattern.proxy.jdkdynamicproxy;

/**
 * 实现Movie和Game接口的Computer类，可看电影，可玩游戏
 */
public class Computer implements Movie, Game {

	/* TODO
	 * @see com.chen.designpattern.proxy.jdkdynamicproxy.Game#play()
	 */
	@Override
	public void play() {
		System.out.println("playing game now------");
	}

	/* TODO
	 * @see com.chen.designpattern.proxy.jdkdynamicproxy.Movie#watch()
	 */
	@Override
	public void watch() {
		System.out.println("watching movie now-----");
	}

}
