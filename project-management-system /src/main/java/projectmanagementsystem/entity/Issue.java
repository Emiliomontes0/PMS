package projectmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "issue_name", nullable = false)
    private String issue_name;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "project_id", referencedColumnName = "id")//this is correct
    private Project project;

    public Issue(){

    }
    public Issue(String issue_name, String description){
        this.issue_name = issue_name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssue_name() {
        return issue_name;
    }

    public void setIssue_name(String issue_name) {
        this.issue_name = issue_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
