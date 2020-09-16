package com.synechron.bdd.actitime.java;

public  class Person 
{ 
	String name;
	double height;
	double weight;
	int age;
	static final String country = "India";
	
	@Override
	public String toString() {
		return "The person class Object values are"
				+ "Name - "  + this.name
				+ "\nHeight - " + this.height
				+ "\nWeight - " + this.weight
				+ "\nAge - " + this.age
				+ "\nCountry " + country;
	}
	
	
//  [Access specifiers] [Access modifiers] return_type name()
	public static void main(String[] args) throws InterruptedException 
	{
		Person p1 = new Person();
		
		p1.name = "ABC";
		p1.height = 5.8;
		p1.weight = 55;
		p1.age = 30;
		
		System.out.println(p1);
			System.out.println(country);	
		Person p2 = new Person();
		
		
		
		
		
	}
	
	// if return type is other  then void, then the last statement should be 
	//return statement
	
	
	
	
	void displayPersonName()
	{
		System.out.println(name);
		//System.out.println(count);
		
	}
	void displayPersonName2()
	{
		System.out.println(name);
		
	}
	
//	abstract void details();
	

}
