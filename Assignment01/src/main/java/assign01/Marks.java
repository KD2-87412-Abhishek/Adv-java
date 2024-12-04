package assign01;

public class Marks {
	private String subject ;
	 public Marks(String subject, double d) {
		
		this.subject = subject;
		this.marks = d;
	}
	private double marks;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	

}
