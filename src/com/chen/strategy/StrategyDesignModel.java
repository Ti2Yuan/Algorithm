package com.chen.strategy;

public class StrategyDesignModel {

	public static void main(String[] args) {
		User user = new User("jack",25,"ÄÐ");
		Request<?> request1 = new Request<>(RequestType.synchronizedType);
		Request<?> request2 = new Request<User>(RequestType.insertType,user);
		Request<?> request3 = new Request<String>(RequestType.selectType,"jack");
		Request<?> request4 = new Request<>(RequestType.none);
		
		System.out.println(handle(request1));
		System.out.println(handle(request2));
		System.out.println(handle(request3));
		System.out.println(handle(request4));
	}

	private static String handle(Request<?> request) {
		if(request == null)
			return null;
		IHandler handler;
		handler = findHandlerByType(request.getAction());
		return handler.handle(request.getData());
	}

	private static IHandler findHandlerByType(RequestType action) {
		IHandler handler;
		switch(action){
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
