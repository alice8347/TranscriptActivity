import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class TranscriptAppTest {

	@Test
	public void test_setCourseCodeSingleWord() {
		System.out.println("Test if the course code was stored correctly. (Single Word)");
		CourseEnrollment test = new CourseEnrollment();
		test.setCourseCode("java");
		assertTrue(test.getCourseCode().equals("java"));
	}
	
	@Test
	public void test_setCourseCodeMutipleWords() {
		System.out.println("Test if the course code was stored correctly. (Multiple Words)");
		CourseEnrollment test = new CourseEnrollment();
		test.setCourseCode("java 101");
		assertTrue(test.getCourseCode().equals("java 101"));
	}
	
	@Test
	public void test_setCredits() {
		System.out.println("Test if the credits were stored correctly.");
		CourseEnrollment test = new CourseEnrollment();
		test.setCredits(3);
		assertTrue(test.getCredits() == 3);
	}
	
	@Test
	public void test_setGrade() {
		System.out.println("Test if the grade was stored correctly.");
		CourseEnrollment test = new CourseEnrollment();
		test.setGrade("A");
		assertTrue(test.getGrade().equals("A"));
	}
	
	@Test
	public void test_getQualityPoints() {
		System.out.println("Test if the grade converted to GPA.");
		CourseEnrollment test = new CourseEnrollment();
		test.setGrade("A");
		test.setQualityPoints();
		assertTrue(test.getQualityPoints() == 4);
	}
	
	@Test
	public void test_getQualityPointsNotCaseSensitive() {
		System.out.println("Test if the system can read lowercase letter and convert to GPA.");
		CourseEnrollment test = new CourseEnrollment();
		test.setGrade("f");
		test.setQualityPoints();
		assertTrue(test.getQualityPoints() == 0);
	}
	
	@Test
	public void test_toString() {
		System.out.println("Test if course was printed in the right format.");
		CourseEnrollment test = new CourseEnrollment();
		test.setCourseCode("java 101");
		test.setCredits(3);
		test.setGrade("A");
		test.setQualityPoints();
		assertTrue(test.toString().equals("java 101     3           A         4.0"));
	}
	
	@Test
	public void test_addCourse() {
		System.out.println("Test if courseEnrollments were stored in the ArrayList");
		Transcript transcript = new Transcript();
		CourseEnrollment test1 = new CourseEnrollment();
		CourseEnrollment test2 = new CourseEnrollment();
		test1.setCourseCode("java 101");
		test1.setCredits(3);
		test1.setGrade("A");
		test1.setQualityPoints();
		test2.setCourseCode("english 202");
		test2.setCredits(3);
		test2.setGrade("B");
		test2.setQualityPoints();
		transcript.addCourse(test1);
		transcript.addCourse(test2);
		String s1 = transcript.getCourses().get(0).toString();
		String s2 = transcript.getCourses().get(1).toString();
		assertTrue(s1.equals("java 101     3           A         4.0") && s2.equals("english 202  3           B         3.0"));
	}
	
	@Test
	public void test_getOverallGPASameCredits() {
		System.out.println("Test if the overall GPA was correct. (Same Credits)");
		Transcript transcript = new Transcript();
		CourseEnrollment test1 = new CourseEnrollment();
		CourseEnrollment test2 = new CourseEnrollment();
		test1.setCredits(3);
		test1.setGrade("A");
		test1.setQualityPoints();
		test2.setCredits(3);
		test2.setGrade("B");
		test2.setQualityPoints();
		transcript.addCourse(test1);
		transcript.addCourse(test2);
		assertTrue(transcript.getOverallGPA() == 3.5);
	}
	
	@Test
	public void test_getOverallGPADiffCredits() {
		System.out.println("Test if the overall GPA was correct. (Different Credits)");
		Transcript transcript = new Transcript();
		CourseEnrollment test1 = new CourseEnrollment();
		CourseEnrollment test2 = new CourseEnrollment();
		test1.setCredits(3);
		test1.setGrade("A");
		test1.setQualityPoints();
		test2.setCredits(2);
		test2.setGrade("B");
		test2.setQualityPoints();
		transcript.addCourse(test1);
		transcript.addCourse(test2);
		assertTrue(transcript.getOverallGPA() == 3.6);
	}
	
	@Test
	public void test_getFormattedGPA() {
		System.out.println("Test if GPA was formatted to two decimal places.");
		Transcript transcript = new Transcript();
		CourseEnrollment test1 = new CourseEnrollment();
		CourseEnrollment test2 = new CourseEnrollment();
		test1.setCredits(3);
		test1.setGrade("A");
		test1.setQualityPoints();
		test2.setCredits(4);
		test2.setGrade("B");
		test2.setQualityPoints();
		transcript.addCourse(test1);
		transcript.addCourse(test2);
		assertTrue(transcript.getFormattedGPA().equals("3.43"));
	}
	
	@Test
	public void test_getString() {
		System.out.println("Test if the system can read course code which has multiple words.");
		ByteArrayInputStream in = new ByteArrayInputStream("java 101".getBytes());
		System.setIn(in);
		Scanner sc = new Scanner(System.in);
		assertTrue(Validator.getString(sc, "").equals("java 101"));
	}
	
}
