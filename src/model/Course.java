package model;
public class Course
{
	//Atributes
	
	private String name;
	private String id;
	private int numCredits;
	private double grade;
	private boolean validate; 
	
	//Constructor
	public Course(String name, String id, int numCredits, double grade, boolean validate)
	{
		this.name = name;
		this.id = id;
		this.numCredits = numCredits;
		this.grade = grade; 
		this.validate = validate; 
	}
	
	
	// Setters & Getters
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void setId(String id)
	{
		this.id = id; 
	}
	
	public int getNumCredits()
	{
		return numCredits;
	}
	
	public void setNumCredits(int numCredits)
	{
		this.numCredits = numCredits;
	}
	
	public double getGrade()
	{
		return grade;
	}
	
	public void setGrade(double grade)
	{
		this.grade = grade;
	}
	
	public boolean getValidate()
	{
		return validate;
	}
	
	public void setValidate(boolean validate)
	{
		this.validate = validate;
	}
	
}