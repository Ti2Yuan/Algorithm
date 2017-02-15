/**
 * 
 */
package com.chen.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. 
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item
 * before inserting a new item.
 */
public class LRUCache {
	
	public class CacheItem<K, V>{
		private K key;
		private V value;
		private CacheItem<K, V> prev;
		private CacheItem<K, V> next;
		
		public CacheItem(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public CacheItem<K, V> getPrev(){
			return prev;
		}
		
		public void setPrev(CacheItem<K, V> prev){
			this.prev = prev;
		}

		public CacheItem<K, V> getNext() {
			return next;
		}

		public void setNext(CacheItem<K, V> next) {
			this.next = next;
		}
	}
	
	public class BidirectionalList<K, V>{
		private CacheItem<K, V> head = new CacheItem<K, V>(null,null);
		private CacheItem<K, V> tail = head;
		
		public void insertTail(CacheItem<K, V> node){
			tail.next = node;
			node.prev = tail;
			node.next = null;
			tail = node;
		}
		
		public void delete(CacheItem<K, V> node){
			if(head.next == null)
				return;
			if(node == head.next){
				deleteHead();
			}else if (node == tail) {
				deleteTail();
			}else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
				node.next = null;
				node.prev = null;
			}
		}

		private CacheItem<K, V> deleteTail() {
			if(head.next == null)
				return null;
			CacheItem<K, V> ret = tail;
			tail = tail.prev;
			tail.next = null;
			ret.prev = null;
			ret.next = null;
			return ret;
		}

		private CacheItem<K, V> deleteHead() {
			if(head.next == null)
				return null;
			if(head.next == tail){
				tail = tail.prev;
			}
			CacheItem<K, V> ret = head.next;
			head.next = ret.next;
			if(ret.next != null){
				ret.next.prev = head;
			}
			ret.next = null;
			ret.prev = null;
			return ret;
		}
 	}
	
	private Map<Integer, CacheItem<Integer, Integer>> cacheMap = new HashMap<>();
	private BidirectionalList<Integer, Integer> cacheList = new BidirectionalList<>();
	private int cacheSize = 0;
	private int capacity;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
	}
	
	public int get(int key){
		CacheItem<Integer, Integer> item = cacheMap.get(key);
		if(item == null)
			return -1;
		cacheList.delete(item);
		cacheList.insertTail(item);
		return item.value.intValue();
	}
	
	public void set(int key, int value){
		if(cacheMap.containsKey(key)){
			updateItem(key,value);
		}else if (cacheSize == capacity && removeLeastUsed()) {
			cacheSize--;
			addItem(key,value);
		}else{
			addItem(key,value);
		}
	}

	/**
	 * TODO
	 * @param key
	 * @param value
	 * void
	 */
	private void addItem(int key, int value) {
		// TODO Auto-generated method stub
		CacheItem<Integer, Integer> newCacheItem = new CacheItem<Integer, Integer>(key, value);
		cacheList.insertTail(newCacheItem);
		cacheMap.put(key, newCacheItem);
		cacheSize++;
	}

	/**
	 * TODO
	 * @return
	 * boolean
	 */
	private boolean removeLeastUsed() {
		// TODO Auto-generated method stub
		CacheItem<Integer, Integer> removedKey = cacheList.deleteHead();
		cacheMap.remove(removedKey.key);
		return removedKey == null?false:true;
	}

	/**
	 * TODO
	 * @param key
	 * @param value
	 * void
	 */
	private void updateItem(int key, int value) {
		// TODO Auto-generated method stub
		CacheItem<Integer, Integer> exitedKey = cacheMap.get(key);
		exitedKey.value = value;
		cacheList.delete(exitedKey);
		cacheList.insertTail(exitedKey);
	}
	
//	private int capacity;
//	private LinkedHashMap<Integer, Integer> map;
//	
//	public LRUCache(int capacity){
//		this.capacity = capacity;
//		this.map = new LinkedHashMap<>();
//	}
//	
//	public int get(int key){
//		Integer value = this.map.get(key);
//		if(value == null){
//			value = -1;
//		}else {
//			this.set(key,value);
//		}
//		return value;
//	}
//	
//	public void set(int key, int value){
//		if(this.map.containsKey(key)){
//			this.map.remove(key);
//		}else if (this.map.size() == this.capacity) {
//			Iterator<Integer> it = this.map.keySet().iterator();
//			it.next();
//			it.remove();
//		}
//		map.put(key, value);
//	}

}
