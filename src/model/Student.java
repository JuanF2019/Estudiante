package model;

public class Student
{
	//Constantes
	
	public static final char GRADUATED = 'G';
	public static final char RETIRED = 'R';
	public static final char ACTIVE = 'A';
	public static final double PAGRADE = 3.25;
	public static final double MAXGRADE = 5.0;
	public static final double MINGRADE = 1.0;
	
	//Atributos
	private String name;
	private String lastName;
	private String id;
	private boolean pA;
	private char type;
	
	//Relaciones
	Course course1 = null;
	Course course2 = null;
	Course course3 = null;
	Course course4 = null;
	Course course5 = null;
	
	//Constructor method
	
	public Student(String name, String lastName, String id, boolean pA, char type)
	{
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.pA = pA;
		this.type = type;		
	}
	
	//Sets and gets
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getlastName()
	{
		return this.lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void setid(String id)
	{
		this.id = id;
	}
	
	//Methods
	public double calculateFinalGrade()//Done
	{
		double finalGrade = 0.0;
		if (course1 != null){
			finalGrade = course1.getGrade()*course1.getNumCredits();
		}
		if (course2 != null){
			finalGrade = finalGrade + course2.getGrade()*course2.getNumCredits();
		}
		if (course3 != null){
			finalGrade = finalGrade + course3.getGrade()*course3.getNumCredits();
		}
		if (course4 != null){
			finalGrade = finalGrade + course4.getGrade()*course4.getNumCredits();
		}
		if (course5 != null){
			finalGrade = finalGrade + course5.getGrade()*course5.getNumCredits();
		}
		if (getTotalCredits()!= 0){
			finalGrade = finalGrade / getTotalCredits();
		}
		else{
			finalGrade = 0;
		}
		return finalGrade;		
	}
	
	public Course searchByID(String pID){
		Course tempCourse = null;
		if (course1 != null && pID.equals(course1.getID()){
			tempCourse = course1;
		}
		else if (course2 != null && pID.equals(course2.getID()){
			tempCourse = course2;
		}
		else if (course3 != null && pID.equals(course3.getID()){
			tempCourse = course3;
		}
		else if (course4 != null && pID.equals(course4.getID()){
			tempCourse = course4;
		}
		else if (course5 != null && pID.equals(course5.getID()){
			tempCourse = course5;
		}
		
	}
	public void addCourse{
		if (course1 != null){
			course1 = new Course(name,id,numCredits,grade,validate);
		}
		else if (course2 != null){
			course2 = new Course(name,id,numCredits,grade,validate);
		}
		else if (course3 != null){
			course3 = new Course(name,id,numCredits,grade,validate);
		}
		else if (course4 != null){
			course4 = new Course(name,id,numCredits,grade,validate);
		}
		else if (course5 != null){
			course5 = new Course(name,id,numCredits,grade,validate);
		}
	}
	
	public String getCourseName(int courseNum)//DONE
	{
		String name = "";
		
		switch (courseNum){
			case 1:
				name = course1.getName();
			break;
			case 2:
				name = course2.getName();
			break;
			case 3:
				name = course3.getName();
			break;
			case 4:
				name = course4.getName();
			break;
			case 5:
				name = course5.getName();
			break;			
			default:
		}
		return name;
	}
	
	public void deleteCourse(int demtrNum)//DONE
	{
		switch (courseNum){
			case 1:
				course1 = null;
			break;
			case 2:
				course2 = null;
			break;
			case 3:
				course3 = null;
			break;
			case 4:
				course4 = null;
			break;
			case 5:
				course5 = null;
			break;			
			default:
		}
	}
	
	public int getTotalCredits()//DONE
    {
        int totalCredits=0;
        if (course1 != null){
			totalCredits = course1.getNumCredits();
		}
		else if (course2 != null){
			totalCredits = totalCredits + course2.getNumCredits();
		}
		else if (course3 != null){
			totalCredits = totalCredits + course3.getNumCredits();
		}
		else if (course4 != null){
			totalCredits = totalCredits + course4.getNumCredits();
		}
		else if (course5 != null){
			totalCredits = totalCredits + course5.getNumCredits();
		}
        return totalCredits;
    }
	
	public boolean isPA()
	{
		boolean isPA = false;
		
		if(calculateFinalGrade() < PAGRADE)
		{
			isPA = true;
		}
		
		return isPA;
	}
	
}