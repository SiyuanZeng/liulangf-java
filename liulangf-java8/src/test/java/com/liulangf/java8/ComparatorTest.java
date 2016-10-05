package com.liulangf.java8;

import java.util.Comparator;

import org.junit.Test;

public class ComparatorTest {

	@Test
	public void test() {
		Comparator<User> uc = Comparator.comparing(User::getName)
				.thenComparing(User::getAge);
	}
	
	
	
	class User {
		private String name;
		private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}

}
