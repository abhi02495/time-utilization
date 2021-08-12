package abhishek2495.com.timeutilization;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import abhishek2495.com.timeutilization.model.TimeUtilizationData;
import abhishek2495.com.timeutilization.request.TimeUtilizationRequest;
import abhishek2495.com.timeutilization.response.ResponseMessage;
import abhishek2495.com.timeutilization.service.Calculations;
import abhishek2495.com.timeutilization.service.DateWeekCalculationService;
import abhishek2495.com.timeutilization.service.TimeUtilizationService;

@RestController
public class TimeUtilizationController {
	
	public TimeUtilizationController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private TimeUtilizationService service;
	
	@Autowired
	private DateWeekCalculationService dateWeek_service;
	
	@Autowired
	private Calculations calculations;
	
	
	//POST THE DETAIL OF A DAY
	
	@RequestMapping("/api/v1/data")
	public ResponseMessage postItem(@RequestBody TimeUtilizationRequest model) {
		
		TimeUtilizationData data = new TimeUtilizationData();
		data.setDate(model.getDate());
		data.setTotalHoursAllocated(model.getTotalHoursAllocated());
		data.setTotalHoursUsed(model.getTotalHoursUsed());
		data.setTargetHours(model.getTargetHours());
		data.setTotalTasks(model.getTotalTasks());
		data.setNoOfTasksDone(model.getNoOfTasksDone());
		data.setWeekNumber(dateWeek_service.getWeek(model.getDate()));
		data.setPercentage(calculations.percentageOfTimeCovered(model.getTotalHoursAllocated(), model.getTotalHoursUsed()));
		data.setHoursWasted(calculations.timeWasted(model.getTargetHours(), model.getTotalHoursUsed()));
		
		ResponseMessage message = new ResponseMessage();
		
		try {
			
			service.postToDB(data);
			
		}catch(Exception ex) {
			
			System.out.println("some error " + ex);
			message.setResponseCode(500);
			message.setResponseMessage("Not able to insert the Data... Please try again");
			return message;
		}
		
		message.setResponseCode(200);
		message.setResponseMessage("Data successfully inserted");
		return message;
	}
	
	
	//GET ALL THE DETAILS
	
	@RequestMapping("/api/v1/alldetails")
	public List<TimeUtilizationData> getItems() {
		return service.getAllDetails();
	}
	
	
	//GET DETAIL BY DATE
	
	@RequestMapping("/api/v1/date")
	public ResponseEntity<TimeUtilizationData> getDetailByDate(@RequestParam("date") String date){
		TimeUtilizationData data_byDate = new TimeUtilizationData();
		data_byDate = service.getDetailByDate(date);
		
		if(data_byDate == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(data_byDate);
	}
	
	
	//GET DETAIL BY WEEK
	
	@RequestMapping("/api/v1/week")
	public ResponseEntity<List<TimeUtilizationData>> getDetailByWeek(@RequestParam("week") int week){
		List<TimeUtilizationData> data_byWeek = new ArrayList<TimeUtilizationData>();
		data_byWeek = service.getDetailByWeek(week);
		
		if(data_byWeek.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(data_byWeek);
	}
	
	
	// UPDATE BY DATE
	
	@RequestMapping("api/v1/{date}/update")
	public ResponseMessage updateByDate(@PathVariable("date") String date, @RequestBody TimeUtilizationData request) {
		
		boolean updated = service.updateByDate(date, request);
		ResponseMessage message = new ResponseMessage();
		
		if(updated == true) {
			message.setResponseCode(200);
			message.setResponseMessage("Updated successfully");
		}
		else {
			message.setResponseCode(500);
			message.setResponseMessage("Not updated... please try again!");
		}
		
		return message;
	}
	
	
	//DELETE BY DATE
	
	@RequestMapping("api/v1/{date}/delete")
	public ResponseMessage deleteByDate(@PathVariable("date") String date) {
		
		ResponseMessage message = new ResponseMessage();
		
		boolean delete_detail = service.deleteByDate(date);
		
		if(delete_detail) {
			
			message.setResponseCode(200);
			message.setResponseMessage("Delete successful");
		}
		else {
			
			message.setResponseCode(500);
			message.setResponseMessage("Something went wrong... Please try again");
		}
		
		return message;
	}

	@RequestMapping("api/v1/dummy")
	public String returnSomething(){
		return "Abhishek";
	}
}
