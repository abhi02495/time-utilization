package abhishek2495.com.timeutilization.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import abhishek2495.com.timeutilization.model.TimeUtilizationData;

@Repository
public interface TimeUtilizationRepository extends MongoRepository<TimeUtilizationData, ObjectId>{

	@Query(value= "{'date': ?0}")
	TimeUtilizationData findByDate(String date);
	
	@Query(value= "{'week_no': ?0}")
	List<TimeUtilizationData> findByWeek(int week);
}
