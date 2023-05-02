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
    @Column(name = "category")
    private String category;
    @Column(name = "probability")
    private int probability;
    @Column(name = "impact")
    private String impact;
    @Column(name = "mitigation")
    private String mitigation;
    @Column(name = "contingency")
    private String contingency;
    @Column(name = "risk_score")
    private String risk_score;
    @Column(name = "action_by")
    private String action_by;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getMitigation() {
        return mitigation;
    }

    public void setMitigation(String mitigation) {
        this.mitigation = mitigation;
    }

    public String getContingency() {
        return contingency;
    }

    public void setContingency(String contingency) {
        this.contingency = contingency;
    }

    public String getRisk_score() {
        return risk_score;
    }

    public void setRisk_score(String risk_score) {
        this.risk_score = risk_score;
    }

    public String getAction_by() {
        return action_by;
    }

    public void setAction_by(String action_by) {
        this.action_by = action_by;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

