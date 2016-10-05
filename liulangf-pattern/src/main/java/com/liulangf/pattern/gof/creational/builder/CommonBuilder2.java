package com.liulangf.pattern.gof.creational.builder;

/**
 * Reference from guavar07 util.concurrent.ThreadFactoryBuilder.
 *
 * @author Quqing Liu
 */
public class CommonBuilder2 {
	
	public static void main(String...args) {
		HumanFactoryBuilder builder = new HumanFactoryBuilder();
		HumanFactory factory = 
			builder.setAge(10).setName("Paul").setId("movie").build();
		Human human = factory.createHuman();
		System.out.println(human);
	}

}

final class HumanFactoryBuilder {
	
	private String name;
	private String id;
	private int age;
	
	public HumanFactoryBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public HumanFactoryBuilder setId(String id) {
		this.id = id;
		return this;
	}
	
	public HumanFactoryBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	
	/**
	 * Builder.build();
	 * 
	 * @return
	 */
	public HumanFactory build() {
		return build(this);
	}
	
	private HumanFactory build(final HumanFactoryBuilder builder) {
		return new HumanFactory() {
			public Human createHuman() {
				return new Human() {
					private String name = builder.name;
					private String id = builder.id;
					private int age = builder.age;
					
					public void setName(String name) {
						this.name = name;
					}
					public void setId(String id) {
						this.id = id;
					}
					public void setAge(int age) {
						this.age = age;
					}
					public String getName() { return name; }
					public String getId() { return id;}
					public int getAge() { return age; }
					
					public String toString() {
						return "[name=" + name + ", id=" + id + ", age=" + age + "]";
					}
				};
			}
		};
	}
}

interface Human {
	void setName(String name);
	void setId(String id);
	void setAge(int age);
	String getName();
	String getId();
	int getAge();
	
}

interface HumanFactory {
	Human createHuman();
}