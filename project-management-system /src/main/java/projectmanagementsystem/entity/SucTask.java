package projectmanagementsystem.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "SucTask")
public class SucTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name", nullable = false)
    private String preTask_name;
    @Column(name = "description")
    private String description;
    @Column(name = "date_created")
    private String date_created;
    @Column(name = "date_end")
    private String date_end;
    @Column(name = "actual_dateCreated")
    private String actual_dateCreated;
    @Column(name = "actual_dateEnded")
    private String actual_dateEnded;
    @Column(name = "resource_assign")
    private String resource_assign;
    @Column(name = "expected_duration")
    private String expected_duration;
    @Column(name = "actual_duration")
    private String actual_duration;
    @Column(name = "expected_effort")
    private Long expected_effort;
    @Column(name = "actual_effort")
    private Long actual_effort;
    @Column(name = "status")
    private String status;

    //pred task and succesor from update task button and move to its own page
    @ManyToOne(cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "task_id", referencedColumnName = "id")//this is correct
    private Task task;
    public SucTask(){

    }
    public SucTask(String task_name, String description, String date_end, String date_created, String
            actual_dateCreated, String actual_dateEnded, String resource_assign, String expected_duration,
                   String actual_duration, Long expected_effort, Long actual_effort, String status) {
        super();
        this.preTask_name = task_name;
        this.description=description;
        this.date_end = date_end;
        this.date_created = date_created;
        this.actual_dateCreated = actual_dateCreated;
        this.actual_dateEnded = actual_dateEnded;
        this.resource_assign = resource_assign;
        this.expected_duration = expected_duration;
        this.actual_duration = actual_duration;
        this.expected_effort = expected_effort;
        this.actual_effort = actual_effort;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask_name() {
        return preTask_name;
    }

    public void setTask_name(String task_name) {
        this.preTask_name = task_name;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getActual_dateCreated() {
        return actual_dateCreated;
    }

    public void setActual_dateCreated(String actual_dateCreated) {
        this.actual_dateCreated = actual_dateCreated;
    }

    public String getActual_dateEnded() {
        return actual_dateEnded;
    }

    public void setActual_dateEnded(String actual_dateEnded) {
        this.actual_dateEnded = actual_dateEnded;
    }

    public String getResource_assign() {
        return resource_assign;
    }

    public void setResource_assign(String resource_assign) {
        this.resource_assign = resource_assign;
    }

    public String getExpected_duration() {
        return expected_duration;
    }

    public void setExpected_duration(String expected_duration) {
        this.expected_duration = expected_duration;
    }

    public String getActual_duration() {
        return actual_duration;
    }

    public void setActual_duration(String actual_duration) {
        this.actual_duration = actual_duration;
    }

    public Long getExpected_effort() {
        return expected_effort;
    }

    public void setExpected_effort(Long expected_effort) {
        this.expected_effort = expected_effort;
    }

    public Long getActual_effort() {
        return actual_effort;
    }

    public void setActual_effort(Long actual_effort) {
        this.actual_effort = actual_effort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
