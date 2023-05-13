package projectmanagementsystem.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
//ALL THE YELLOW TEXT ARE ANNOTATION
//THE PURPOSE OF ANNOTATION EXTRA INFORMATION TO THE COMPILER
@Entity
@Table(name = "project")//ANNOTATION HERE TELL COMPILER TO CREATE A TABLE IN SQL
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//ANNOTATIONS HERE TELLS THE COMPILER THAT ITS IS A ID AND HOW TO GENERATE THE ID
    private long id;

    @Column(name = "pm_name", nullable = false)//CREATE THE COLUMNS IN THE TABLE OF ACTION_ITEMS
    private String pmName;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;

    //ALL LIST BELOW ARE FOR SETTING RELATION BETWEEN FUNCTIONS AND THEY ARE IMPLEMENTED USING AN ARRAYLIST
    @OneToMany(targetEntity = Requirement.class, cascade = CascadeType.ALL)//TARGETS THE FUNCTION AND CREATES A KEY USING JOINCOLUMN
    @JoinColumn(name = "pr_key", referencedColumnName = "id")
    private List<Requirement> assignRequirement = new ArrayList<>();//ALL REQUIREMENT RELATED TO PROJECT ARE STORE HERE WHEN DATA IS TRANSFER FROM THE DATABASE
                                                                    //ALL THE REST OF THE DETAILS BELOW HAVE THE SAME CONTEXT
    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pt_key", referencedColumnName = "id")
    private List<Task> assignTask = new ArrayList<>();
    @OneToMany(targetEntity = Issue.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pi_key", referencedColumnName = "id")
    private List<Issue> assignIssue = new ArrayList<>();
    @OneToMany(targetEntity = Decision.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pd_key", referencedColumnName = "id")
    private List<Decision> assignDecision = new ArrayList<>();
    @OneToMany(targetEntity = Risk.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pri_key", referencedColumnName = "id")
    private List<Risk> assignRisk = new ArrayList<>();
    @OneToMany(targetEntity = Resource.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pre_key", referencedColumnName = "id")
    private List<Resource> assignResource = new ArrayList<>();
    @OneToMany(targetEntity = Action_item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pa_key", referencedColumnName = "id")
    private List<Action_item> assignAction_item = new ArrayList<>();

    //CONSTRUCTOR OF PROJECT CLASS
    public Project(){

    }
    public Project(String pmName, String projectName, String description) {
        super();
        this.pmName = pmName;
        this.projectName = projectName;
        this.description=description;
    }
    //BASIC GETTER AND SETTER METHODS BELOW FOR ALL VARIABLES
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Requirement> getRequirement() {
        return assignRequirement;
    }
    public void assignRequirement(Requirement requirement){
        assignRequirement.add(requirement);
    }

    public List<Action_item> getAssignAction_item() {
        return assignAction_item;
    }
    public void assignAction_item(Action_item action_item){
        assignAction_item.add(action_item);
    }

    public List<Decision> getAssignDecision() {
        return assignDecision;
    }
    public void assignDecision(Decision decision){
        assignDecision.add(decision);
    }

    public List<Task> getAssignTask() {
        return assignTask;
    }
    public void assignTask(Task task){
        assignTask.add(task);
    }

    public List<Issue> getAssignIssue() {
        return assignIssue;
    }
    public void assignIssue (Issue issue){
        assignIssue.add(issue);
    }

    public List<Risk> getAssignRisk() {
        return assignRisk;
    }
    public void assignRisk(Risk risk){
        assignRisk.add(risk);
    }

    public List<Resource> getAssignResource() {
        return assignResource;
    }
    public void assignResource(Resource resource){
        assignResource.add(resource);
    }
}
