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
    @OneToMany(targetEntity = Requirement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pr_key", referencedColumnName = "id")//current issue is that pr_key is null and fix update and delete
    private List<Requirement> requirement = new ArrayList<>();

    public List<Requirement> getRequirement() {
        return requirement;
    }

    public void setRequirement(List<Requirement> requirement) {
        this.requirement = requirement;
    }

    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pt_key", referencedColumnName = "id")
    private List<Task> task;
    @OneToMany(targetEntity = Issue.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pi_key", referencedColumnName = "id")
    private List<Issue> issue;
    @OneToMany(targetEntity = Decision.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pd_key", referencedColumnName = "id")
    private List<Decision> decision;
    @OneToMany(targetEntity = Risk.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pri_key", referencedColumnName = "id")
    private List<Risk> risk;
    @OneToMany(targetEntity = Resource.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pre_key", referencedColumnName = "id")
    private List<Resource> resource;
    @OneToMany(targetEntity = Action_item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pa_key", referencedColumnName = "id")
    private List<Action_item> action_item;


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




}
