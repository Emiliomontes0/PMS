package projectmanagementsystem.entity;

import jakarta.persistence.*;

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
}
