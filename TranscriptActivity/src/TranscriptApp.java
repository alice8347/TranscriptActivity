import java.util.InputMismatchException;
import java.util.Scanner;

public class TranscriptApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String code = "";
		int credits = 0;
		String grade = "";
		String choice = "y";
		Transcript transcript = new Transcript();

		System.out.println("Welcome to the invoice application.");
		System.out.println();

		while (choice.equalsIgnoreCase("y")) {
			CourseEnrollment courseEnrollment = new CourseEnrollment();

			try {
				code = Validator.getString(sc, "Enter course: ");
				courseEnrollment.setCourseCode(code);
				credits = Validator.getInt(sc, "Enter credits: ", -1, 10);
				courseEnrollment.setCredits(credits);
				grade = Validator.getGrade(sc, "Enter grade: ");
				courseEnrollment.setGrade(grade);
				courseEnrollment.setQualityPoints();
				transcript.addCourse(courseEnrollment);
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.print("Another course? (y/n): ");
			choice = sc.nextLine();
			System.out.println();
		}
		System.out.printf("%-13s%-12s%-10s%s%n", "Course", "Credits", "Grade",
				"Quality Points");
		System.out.printf("%-13s%-12s%-10s%s%n", "------", "-------", "-----",
				"--------------");
		
		try {
			for (int i = 0; i < transcript.getCourses().size(); i++) {
				System.out.print(transcript.getCourses().get(i).toString());
				System.out.println();
			}
		} catch (NullPointerException e){
			System.out.println(e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.printf("%49s%n", "GPA: " + transcript.getFormattedGPA());
		}
	}
	
}
