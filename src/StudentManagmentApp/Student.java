package StudentManagmentApp;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Student {

	private String firstName;
	private String lastName;
	private int gradeYear;
	private static int classId = 1000;
	private String studentId;
	private Set<String> studentCourses = new HashSet<>();
	private double tuitionFee = 0;
	
	
	Student (){
		Scanner in = new Scanner(System.in);
		System.out.print("---------------------------------");
		System.out.print("\nEnter the first name: ");
		this.firstName = validString(in);
		
		System.out.print("Enter the last name: ");
		this.lastName = validString(in);
		
		enterGradeYear(in);
		
		setStudentId();
		
		System.out.print(firstName + " " + lastName + " " + gradeYear + " " + studentId);
		System.out.print("\n---------------------------------");
		
	}
	
	private void setStudentId() {
		++classId;
		studentId = gradeYear + "" + classId;
	}
	
	private void enterGradeYear(Scanner in) {
		int num = 0;
		do {
			System.out.print("1-Freshman\n 2-Sophmore\n 3-Junior\n 4-Senior\n Enter the grade year: ");
			try {num = in.nextInt();}
			catch(InputMismatchException e) {
				   System.out.println("Invalid input. Please enter a valid number.");
		            in.nextLine();
		            continue;
			}
			
		if(num < 1 || num >4) {
			System.out.print("Invalid number, try again!\n");
		}
		else {this.gradeYear = num;
		break;}
		}while(1 != 0);
	}
	
	public void enroll() {
		Scanner in = new Scanner(System.in);
		System.out.print("---------------------------------");
		System.out.print("\n1-Chemistry 101\n2-Computer Science 101\n3-English 101\n4-History 101\n5-Mathematics 101");
		do {
			System.out.print("\nEnroll in one of the following(1-4)(Q to exit):");
		String Class = in.nextLine();
		if(Class.equals("Q")){break;}
		
		switch(Class) {
		case "1":
			studentCourses.add("Chemistry 101");
			break;
		case "2":
			studentCourses.add("Computer Science 101");
			break;	
		case "3":
			studentCourses.add("English 101");
			break;
		case "4":
			studentCourses.add("History 101");
			break;
		case "5":
			studentCourses.add("Mathematics 101");
			break;
		default:
			System.out.print("Invalid entry, try again!");
			break;
			
		}
		
		}while(1 != 0);
		System.out.print("\n---------------------------------");
		updateTuition();
		viewEnrolled();
		viewTuitionFee();
	}
	
	
	public void viewEnrolled() {
		System.out.print("\nStudent " + this.firstName + " " + this.lastName + " is enrolled in:");
		System.out.println(studentCourses);
	}
	
	private void updateTuition() {
		for(int i = 0; i<studentCourses.size(); i++) {
		tuitionFee += 600;
		}
	}
	
	public void viewTuitionFee() {
		System.out.print("Tuition fee for student " + this.firstName + " " + this.lastName + " is:");
		System.out.print(this.tuitionFee);
	}
	
	public void payTuition() {
		Scanner in = new Scanner(System.in);
		double num = 0;
		do {
		System.out.print("\nEnter the amount you whish to pay: ");
		try { num = in.nextDouble();}
		
		 catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a valid number.");
            in.nextLine();
            continue;
             
             
         }
		if(num <0 || num > this.tuitionFee) {
			System.out.print("Invalid input, try again!");
		}
		else {tuitionFee -= num;
		break;}
		}while(1!=0);
		viewTuitionFee();
	}
	
	
	private String validString(Scanner in) {
		String str = "";
		do {

             str = in.nextLine();
             if(!str.matches("[a-zA-Z]+")) {
            	 System.out.print("Invalid input, please try again:");
            	 continue;
             }
             else {return str;}
		}while(1!=0);
	
	}
}
