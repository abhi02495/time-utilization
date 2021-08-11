package abhishek2495.com.timeutilization.request;

public class TimeUtilizationRequest {
	
	private String date;
	private int totalTasks;
	private int noOfTasksDone;
	private double totalHoursAllocated;
	private double totalHoursUsed;
	private double targetHours;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotalTasks() {
		return totalTasks;
	}
	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}
	public int getNoOfTasksDone() {
		return noOfTasksDone;
	}
	public void setNoOfTasksDone(int noOfTasksDone) {
		this.noOfTasksDone = noOfTasksDone;
	}
	public double getTotalHoursAllocated() {
		return totalHoursAllocated;
	}
	public void setTotalHoursAllocated(double totalHoursAllocated) {
		this.totalHoursAllocated = totalHoursAllocated;
	}
	public double getTotalHoursUsed() {
		return totalHoursUsed;
	}
	public void setTotalHoursUsed(double totalHoursUsed) {
		this.totalHoursUsed = totalHoursUsed;
	}
	public double getTargetHours() {
		return targetHours;
	}
	public void setTargetHours(double targetHours) {
		this.targetHours = targetHours;
	}
	
}
