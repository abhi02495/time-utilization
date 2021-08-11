package abhishek2495.com.timeutilization.service;

import org.springframework.stereotype.Service;

@Service
public class Calculations {

	public double percentageOfTimeCovered(double totalHrsAllocated, double hoursCompleted) {
		
		return (hoursCompleted/totalHrsAllocated)*100;
	}
	
	public double timeWasted(double targetedHours, double hoursCompleted) {
		
		return targetedHours - hoursCompleted;
	}
}
