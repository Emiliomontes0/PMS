package projectmanagementsystem.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name = "project")
public class Project {
    //creating table in database using java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pm_name", nullable = false)
    private String pmName;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "description")
    private String description;



    @OneToMany(targetEntity = Requirement.class, cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "pr_key", referencedColumnName = "id")//this is correct
    private List<Requirement> assignRequirement = new ArrayList<>();

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


    public Project(){

    }
    public Project(String pmName, String projectName, String description) {
        super();
        this.pmName = pmName;
        this.projectName = projectName;
        this.description=description;
    }

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
