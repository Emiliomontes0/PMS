package projectmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Task;
import projectmanagementsystem.entity.Action_item;
import projectmanagementsystem.entity.Issue;
import projectmanagementsystem.entity.Resource;
import projectmanagementsystem.entity.Decision;
import projectmanagementsystem.entity.Risk;
import projectmanagementsystem.service.RiskService;
import projectmanagementsystem.service.TaskService;
import projectmanagementsystem.service.Action_itemService;
import projectmanagementsystem.service.IssueService;
import projectmanagementsystem.service.ResourceService;
import projectmanagementsystem.service.DecisionService;
import projectmanagementsystem.service.ProjectService;
import projectmanagementsystem.service.RequirementService;

import javax.swing.*;

@Controller
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects";
    }

    @GetMapping("/projects/new")
    public String createProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "create_project";
    }

    @PostMapping("/projects")
    public String saveProject(@ModelAttribute("project") Project project) {
        projectService.saveProjects(project);
        return "redirect:/projects";

    }

    @GetMapping("/projects/edit/{id}")
    public String editProjectForm(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        return "edit_project";
    }

    @PostMapping("/projects/{id}")
    public String updateProject(@PathVariable Long id,
                                @ModelAttribute("project") Project project, Model model) {

        Project existingProject = projectService.getProjectById(id);
        existingProject.setId(id);
        existingProject.setPmName(project.getPmName());
        existingProject.setProjectName(project.getProjectName());
        existingProject.setDescription(project.getDescription());

        projectService.updateProject(existingProject);
        return "redirect:/projects";
    }

    @GetMapping("/projects/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProjectById(id);
        return "redirect:/projects";

    }


    @Controller
    public class RequirementController {
        private RequirementService requirementService;

        public RequirementController(RequirementService requirementService) {
            super();
            this.requirementService = requirementService;
        }

        @GetMapping("/projects/edit/requirements")//path
        public String listRequirements(Model model) {
            model.addAttribute("requirements", requirementService.getAllRequirements());
            return "Requirements";
        }

        @GetMapping("/projects/edit/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/edit/requirements")
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);
            return "redirect:/projects/edit/requirements";//return page

        }


        @GetMapping("/projects/edit/requirements/edit/{id}")
        public String editRequirementForm(@PathVariable Long id, Model model) {
            model.addAttribute("requirement", requirementService.getRequirementById(id));
            return "edit_requirement";
        }


        @PostMapping("/projects/edit/requirements/edit/{id}")
        public String updateRequirement(@PathVariable Long id,
                                        @ModelAttribute("requirement") Requirement requirement, Model model) {

            Requirement existingRequirement = requirementService.getRequirementById(id);
            existingRequirement.setId(id);
            existingRequirement.setReq_name(requirement.getReq_name());
            existingRequirement.setDescription(requirement.getDescription());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/edit/requirements";
        }


        @GetMapping("/projects/edit/requirements/{id}")//getting pathing of new requirements
        public String deleteRequirement(@PathVariable Long id) {
            requirementService.deleteRequirementById(id);
            return "redirect:/projects/edit/requirements";

        }
    }

    @Controller
    public class TaskController {
        private TaskService taskService;

        public TaskController(TaskService taskService) {
            super();
            this.taskService = taskService;
        }

        @GetMapping("/projects/edit/tasks")//path
        public String listTasks(Model model) {
            model.addAttribute("tasks", taskService.getAllTasks());
            return "Tasks";
        }


        @GetMapping("/projects/edit/tasks/new")//path context
        public String createTaskForm(Model model) {
            Task task = new Task();
            model.addAttribute("task", task);
            return "create_task";//path
        }

        @PostMapping("/projects/edit/tasks")
        public String saveTask(@ModelAttribute("task") Task task) {
            taskService.saveTasks(task);
            return "redirect:/projects/edit/tasks";//return page

        }


        @GetMapping("/projects/edit/tasks/edit/{id}")
        public String editTaskForm(@PathVariable Long id, Model model) {
            model.addAttribute("task", taskService.getTaskById(id));
            return "edit_task";
        }



        @PostMapping("/projects/edit/tasks/edit/{id}")
        public String updateTask(@PathVariable Long id,
                                        @ModelAttribute("task") Task task, Model model) {

            Task existingTask = taskService.getTaskById(id);
            existingTask.setId(id);
            existingTask.setTask_name(task.getTask_name());
            existingTask.setDescription(task.getDescription());

            taskService.updateTask(existingTask);
            return "redirect:/projects/edit/tasks";
        }


        @GetMapping("/projects/edit/tasks/{id}")//getting pathing of new requirements
        public String deleteTask(@PathVariable Long id){
            taskService.deleteTaskById(id);
            return "redirect:/projects/edit/requirements";

        }
    }


    @Controller
    public class Action_itemController {
        private Action_itemService action_itemService;

        public Action_itemController(Action_itemService action_itemService) {
            super();
            this.action_itemService = action_itemService;
        }

        @GetMapping("/projects/edit/action_items")//path
        public String listAction_items(Model model) {
            model.addAttribute("action_items", action_itemService.getAllAction_items());
            return "Action_items";

        }


        @GetMapping("/projects/edit/action_items/new")//path context
        public String createAction_itemForm(Model model) {
            Action_item action_item = new Action_item();
            model.addAttribute("action_item", action_item);
            return "create_action_item";//path
        }

        @PostMapping("/projects/edit/action_items")
        public String saveAction_item(@ModelAttribute("action_item") Action_item action_item) {
            action_itemService.saveAction_items(action_item);
            return "redirect:/projects/edit/action_items";//return page

        }




        @GetMapping("/projects/edit/action_items/edit/{id}")
        public String editAction_itemForm(@PathVariable Long id, Model model) {
            model.addAttribute("action_item", action_itemService.getAction_itemById(id));
            return "edit_action_item";
        }



        @PostMapping("/projects/edit/action_items/edit/{id}")
        public String updateAction_item(@PathVariable Long id,
                                        @ModelAttribute("action_item") Action_item action_item, Model model) {

            Action_item existingAction_item = action_itemService.getAction_itemById(id);
            existingAction_item.setId(id);
            existingAction_item.setAction_item_name(action_item.getAction_item_name());
            existingAction_item.setDescription(action_item.getDescription());

            action_itemService.updateAction_item(existingAction_item);
            return "redirect:/projects/edit/action_items";
        }


        @GetMapping("/projects/edit/action_items/{id}")//getting pathing of new requirements
        public String deleteAction_item(@PathVariable Long id){
            action_itemService.deleteAction_itemById(id);
            return "redirect:/projects/edit/action_items";

        }
    }

    @Controller
    public class IssueController {
        private IssueService issueService;

        public IssueController(IssueService issueService) {
            super();
            this.issueService = issueService;
        }

        @GetMapping("/projects/edit/issues")//path
        public String listIssues(Model model) {
            model.addAttribute("issues", issueService.getAllIssues());
            return "Issues";
        }


        @GetMapping("/projects/edit/issues/new")//path context
        public String createIssueForm(Model model) {
            Issue issue = new Issue();
            model.addAttribute("issue", issue);
            return "create_issue";//path
        }

        @PostMapping("/projects/edit/issues")
        public String saveIssue(@ModelAttribute("issue") Issue issue) {
            issueService.saveIssues(issue);
            return "redirect:/projects/edit/issues";//return page

        }

        @GetMapping("/projects/edit/issues/edit/{id}")
        public String editIssueForm(@PathVariable Long id, Model model) {
            model.addAttribute("issue", issueService.getIssueById(id));
            return "edit_issue";
        }



        @PostMapping("/projects/edit/issues/edit/{id}")
        public String updateIssue(@PathVariable Long id,
                                        @ModelAttribute("issue") Issue issue, Model model) {

            Issue existingIssue = issueService.getIssueById(id);
            existingIssue.setId(id);
            existingIssue.setIssue_name(issue.getIssue_name());
            existingIssue.setDescription(issue.getDescription());

            issueService.updateIssue(existingIssue);
            return "redirect:/projects/edit/issues";
        }


        @GetMapping("/projects/edit/issues/{id}")//getting pathing of new requirements
        public String deleteIssue(@PathVariable Long id){
            issueService.deleteIssueById(id);
            return "redirect:/projects/edit/issues";

        }
    }

    @Controller
    public class DecisionController {
        private DecisionService decisionService;

        public DecisionController(DecisionService decisionService) {
            super();
            this.decisionService = decisionService;
        }

        @GetMapping("/projects/edit/decisions")//path
        public String listRequirements(Model model) {
            model.addAttribute("decisions", decisionService.getAllDecisions());
            return "Decisions";
        }


        @GetMapping("/projects/edit/decisions/new")//path context
        public String createDecisionForm(Model model) {
            Decision decision = new Decision();
            model.addAttribute("decision", decision);
            return "create_decision";//path
        }

        @PostMapping("/projects/edit/decisions")
        public String saveDecision(@ModelAttribute("decision") Decision decision) {
            decisionService.saveDecisions(decision);
            return "redirect:/projects/edit/decisions";//return page

        }


        @GetMapping("/projects/edit/decisions/edit/{id}")
        public String editDecisionForm(@PathVariable Long id, Model model) {
            model.addAttribute("decision", decisionService.getDecisionById(id));
            return "edit_decision";
        }



        @PostMapping("/projects/edit/decisions/edit/{id}")
        public String updateDecision(@PathVariable Long id,
                                        @ModelAttribute("decision") Decision decision, Model model) {

            Decision existingDecision = decisionService.getDecisionById(id);
            existingDecision.setId(id);
            existingDecision.setDecision_name(decision.getDecision_name());
            existingDecision.setDescription(decision.getDescription());

            decisionService.updateDecision(existingDecision);
            return "redirect:/projects/edit/decisions";
        }


        @GetMapping("/projects/edit/decisions/{id}")//getting pathing of new requirements
        public String deleteDecision(@PathVariable Long id){
            decisionService.deleteDecisionById(id);
            return "redirect:/projects/edit/decisions";

        }
    }


    @Controller
    public class ResourceController {
        private ResourceService resourceService;

        public ResourceController(ResourceService resourceService) {
            super();
            this.resourceService = resourceService;
        }

        @GetMapping("/projects/edit/resources")//path
        public String listRequirements(Model model) {
            model.addAttribute("resources", resourceService.getAllResources());
            return "Resources";
        }



        @GetMapping("/projects/edit/resources/new")//path context
        public String createResourceForm(Model model) {
            Resource resource = new Resource();
            model.addAttribute("resource", resource);
            return "create_resource";//path
        }

        @PostMapping("/projects/edit/resources")
        public String saveResource(@ModelAttribute("resource") Resource resource) {
            resourceService.saveResources(resource);
            return "redirect:/projects/edit/resources";//return page

        }


        @GetMapping("/projects/edit/resources/edit/{id}")
        public String editResourceForm(@PathVariable Long id, Model model) {
            model.addAttribute("resource", resourceService.getResourceById(id));
            return "edit_resource";
        }



        @PostMapping("/projects/edit/resources/edit/{id}")
        public String updateResource(@PathVariable Long id,
                                        @ModelAttribute("resource") Resource resource, Model model) {

            Resource existingResource = resourceService.getResourceById(id);
            existingResource.setId(id);
            existingResource.setResource_name(resource.getResource_name());
            existingResource.setDescription(resource.getDescription());

            resourceService.updateResource(existingResource);
            return "redirect:/projects/edit/resources";
        }


        @GetMapping("/projects/edit/resources/{id}")//getting pathing of new requirements
        public String deleteResource(@PathVariable Long id){
            resourceService.deleteResourceById(id);
            return "redirect:/projects/edit/resources";

        }
    }

    @Controller
    public class RiskController {
        private RiskService riskService;

        public RiskController(RiskService riskService) {
            super();
            this.riskService = riskService;
        }

        @GetMapping("/projects/edit/risks")//path
        public String listRisks(Model model) {
            model.addAttribute("risks", riskService.getAllRisks());
            return "Risks";
        }


        @GetMapping("/projects/edit/risks/new")//path context
        public String createRiskForm(Model model) {
            Risk risk = new Risk();
            model.addAttribute("risk", risk);
            return "create_risk";//path
        }

        @PostMapping("/projects/edit/risks")
        public String saveRisk(@ModelAttribute("risk") Risk risk) {
            riskService.saveRisks(risk);
            return "redirect:/projects/edit/risks";//return page

        }

        @GetMapping("/projects/edit/risks/edit/{id}")
        public String editRiskForm(@PathVariable Long id, Model model) {
            model.addAttribute("risk", riskService.getRiskById(id));
            return "edit_risk";
        }


        @PostMapping("/projects/edit/risks/edit/{id}")
        public String updateRisk(@PathVariable Long id,
                                        @ModelAttribute("risk") Risk risk, Model model) {

            Risk existingRisk = riskService.getRiskById(id);
            existingRisk.setId(id);
            existingRisk.setRisk_name(risk.getRisk_name());
            existingRisk.setDescription(risk.getDescription());

            riskService.updateRisk(existingRisk);
            return "redirect:/projects/edit/risks";
        }


        @GetMapping("/projects/edit/risks/{id}")//getting pathing of new requirements
        public String deleteRisk(@PathVariable Long id) {
            riskService.deleteRiskById(id);
            return "redirect:/projects/edit/risks";

        }
    }
}