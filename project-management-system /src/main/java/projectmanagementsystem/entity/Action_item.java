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
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
