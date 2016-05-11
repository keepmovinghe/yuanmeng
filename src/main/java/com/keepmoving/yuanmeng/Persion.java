package com.keepmoving.yuanmeng;

public class Persion {

	private String name;// 姓名
	private String age;// 年龄
	private Car car;// 车

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Persion [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

}
