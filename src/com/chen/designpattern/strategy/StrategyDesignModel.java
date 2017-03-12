package com.chen.designpattern.strategy;

/**
 * 策略模式属于对象的行为模式。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换。
 * 策略模式使得算法可以在不影响到客户端的情况下发生变化。 策略模式是对算法的包装，是把使用算法的责任和算法本身分割开来，委派给不同的对象管理。
 * 策略模式通常把一个系列的算法包装到一系列的策略类里面，作为一个抽象策略类的子类。
 * 用一句话来说，就是：“准备一组算法，并将每一个算法封装起来，使得它们可以互换”。
 * 
 * 策略模式的优点
 * （1）策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族。恰当使用继承可以把公共的代码移到父类里面，从而避免代码重复。
 * 
 * （2）使用策略模式可以避免使用多重条件(if-else)语句。多重条件语句不易维护，它把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起，
 * 统统列在一个多重条件语句里面，比使用继承的办法还要原始和落后。
 * 
 * 策略模式的缺点
 * （1）客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类。
 * 换言之，策略模式只适用于客户端知道算法或行为的情况。
 * 
 * （2）由于策略模式把每个具体的策略实现都单独封装成为类，如果备选的策略很多的话，那么对象的数目就会很可观。
 */

public class StrategyDesignModel {

	public static void main(String[] args) {
		User user = new User("jack", 25, "��");
		Request<?> request1 = new Request<>(RequestType.synchronizedType);
		Request<?> request2 = new Request<User>(RequestType.insertType, user);
		Request<?> request3 = new Request<String>(RequestType.selectType, "jack");
		Request<?> request4 = new Request<>(RequestType.none);

		System.out.println(handle(request1));
		System.out.println(handle(request2));
		System.out.println(handle(request3));
		System.out.println(handle(request4));
	}

	private static <T> String handle(Request<T> request) {
		if (request == null)
			return null;
		IHandler handler;
		handler = findHandlerByType(request.getAction());
		return handler.handle(request.getData());
	}

	private static IHandler findHandlerByType(RequestType action) {
		IHandler handler;
		switch (action) {
		case synchronizedType:
			handler = new SynchronizedHandler();
			break;
		case insertType:
			handler = new InsertHandler();
			break;
		case selectType:
			handler = new SelectHandler();
			break;
		default:
			throw new RuntimeException("Need to implement all request types");
		}
		return handler;
	}

}
