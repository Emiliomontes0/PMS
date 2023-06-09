package projectmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Task;
import projectmanagementsystem.entity.Action_item;
import projectmanagementsystem.entity.Issue;
import projectmanagementsystem.entity.Resource;
import projectmanagementsystem.entity.Decision;
import projectmanagementsystem.entity.Risk;
import projectmanagementsystem.entity.PreTask;
import projectmanagementsystem.entity.SucTask;
import projectmanagementsystem.service.RiskService;
import projectmanagementsystem.service.TaskService;
import projectmanagementsystem.service.Action_itemService;
import projectmanagementsystem.service.IssueService;
import projectmanagementsystem.service.ResourceService;
import projectmanagementsystem.service.DecisionService;
import projectmanagementsystem.service.ProjectService;
import projectmanagementsystem.service.RequirementService;
import projectmanagementsystem.service.PreTaskService;
import projectmanagementsystem.service.SucTaskService;


//this is the main class that connect with the UI and processes request from the User

@Controller
public class ProjectController {
    private Long pid; // to save project Id While modify other functions with a project
    private Long tid;

    public Long getId() {
        return pid;
    }

    public void setId(Long pid) {
        this.pid = pid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @GetMapping("/projects")//gets the mapping from the UI
    public String listProjects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects";
    }

    @GetMapping("/projects/new")// Gets mapping for creating a new project
    public String createProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "create_project";
    }

    @PostMapping("/projects")//Save project that was created in the new projects
    public String saveProject(@ModelAttribute("project") Project project) {
        projectService.saveProjects(project);
        return "redirect:/projects";

    }

    @GetMapping("/projects/edit/{id}")//gets the id of the project to modify it
    public String editProjectForm(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getProjectById(id));
        this.pid = id;//saves the project id For later uses to keep new data relational
        return "edit_project";//file of where the edit proccess is contain
    }

    @PostMapping("/projects/{id}")//grabs all attributes of the secleted object and displays it to the user which also allows user to modify attributs
    public String updateProject(@PathVariable Long id,
                                @ModelAttribute("project") Project project, Model model) {

        Project existingProject = projectService.getProjectById(id);
        existingProject.setId(id);
        existingProject.setPmName(project.getPmName());
        existingProject.setProjectName(project.getProjectName());
        existingProject.setDescription(project.getDescription());
        existingProject.setStatus(project.getStatus());
        pid = null;
        projectService.updateProject(existingProject);//method use to save project in the database
        return "redirect:/projects";//Once the modifacations are completed it returns back to the display page
    }

    @GetMapping("/projects/{id}")//grabs id of the selected project to delete all data related to it
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
            model.addAttribute("requirements", requirementService.getAllRequirementsById(pid));
            return "Requirements";
        }

        @GetMapping("/projects/edit/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/edit/requirements")//The Location in which the information is posted
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);//saves the requirement to requirement table
            Project project = projectService.getProjectById(pid);
            project.assignRequirement(requirement);//assign requirement to the project and saves it in a List
            projectService.updateProject(project);
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
            existingRequirement.setSource_doc(requirement.getSource_doc());
            existingRequirement.setLocation_sourceDoc(requirement.getLocation_sourceDoc());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/edit/requirements";
        }


        @GetMapping("/projects/edit/requirements/{id}")
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
            model.addAttribute("tasks", taskService.getAllTasksById(pid));
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
            Project project = projectService.getProjectById(pid);
            project.assignTask(task);
            projectService.updateProject(project);
            return "redirect:/projects/edit/tasks";//return page

        }


        @GetMapping("/projects/edit/tasks/edit/{id}")
        public String editTaskForm(@PathVariable Long id, Model model) {
            model.addAttribute("task", taskService.getTaskById(id));
            tid = id;
            return "edit_task";
        }



        @PostMapping("/projects/edit/tasks/edit/{id}")
        public String updateTask(@PathVariable Long id,
                                        @ModelAttribute("task") Task task, Model model) {

            Task existingTask = taskService.getTaskById(id);
            existingTask.setId(id);
            existingTask.setTask_name(task.getTask_name());
            existingTask.setDescription(task.getDescription());
            existingTask.setDate_created(task.getDate_created());
            existingTask.setActual_dateCreated(task.getActual_dateCreated());
            existingTask.setDate_end(task.getDate_end());
            existingTask.setActual_dateEnded(task.getActual_dateEnded());
            existingTask.setExpected_duration(task.getExpected_duration());
            existingTask.setActual_duration(task.getActual_duration());
            existingTask.setExpected_effort(task.getExpected_effort());
            existingTask.setActual_effort(task.getActual_effort());
            existingTask.setResource_assign(task.getResource_assign());
            existingTask.setStatus(task.getStatus());

            taskService.updateTask(existingTask);
            tid = null;
            return "redirect:/projects/edit/tasks";
        }


        @GetMapping("/projects/edit/tasks/{id}")//getting pathing of new requirements
        public String deleteTask(@PathVariable Long id){
            taskService.deleteTaskById(id);
            return "redirect:/projects/edit/tasks";

        }
    }
    @Controller
    public class PreTaskController {// here is the code for the predesuccors task but was not able to make it functional
        private PreTaskService pretaskService;
        private TaskService taskService;
        public PreTaskController(PreTaskService pretaskService, TaskService taskservice) {
            super();
            this.pretaskService = pretaskService;
            this.taskService = taskservice;
        }

        @GetMapping("/projects/edit/tasks/preTask")//path
        public String listTasks(Model model) {
            model.addAttribute("task", taskService.getAllTasks());
            return "PreTasks";
        }


        @GetMapping("/projects/edit/tasks/preTask/new")//path context
        public String createTaskForm(Model model) {
            PreTask preTask = new PreTask();
            model.addAttribute("preTask", preTask);
            return "create_pretask";//path
        }

        @PostMapping("/projects/edit/tasks/preTask")
        public String saveTask(@ModelAttribute("task") PreTask pretask) {
            pretaskService.saveTasks(pretask);
            System.out.println(tid);
            Task task = taskService.getTaskById(tid);//this is null current issue
            task.assignPreTask(pretask);
            taskService.updateTask(task);
            return "redirect:/projects/edit/tasks/preTask";//return page

        }


        @GetMapping("/projects/edit/tasks/preTask/{id}")
        public String editTaskForm(@PathVariable Long id, Model model) {
            model.addAttribute("pretask", pretaskService.getTaskById(id));
            return "edit_pretask";
        }



        @PostMapping("/projects/edit/tasks/preTask/{id}")
        public String updateTask(@PathVariable Long id,
                                 @ModelAttribute("pretask") PreTask preTask, Model model) {

            PreTask existingTask = pretaskService.getTaskById(id);
            existingTask.setId(id);
            existingTask.setTask_name(preTask.getTask_name());
            existingTask.setDescription(preTask.getDescription());
            existingTask.setDate_created(preTask.getDate_created());
            existingTask.setActual_dateCreated(preTask.getActual_dateCreated());
            existingTask.setDate_end(preTask.getDate_end());
            existingTask.setActual_dateEnded(preTask.getActual_dateEnded());
            existingTask.setExpected_duration(preTask.getExpected_duration());
            existingTask.setActual_duration(preTask.getActual_duration());
            existingTask.setExpected_effort(preTask.getExpected_effort());
            existingTask.setActual_effort(preTask.getActual_effort());
            existingTask.setResource_assign(preTask.getResource_assign());
            existingTask.setStatus(preTask.getStatus());

            pretaskService.updateTask(existingTask);
            return "redirect:/projects/edit/tasks/preTask";
        }

    /* issue here
        @GetMapping("/projects/edit/tasks/preTask/{id}")//getting pathing of new requirements
        public String deleteTask(@PathVariable Long id){
            pretaskService.deleteTaskById(id);
            return "redirect:/projects/edit/tasks/preTask";

        }
        */
    }

    @Controller
    public class SucTaskController {//Code for the successor Task but was not able to get it functional
        private SucTaskService suctaskService;
        private TaskService taskService;
        public SucTaskController(SucTaskService suctaskService) {
            super();
            this.suctaskService = suctaskService;
        }

        @GetMapping("/projects/edit/tasks/sucTask")//path
        public String listTasks(Model model) {
            model.addAttribute("tasks", suctaskService.getAllTasksById(tid));
            return "SucTasks";
        }


        @GetMapping("/projects/edit/tasks/sucTask/new")//path context
        public String createTaskForm(Model model) {
            SucTask suctask = new SucTask();
            model.addAttribute("task", suctask);
            return "create_suctask";//path
        }

        @PostMapping("/projects/edit/tasks/sucTask")
        public String saveTask(@ModelAttribute("task") SucTask suctask) {
            suctaskService.saveTasks(suctask);
            Task task = taskService.getTaskById(tid);
            task.assignSucTask(suctask);
            taskService.updateTask(task);
            return "redirect:/projects/edit/tasks/sucTask";//return page

        }


        @GetMapping("/projects/edit/tasks/sucTask/{id}")
        public String editTaskForm(@PathVariable Long id, Model model) {
            model.addAttribute("task", suctaskService.getTaskById(id));
            return "edit_sucTask";
        }



        @PostMapping("/projects/edit/tasks/sucTask/{id}")
        public String updateTask(@PathVariable Long id,
                                 @ModelAttribute("task") SucTask sucTask, Model model) {

            SucTask existingTask = suctaskService.getTaskById(id);
            existingTask.setId(id);
            existingTask.setTask_name(sucTask.getTask_name());
            existingTask.setDescription(sucTask.getDescription());
            existingTask.setDate_created(sucTask.getDate_created());
            existingTask.setActual_dateCreated(sucTask.getActual_dateCreated());
            existingTask.setDate_end(sucTask.getDate_end());
            existingTask.setActual_dateEnded(sucTask.getActual_dateEnded());
            existingTask.setExpected_duration(sucTask.getExpected_duration());
            existingTask.setActual_duration(sucTask.getActual_duration());
            existingTask.setExpected_effort(sucTask.getExpected_effort());
            existingTask.setActual_effort(sucTask.getActual_effort());
            existingTask.setResource_assign(sucTask.getResource_assign());
            existingTask.setStatus(sucTask.getStatus());


            suctaskService.updateTask(existingTask);
            return "redirect:/projects/edit/tasks/sucTask";
        }

        /*
        @GetMapping("/projects/edit/tasks/sucTask/{id}")//getting pathing of new requirements
        public String deleteTask(@PathVariable Long id){
            suctaskService.deleteTaskById(id);
            return "redirect:/projects/edit/tasks/sucTask";

        }
         */
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
            model.addAttribute("action_items", action_itemService.getAllAction_itemsById(pid));
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
            Project project = projectService.getProjectById(pid);
            project.assignAction_item(action_item);
            projectService.updateProject(project);
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
            existingAction_item.setDate_create(action_item.getDate_create());
            existingAction_item.setDate_assign(action_item.getDate_assign());
            existingAction_item.setResource_assign(action_item.getResource_assign());
            existingAction_item.setExpected_completionDate(action_item.getExpected_completionDate());
            existingAction_item.setActual_completionDate(action_item.getActual_completionDate());
            existingAction_item.setStatus(action_item.getStatus());

            action_itemService.updateAction_item(existingAction_item);
            return "redirect:/projects/edit/action_items";
        }


        @GetMapping("/projects/edit/action_items/{id}")
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
            model.addAttribute("issues", issueService.getAllIssuesById(pid));
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
            Project project = projectService.getProjectById(pid);
            project.assignIssue(issue);
            projectService.updateProject(project);
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
            existingIssue.setDate_create(issue.getDate_create());
            existingIssue.setDate_assign(issue.getDate_assign());
            existingIssue.setExpected_completionDate(issue.getExpected_completionDate());
            existingIssue.setActual_completionDate(issue.getActual_completionDate());
            existingIssue.setPriority(issue.getPriority());
            existingIssue.setImpact(issue.getImpact());
            existingIssue.setStatus(issue.getStatus());

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
            model.addAttribute("decisions", decisionService.getAllDecisionsById(pid));
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
            Project project = projectService.getProjectById(pid);
            project.assignDecision(decision);
            projectService.updateProject(project);
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
            existingDecision.setDate_create(decision.getDate_create());
            existingDecision.setDate_made(decision.getDate_made());
            existingDecision.setDate_need(decision.getDate_need());
            existingDecision.setDecision_maker(decision.getDecision_maker());
            existingDecision.setExpected_completionDate(decision.getExpected_completionDate());
            existingDecision.setActual_completionDate(decision.getActual_completionDate());
            existingDecision.setPriority(decision.getPriority());
            existingDecision.setImpact(decision.getImpact());
            existingDecision.setStatus(decision.getStatus());

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
            model.addAttribute("resources", resourceService.getAllResourcesById(pid));
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
            Project project = projectService.getProjectById(pid);
            project.assignResource(resource);
            projectService.updateProject(project);
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
            existingResource.setTitle(resource.getTitle());
            existingResource.setPay_rate(resource.getPay_rate());

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
            model.addAttribute("risks", riskService.getAllRisksById(pid));
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
            Project project = projectService.getProjectById(pid);
            project.assignRisk(risk);
            projectService.updateProject(project);
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
            existingRisk.setCategory(risk.getCategory());
            existingRisk.setProbability(risk.getProbability());
            existingRisk.setImpact(risk.getImpact());
            existingRisk.setMitigation(risk.getMitigation());
            existingRisk.setContingency(risk.getContingency());
            existingRisk.setRisk_score(risk.getRisk_score());
            existingRisk.setAction_by(risk.getAction_by());

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