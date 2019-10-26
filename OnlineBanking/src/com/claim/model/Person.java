package com.claim.model;

public abstract class Person
{

	public int personidCounter = 1;
	int personid=0;
	String firstName="";
	String lastName="";	
	Address address=null;
	String telephoneNumber="";
	String email="";
	String password="";
	
	public Person()
	{
		
	}

	public Person(String firstName, String lastName, String telephoneNumber, String email,
			String password, String street, String city, String state, String zipCode)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.password = password;
		this.address = new Address(street, city, state, zipCode);

	}

	public int getPersonidCounter()
	{
		return personidCounter;
	}

	public void setPersonidCounter(int personidCounter)
	{
		this.personidCounter = personidCounter;
	}

	public int getPersonid()
	{
		return personid;
	}

	public void setPersonid(int personid)
	{
		this.personid = personid;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	
	

	
}
