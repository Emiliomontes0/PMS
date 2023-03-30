package projectmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Action_item")
public class Action_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "action_name", nullable = false)
    private String action_name;
    @Column(name = "description")
    private String description;
    public Action_item(){

    }
    public Action_item(String action_name, String description){
        super();
        this.action_name = action_name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
