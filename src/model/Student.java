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
	Course[] courses = new Course[5]; 
	
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
	public double calculateFinalGrade()
	{
		double notaAcumulada = 0.0;
		for(int i=0; i < courses.length; i++)
		{
			Course obj = null; 
			
			if (courses[i] != null)
			{
				obj = courses[i];
				notaAcumulada += obj.getGrade() * obj.getNumCredits();
			}
		}
		
		notaAcumulada = notaAcumulada / getTotalCredits(); 
		
		return notaAcumulada;
		
	}
	
	public void matriculateCourse(String name, String id, int numCredits, double grade, boolean validate)
	{
		for(int i=0; i < courses.length; i++)
		{		
			if (courses[i] == null)
			{	
				
				if(grade < MINGRADE)
				{ 
					grade = MINGRADE;
				} else if (grade > MAXGRADE)
				{
					grade = MAXGRADE;
				}
				
				courses[i] = new Course(name, id, numCredits, grade, validate);
				i = courses.length;
			}	
		}
	}
	
	public String getCourseName(int courseNum)//Agregado
	{
		String name = courses[courseNum].getName();
		return name;
	}
	
	public void deleteCourse(int demtrNum)//Agregado
	{
		courses[demtrNum] = null;
	}
	
	public int getTotalCredits()
    {
        int totalCredits=0;
        for(int i = 0; i < courses.length; i++)
        {
            if (courses[i]!=null)
			{
				totalCredits += courses[i].getNumCredits();
			}
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