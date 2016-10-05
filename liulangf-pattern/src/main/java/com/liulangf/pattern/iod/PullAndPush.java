package com.liulangf.pattern.iod;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Data access interface structure: An interface can provide sequential
 * or random retrieval of data. Users can either pull data or have it
 * pushed upon them.
 * 
 * pull ：拉 
 * push : 推 
 * 
 * 经济学中，销售需求导向和推销导向的术语
 * push model 通过广告，捆绑，试用，强行推广产品，比较主动。
 * pull model 勾引顾客的期待和欲望，让他们自己来拉动市场 
 * 
 * @author LiuYuQing
 * @version 1.0 2010-12-20
 */
public class PullAndPush {
	
	/**
	 * Data can be available in sequential or random manner.
	 * Such as: 
	 *   FileInputStream allows only sequential access.
	 *   RandomAccessFile allows access to the data in a file in any order.
	 *   
	 *   And also, collections and iterators.[List or array index].
	 *   
	 *   And also for accessing data in an XML file.
	 *   SAX: sequential access
	 *       Advantage : requires less resources to parse the file.
	 *       Disadvantage: application cannot change the XML data.
	 *   DOM:Random Access
	 *       Advantage:application can change the XML data
	 *       Disadvantage:requires memory to store the entire document.
	 */
	public void sequentialAndRandomRetrival() {
	}
	
	/**
	 * Interfaces move data in one of two ways: push or pull.
	 * You ask a pull style interface for data. 
	 * On the other hand, a push-style interface transfers data to you. 
	 * An email subscription is a push-style interface. 
	 * 
	 * Pull style: appears as a common control style(e.g., loop) in multiple languages.
	 * Push style: hard to understand.
	 * 
	 * SAX: sequential access/push
	 *     Disadvantage -user must keep track of previous events.
	 * DOM: random access/pull
	 *     Advantage -simple find particular elements.
	 * Stax: sequential access/pull
	 *     Advantage -flow may be familiar to more programmers.
	 *     Disadvantage -may have more code than the other two alternatives.
	 */
	public void pullAndPushData() {
	}
	
	/**
	 * You can use either a pull style or a push style when going through
	 * a collection.
	 * Design patterns refer to pull and push styles for a collection 
	 * as internal and external iterators.
	 */
	public void accessDataFromList(PushStyleList<ItemData> items) {
		//pull style
		for (ItemData item : items) {
			//pull style, get data from object directly.
			item.toString();
		}
		
		//push style access
		items.forEach(new Printer<ItemData>() {
			public void print(ItemData data) {
				//just a demo
				data.toString();
			}
		});
	}
	
	class ItemData {
		private String name;
		private int age;
		
		//.....
		
		@Override
		public String toString() {
			return "Item:[" + name + ", " + age + "]";
		}
	}

	/**
	 * A push style list. Push data to me please.
	 * And I'll dealing with it using Printer.
	 */
	class PushStyleList<T> extends ArrayList<T> {
		public void forEach(Printer<T> printer) {
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T item = it.next();
				printer.print(item);
			}
		}
	}

	/**
	 * How to deal with data pushed to me.
	 */
	interface Printer<T> {
		public void print(T data);
	}

}
