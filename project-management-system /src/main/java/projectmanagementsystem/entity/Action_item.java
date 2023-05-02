package projectmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Action_item")
public class Action_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "action_name", nullable = false)
    private String action_item_name;
    @Column(name = "description")
    private String description;
    @Column(name = "date_created")
    private String date_create;
    @Column(name = "date_assign")
    private String date_assign;
    @Column(name = "expected_completionDate")
    private String expected_completionDate;
    @Column(name = "actual_completionDate")
    private String actual_completionDate;
    @Column(name = "resource_assign")
    private String resource_assign;
    @Column(name = "status")
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "project_id", referencedColumnName = "id")//this is correct
    private Project project;

    public Action_item(){

    }
    public Action_item(String action_item_name, String description){
        super();
        this.action_item_name = action_item_name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction_item_name() {
        return action_item_name;
    }

    public void setAction_item_name(String action_item_name) {
        this.action_item_name = action_item_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getDate_assign() {
        return date_assign;
    }

    public void setDate_assign(String date_assign) {
        this.date_assign = date_assign;
    }

    public String getExpected_completionDate() {
        return expected_completionDate;
    }

    public void setExpected_completionDate(String expected_completionDate) {
        this.expected_completionDate = expected_completionDate;
    }

    public String getActual_completionDate() {
        return actual_completionDate;
    }

    public void setActual_completionDate(String actual_completionDate) {
        this.actual_completionDate = actual_completionDate;
    }

    public String getResource_assign() {
        return resource_assign;
    }

    public void setResource_assign(String resource_assign) {
        this.resource_assign = resource_assign;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
