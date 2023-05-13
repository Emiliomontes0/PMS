package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.Risk;
//THE MAIN PURPOSE OF REPOSITORY FILE IS TO TALK TO THE DATABASE AND IT HAS AUTOMATICALLY CREATED
//FUNCTIONS FOR COMMUNICATION WITH DATABASE VIA JPA LIBRARY
public interface RiskRepository extends JpaRepository<Risk, Long> {
}
