package projectmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "resource_name", nullable = false)
    private String resource_name;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "project_id", referencedColumnName = "id")//this is correct
    private Project project;



    public Resource(){

    }
    public Resource(String resource_name, String description){
        this.resource_name = resource_name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResource_name() {
        return resource_name;
    }

    public void setResource_name(String resource_name) {
        this.resource_name = resource_name;
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
