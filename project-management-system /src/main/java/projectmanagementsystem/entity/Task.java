package projectmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name", nullable = false)
    private String task_name;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "project_id", referencedColumnName = "id")//this is correct
    private Project project;
    public Task(){

    }
    public Task( String task_name, String description) {
        super();
        this.task_name = task_name;
        this.description=description;
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
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
