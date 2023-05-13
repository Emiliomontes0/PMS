package projectmanagementsystem.entity;

import jakarta.persistence.*;
//LOOK AT PROJECT CLASS FOR EXPLANATIONS OF ALL CONTEXT
@Entity
@Table(name = "Decision")
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "decision_name", nullable = false)
    private String decision_name;
    @Column(name = "description")
    private String description;
    @Column(name = "date_create")
    private String date_create;
    @Column(name = "date_need")
    private String date_need;
    @Column(name = "date_made")
    private String date_made;
    @Column(name = "decision_maker")
    private String decision_maker;
    @Column(name = "expected_completionDate")
    private String expected_completionDate;
    @Column(name = "actual_completionDate")
    private String actual_completionDate;
    @Column(name = "priority")
    private String priority;
    @Column(name = "impact")
    private String impact;
    @Column(name = "status")
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "project_id", referencedColumnName = "id")//this is correct
    private Project project;

    public Decision (){

    }
    public Decision(String decision_name, String description){
        this.decision_name = decision_name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDecision_name() {
        return decision_name;
    }

    public void setDecision_name(String decision_name) {
        this.decision_name = decision_name;
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

    public String getDate_need() {
        return date_need;
    }

    public void setDate_need(String date_need) {
        this.date_need = date_need;
    }

    public String getDate_made() {
        return date_made;
    }

    public void setDate_made(String date_made) {
        this.date_made = date_made;
    }

    public String getDecision_maker() {
        return decision_maker;
    }

    public void setDecision_maker(String decision_maker) {
        this.decision_maker = decision_maker;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
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
