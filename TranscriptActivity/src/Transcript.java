import java.util.ArrayList;
import java.text.DecimalFormat;

public class Transcript {
	ArrayList<CourseEnrollment> courseEnrollment;
	double gpa;

	public Transcript() {
		courseEnrollment = new ArrayList<CourseEnrollment>();
		gpa = 0.0;
	}

	public void addCourse(CourseEnrollment courseenrollment) {
		try {
			courseEnrollment.add(courseenrollment);
		} catch (ArrayStoreException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<CourseEnrollment> getCourses() {
		return courseEnrollment;
	}

	public double getOverallGPA() {
		int credits = 0;
		
		try {
			for (int i = 0; i < courseEnrollment.size(); i++) {
				gpa += courseEnrollment.get(i).getQualityPoints()
						* courseEnrollment.get(i).getCredits();
				credits += courseEnrollment.get(i).getCredits();
			}
			gpa /= credits;
		} catch (ArithmeticException e){
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return gpa;
	}

	public String getFormattedGPA() {
		DecimalFormat gpa = new DecimalFormat(".##");
		return gpa.format(getOverallGPA());
	}
	
}