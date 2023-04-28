package projectmanagementsystem.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Requirements")
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "req_name", nullable = false)
    private String req_name;
    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)//this is correct
    @JoinColumn(name = "project_id", referencedColumnName = "id")//this is correct
    private Project project;

    public Requirement(){

    }
    public Requirement( String req_name, String description) {
        super();
        this.req_name = req_name;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReq_name() {
        return req_name;
    }

    public void setReq_name(String req_name) {
        this.req_name = req_name;
    }
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
