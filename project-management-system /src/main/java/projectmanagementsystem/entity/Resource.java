package projectmanagementsystem.entity;

import jakarta.persistence.*;
//LOOK AT PROJECT.JAVA FOR EXPLANATION FOR ALL CONTEXT
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
    @Column(name = "title")
    private String title;
    @Column(name = "pay_rate")
    private Double pay_rate;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPay_rate() {
        return pay_rate;
    }

    public void setPay_rate(Double pay_rate) {
        this.pay_rate = pay_rate;
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
}
