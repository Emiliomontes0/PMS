package projectmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Risk")
public class Risk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "risk_name", nullable = false)
    private String risk_name;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "project_id", referencedColumnName = "id")//this is correct
    private Project project;
    public Risk(){

    }
    public Risk(String risk_name, String description){
        this.risk_name=risk_name;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRisk_name() {
        return risk_name;
    }

    public void setRisk_name(String risk_name) {
        this.risk_name = risk_name;
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

