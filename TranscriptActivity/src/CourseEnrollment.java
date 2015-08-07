
public class CourseEnrollment {
	String courseCode;
	int credits;
	String grade;
	double qualityPoints;

	public CourseEnrollment() {
		courseCode = "";
		credits = 0;
		grade = "";
		qualityPoints = 0.0;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getQualityPoints() {
		return qualityPoints;
	}

	public void setQualityPoints() {
		if (this.getGrade().equalsIgnoreCase("A")) {
			qualityPoints = 4;
		} else if (this.getGrade().equalsIgnoreCase("B")) {
			qualityPoints = 3;
		} else if (this.getGrade().equalsIgnoreCase("C")) {
			qualityPoints = 2;
		} else if (this.getGrade().equalsIgnoreCase("D")) {
			qualityPoints = 1;
		} else {
			qualityPoints = 0;
		}
	}

	@Override
	public String toString() {
		String line = String.format("%-13s%-12s%-10s%s", this.getCourseCode(),
				this.getCredits(), this.getGrade().toUpperCase(),
				this.getQualityPoints());
		return line;
	}
}