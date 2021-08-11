package abhishek2495.com.timeutilization.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="data")
public class TimeUtilizationData {

	@Id
	private ObjectId id;
	
	@Field(name="date")
	private String date;
	
	@Field(name="total_tasks")
	private int totalTasks;
	
	@Field(name="tasks_done")
	private int noOfTasksDone;
	
	@Field(name="hours_allocated")
	private double totalHoursAllocated;
	
	@Field(name="hours_completed")
	private double totalHoursUsed;
	
	@Field(name="hours_targeted")
	private double targetHours;
	
	@Field(name="week_no")
	private int weekNumber;
	
	@Field(name="percentage")
	private double percentage;
	
	@Field(name="hours_wasted")
	private double hoursWasted;
	
	
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
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
	public int getWeekNumber() {
		return weekNumber;
	}
	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public double getHoursWasted() {
		return hoursWasted;
	}
	public void setHoursWasted(double hoursWasted) {
		this.hoursWasted = hoursWasted;
	}
	
	
	
}
