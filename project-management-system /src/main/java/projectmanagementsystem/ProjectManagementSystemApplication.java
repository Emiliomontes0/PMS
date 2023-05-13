package projectmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.repository.RequirementRepository;

@SpringBootApplication
public class ProjectManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementSystemApplication.class, args);
	}
	//USES SPRING BOOT TO LAUNCH A LOCAL SERVER WHEN RUNNING MAIN CLASS

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private RequirementRepository requirementRepository;

	@Override
	public void run (String... args)throws  Exception{

	}

}

