/**
 * 
 */
package com.chen.lrucache;

/**
 *
 */
public class LRUCacheTest {

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(2);
		lruCache.set(1, 1);
		lruCache.set(2, 4);
		lruCache.set(1, 8);
		lruCache.set(1, 10);
		System.out.println(lruCache.get(2));
		System.out.println(lruCache.get(1));
	}

}
