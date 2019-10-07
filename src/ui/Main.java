package ui;
import java.util.Scanner;
import model.*;

public class Main
{
	private Student student;
	Scanner input;
	Scanner inputNum;
		
	public Main()
	{
		student = new Student("Christian","Gallo","100484",false,'A');
	}
	
	public static void main(String[] args)
	{
		Scanner inputV = new Scanner(System.in);
		Main studentMain = new Main();
		studentMain.initialCourses();		
		double finalGrade = 0;
		int menuOpt = 0;
		boolean check = true;
		int matrCourses = 3; //Declara e inicializa la variable que indica cuantos cursos tiene matriculado el estudiante, empieza con 3 cursos.
		boolean menu = true;
		int matrNum = 0; //Numero de cursos a matricular
		int demtrNum = 0; //Numero de cursos a desmatricular
		String msg = "";
		
		
		while (menu)
		{
			System.out.println("Digite el numero correspondiente a la opcion que desea realizar.");
			System.out.println("Menu:");
			System.out.println("1. Matricular cursos");
			System.out.println("2. Desmatricular cursos");
			System.out.println("3. Ver cursos matriculados");
			System.out.println("4. Promedio final");
			System.out.println("5. Exit");
			finalGrade = studentMain.calculateFinalGrade(); //Actualiza la nota final.
			studentMain.changePA();//Actualiza el valor de prueba academica.			
			menuOpt = inputV.nextInt();
			switch (menuOpt)
			{
				case 1:
					System.out.println("Señor estudiante: Usted puede matricular un maximo de 5 cursos.");
					System.out.println("Escriba cuantos cursos desea matricular: ");
					
					check = true;
					while(check)	
					{
						matrNum = inputV.nextInt();
						if (matrNum >= 1 && matrNum <=5)
						{
							if (matrNum == matrCourses && matrCourses==5)
							{
								System.out.println("Usted tiene matriculados todos los cursos posibles, no puede matricular más.");						
							}
							else
							{
								for (int cont=1;cont<=matrNum;cont++);
								{
									msg = studentMain.matriculateCourse();
								}
								check = false;
								System.out.println(msg);
								matrCourses++;
							}
						}
						else
						{
							System.out.println("Numero invalido de cursos, digite nuevamente.");
						}
					}
				break;
				case 2:
					System.out.println("Escriba el numero del curso que desea desmatricular: ");
					
					check = true;
					while(check)	
					{
						demtrNum = inputV.nextInt();
						if (demtrNum >= 1 && demtrNum <=5)
						{
							studentMain.deleteCourse(demtrNum);
							System.out.println("Curso desmatriculado exitosamente.");
							check = false;
							matrCourses--;
						}
						else
						{
							System.out.println("Numero invalido de curso, digite nuevamente.");
						}
					}
					
				break;
				case 3:
					String courseName = "";
					for (int cont = 0; cont<matrCourses;cont++)
					{
						courseName = studentMain.getCourseName(cont);
						System.out.println((cont+1) + " " + courseName);
					}
				break;
				case 4:
					System.out.println("Su promedio al momento es: " + finalGrade);
				break;
				case 5:
					menu = false;
					System.out.println("Cerrando...");
				break;
				default:
					System.out.println("Opcion invalida, digite una opcion nuevamente.");
			}
		}
				
	}
	public String matriculateCourse(String name, String id, int numCredits, double grade, boolean validate)
	{
		input = new Scanner(System.in);
		inputNum = new Scanner(System.in);
		boolean check = true;
		
		System.out.println("Escriba el nombre del curso: ");
		String name = input.nextLine();
			
		System.out.println("Escriba el id del curso: ");
		String id = input.nextLine();
		
		System.out.println("Escriba el numero de creditos del curso: ");
		int numCredits = inputNum.nextInt();
			
		System.out.println("Escriba la nota del curso: ");
		double grade = inputNum.nextDouble();
			
		System.out.println("El curso es validable? (Digite si o no): ");
		boolean validate = true;
		while(check)
		{
			String sValidate = input.nextLine();
			sValidate = sValidate.toLowerCase();
			switch (sValidate)
			{
				case "si":
					validate = true;
					check = false;
				break;
				case "no":
					validate = false;
					check=false;
				break;
				default:
					System.out.println("Entrada no valida, digite nuevamente su respuesta.");
			}	
		}
				
		String msg = "";
		boolean nullCourse = false;
		checkCourse = student.searchByID(id);
		if(checkCourse == null){
			if(student.getType() == student.ACTIVE){
				if (course1 == null){
					nullCourse = true;
				}
				else if (course2 == null){
					nullCourse = true;
				}
				else if (course3 == null){
					nullCourse = true;
				}
				else if (course4 == null){
					nullCourse = true;
				}
				else if (course5 != null){
					nullCourse = true;
				}
				
				if(nullCourse = true){
					student.addCourse();
					msg = "Curso matriculado exitosamente.";
				}
			}
			else{
				msg = "Usted no es un estudiante activo, no puede matricular cursos.";
			}
		}
		else{
			msg = "El curso ya esta matriculado o id mal digitada.";
		}
		return msg;
	}
		
	public void initialCourses()
	{
		student.matriculateCourse("Quimica Organica II","0003",4,3.7,true);
		student.matriculateCourse("Analisis Quimico","0008",4,4.5,false);
		student.matriculateCourse("Calculo de varias variables","0007",3,3.5,true);
	}
	
	public double calculateFinalGrade()
	{
		double finalGrade = student.calculateFinalGrade();
		return finalGrade;
	}
	public void changePA()
	{
		student.isPA();		
	}
	public void deleteCourse(int demtrNum)
	{
		student.deleteCourse(demtrNum);
	}
	public String getCourseName(int cont)
	{
		String name = student.getCourseName(cont);
		return name;		
	}
}