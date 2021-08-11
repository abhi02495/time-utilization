package abhishek2495.com.timeutilization.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import abhishek2495.com.timeutilization.model.TimeUtilizationData;
import abhishek2495.com.timeutilization.repository.TimeUtilizationRepository;

@Service
public class TimeUtilizationService {
	
	public TimeUtilizationService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private TimeUtilizationRepository timeUtilization_repo;
	
	@Autowired
	private Calculations calculations;
	
	
	public TimeUtilizationData postToDB(TimeUtilizationData model) {
		
		return timeUtilization_repo.save(model);
	}
	
	public List<TimeUtilizationData> getAllDetails(){
		
		return timeUtilization_repo.findAll();
	}
	
	public TimeUtilizationData getDetailByDate(String date){
		
		return timeUtilization_repo.findByDate(date);
	}
	
	public List<TimeUtilizationData> getDetailByWeek(int week){
		
		return timeUtilization_repo.findByWeek(week);
	}
	
	public boolean deleteByDate(String date) {
		
		TimeUtilizationData date_detail = timeUtilization_repo.findByDate(date);
		
		try {
			
			timeUtilization_repo.delete(date_detail);
			
		}catch(Exception ex) {
			
			return false;
		}
		
		return true;
		
	}
	
	public boolean updateByDate(String date, TimeUtilizationData request) {
	
		TimeUtilizationData date_detail = timeUtilization_repo.findByDate(date);
		TimeUtilizationData final_data = new TimeUtilizationData();
		
		if(request.getTotalTasks() != date_detail.getTotalTasks()) {
			final_data.setTotalTasks(request.getTotalTasks());
		}
		else {
			final_data.setTotalTasks(date_detail.getTotalTasks());
		}
		
		if(request.getNoOfTasksDone() != date_detail.getNoOfTasksDone()) {
			final_data.setNoOfTasksDone(request.getNoOfTasksDone());
		}
		else {
			final_data.setNoOfTasksDone(date_detail.getNoOfTasksDone());
		}
		
		if(request.getTotalHoursAllocated() != date_detail.getTotalHoursAllocated()) {
			final_data.setTotalHoursAllocated(request.getTotalHoursAllocated());
		}
		else {
			final_data.setTotalHoursAllocated(date_detail.getTotalHoursAllocated());
		}
		if(request.getTargetHours() != date_detail.getTargetHours()) {
			final_data.setTargetHours(request.getTargetHours());
		}
		else {
			final_data.setTargetHours(date_detail.getTargetHours());
		}
		
		if(request.getTotalHoursUsed() != date_detail.getTotalHoursUsed()) {
			final_data.setTotalHoursUsed(request.getTotalHoursUsed());
		}
		else {
			final_data.setTotalHoursUsed(date_detail.getTotalHoursUsed());
		}
		
		final_data.setId(date_detail.getId());
		
		final_data.setDate(date);
		
		final_data.setPercentage(calculations.percentageOfTimeCovered(final_data.getTotalHoursAllocated(), 
				final_data.getTotalHoursUsed()));
		
		final_data.setHoursWasted(calculations.timeWasted(final_data.getTargetHours(), final_data.getTotalHoursUsed()));
		
		final_data.setWeekNumber(date_detail.getWeekNumber());
		
		try {
			
			timeUtilization_repo.save(final_data);
		}catch(Exception ex) {
			
			return false;
		}
		
		return true;
		
	}
	
}
