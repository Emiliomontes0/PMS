package projectmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.service.ProjectService;
import projectmanagementsystem.service.RequirementService;

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

        @GetMapping("/projects/new/requirements")//path
        public String listRequirements(Model model) {
            model.addAttribute("requirements", requirementService.getAllRequirements());
            return "Requirements";
        }

        @GetMapping("/projects/new/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/new/requirements")
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);
            return "redirect:/projects/new/requirements";//return page

        }


        @GetMapping("/projects/new/requirements/edit/{id}")
        public String editRequirementForm(@PathVariable Long id, Model model) {
            model.addAttribute("requirement", requirementService.getRequirementById(id));
            return "edit_requirement";
        }



        @PostMapping("/projects/new/requirements/{id}")
        public String updateRequirement(@PathVariable Long id,
                                        @ModelAttribute("requirement") Requirement requirement, Model model) {

            Requirement existingRequirement = requirementService.getRequirementById(id);
            existingRequirement.setId(id);
            existingRequirement.setReq_name(requirement.getReq_name());
            existingRequirement.setDescription(requirement.getDescription());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/new/requirements";
        }


        @GetMapping("/projects/new/requirements/{id}")//getting pathing of new requirements
        public String deleteRequirement(@PathVariable Long id){
            requirementService.deleteRequirementById(id);
            return "redirect:/projects/new/requirements";

        }
    }
    /*
    @Controller
    public class RequirementController {
        private RequirementService requirementService;

        public RequirementController(RequirementService requirementService) {
            super();
            this.requirementService = requirementService;
        }

        @GetMapping("/projects/new/requirements")//path
        public String listRequirements(Model model) {
            model.addAttribute("requirements", requirementService.getAllRequirements());
            return "Requirements";
        }

        @GetMapping("/projects/new/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/new/requirements")
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);
            return "redirect:/projects/new/requirements";//return page

        }


        @GetMapping("/projects/new/requirements/edit/{id}")
        public String editRequirementForm(@PathVariable Long id, Model model) {
            model.addAttribute("requirement", requirementService.getRequirementById(id));
            return "edit_requirement";
        }



        @PostMapping("/projects/new/requirements/{id}")
        public String updateRequirement(@PathVariable Long id,
                                        @ModelAttribute("requirement") Requirement requirement, Model model) {

            Requirement existingRequirement = requirementService.getRequirementById(id);
            existingRequirement.setId(id);
            existingRequirement.setReq_name(requirement.getReq_name());
            existingRequirement.setDescription(requirement.getDescription());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/new/requirements";
        }


        @GetMapping("/projects/new/requirements/{id}")//getting pathing of new requirements
        public String deleteRequirement(@PathVariable Long id){
            requirementService.deleteRequirementById(id);
            return "redirect:/projects/new/requirements";

        }
    }
    @Controller
    public class RequirementController {
        private RequirementService requirementService;

        public RequirementController(RequirementService requirementService) {
            super();
            this.requirementService = requirementService;
        }

        @GetMapping("/projects/new/requirements")//path
        public String listRequirements(Model model) {
            model.addAttribute("requirements", requirementService.getAllRequirements());
            return "Requirements";
        }

        @GetMapping("/projects/new/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/new/requirements")
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);
            return "redirect:/projects/new/requirements";//return page

        }


        @GetMapping("/projects/new/requirements/edit/{id}")
        public String editRequirementForm(@PathVariable Long id, Model model) {
            model.addAttribute("requirement", requirementService.getRequirementById(id));
            return "edit_requirement";
        }



        @PostMapping("/projects/new/requirements/{id}")
        public String updateRequirement(@PathVariable Long id,
                                        @ModelAttribute("requirement") Requirement requirement, Model model) {

            Requirement existingRequirement = requirementService.getRequirementById(id);
            existingRequirement.setId(id);
            existingRequirement.setReq_name(requirement.getReq_name());
            existingRequirement.setDescription(requirement.getDescription());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/new/requirements";
        }


        @GetMapping("/projects/new/requirements/{id}")//getting pathing of new requirements
        public String deleteRequirement(@PathVariable Long id){
            requirementService.deleteRequirementById(id);
            return "redirect:/projects/new/requirements";

        }
    }
    @Controller
    public class RequirementController {
        private RequirementService requirementService;

        public RequirementController(RequirementService requirementService) {
            super();
            this.requirementService = requirementService;
        }

        @GetMapping("/projects/new/requirements")//path
        public String listRequirements(Model model) {
            model.addAttribute("requirements", requirementService.getAllRequirements());
            return "Requirements";
        }

        @GetMapping("/projects/new/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/new/requirements")
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);
            return "redirect:/projects/new/requirements";//return page

        }


        @GetMapping("/projects/new/requirements/edit/{id}")
        public String editRequirementForm(@PathVariable Long id, Model model) {
            model.addAttribute("requirement", requirementService.getRequirementById(id));
            return "edit_requirement";
        }



        @PostMapping("/projects/new/requirements/{id}")
        public String updateRequirement(@PathVariable Long id,
                                        @ModelAttribute("requirement") Requirement requirement, Model model) {

            Requirement existingRequirement = requirementService.getRequirementById(id);
            existingRequirement.setId(id);
            existingRequirement.setReq_name(requirement.getReq_name());
            existingRequirement.setDescription(requirement.getDescription());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/new/requirements";
        }


        @GetMapping("/projects/new/requirements/{id}")//getting pathing of new requirements
        public String deleteRequirement(@PathVariable Long id){
            requirementService.deleteRequirementById(id);
            return "redirect:/projects/new/requirements";

        }
    }
    @Controller
    public class RequirementController {
        private RequirementService requirementService;

        public RequirementController(RequirementService requirementService) {
            super();
            this.requirementService = requirementService;
        }

        @GetMapping("/projects/new/requirements")//path
        public String listRequirements(Model model) {
            model.addAttribute("requirements", requirementService.getAllRequirements());
            return "Requirements";
        }

        @GetMapping("/projects/new/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/new/requirements")
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);
            return "redirect:/projects/new/requirements";//return page

        }


        @GetMapping("/projects/new/requirements/edit/{id}")
        public String editRequirementForm(@PathVariable Long id, Model model) {
            model.addAttribute("requirement", requirementService.getRequirementById(id));
            return "edit_requirement";
        }



        @PostMapping("/projects/new/requirements/{id}")
        public String updateRequirement(@PathVariable Long id,
                                        @ModelAttribute("requirement") Requirement requirement, Model model) {

            Requirement existingRequirement = requirementService.getRequirementById(id);
            existingRequirement.setId(id);
            existingRequirement.setReq_name(requirement.getReq_name());
            existingRequirement.setDescription(requirement.getDescription());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/new/requirements";
        }


        @GetMapping("/projects/new/requirements/{id}")//getting pathing of new requirements
        public String deleteRequirement(@PathVariable Long id){
            requirementService.deleteRequirementById(id);
            return "redirect:/projects/new/requirements";

        }
    }
    @Controller
    public class RequirementController {
        private RequirementService requirementService;

        public RequirementController(RequirementService requirementService) {
            super();
            this.requirementService = requirementService;
        }

        @GetMapping("/projects/new/requirements")//path
        public String listRequirements(Model model) {
            model.addAttribute("requirements", requirementService.getAllRequirements());
            return "Requirements";
        }

        @GetMapping("/projects/new/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/new/requirements")
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);
            return "redirect:/projects/new/requirements";//return page

        }


        @GetMapping("/projects/new/requirements/edit/{id}")
        public String editRequirementForm(@PathVariable Long id, Model model) {
            model.addAttribute("requirement", requirementService.getRequirementById(id));
            return "edit_requirement";
        }



        @PostMapping("/projects/new/requirements/{id}")
        public String updateRequirement(@PathVariable Long id,
                                        @ModelAttribute("requirement") Requirement requirement, Model model) {

            Requirement existingRequirement = requirementService.getRequirementById(id);
            existingRequirement.setId(id);
            existingRequirement.setReq_name(requirement.getReq_name());
            existingRequirement.setDescription(requirement.getDescription());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/new/requirements";
        }


        @GetMapping("/projects/new/requirements/{id}")//getting pathing of new requirements
        public String deleteRequirement(@PathVariable Long id){
            requirementService.deleteRequirementById(id);
            return "redirect:/projects/new/requirements";

        }
    }
    @Controller
    public class RequirementController {
        private RequirementService requirementService;

        public RequirementController(RequirementService requirementService) {
            super();
            this.requirementService = requirementService;
        }

        @GetMapping("/projects/new/requirements")//path
        public String listRequirements(Model model) {
            model.addAttribute("requirements", requirementService.getAllRequirements());
            return "Requirements";
        }

        @GetMapping("/projects/new/requirements/new")//path context
        public String createRequirementForm(Model model) {
            Requirement requirement = new Requirement();
            model.addAttribute("requirement", requirement);
            return "create_requirement";//path
        }

        @PostMapping("/projects/new/requirements")
        public String saveRequirement(@ModelAttribute("requirement") Requirement requirement) {
            requirementService.saveRequirements(requirement);
            return "redirect:/projects/new/requirements";//return page

        }


        @GetMapping("/projects/new/requirements/edit/{id}")
        public String editRequirementForm(@PathVariable Long id, Model model) {
            model.addAttribute("requirement", requirementService.getRequirementById(id));
            return "edit_requirement";
        }



        @PostMapping("/projects/new/requirements/{id}")
        public String updateRequirement(@PathVariable Long id,
                                        @ModelAttribute("requirement") Requirement requirement, Model model) {

            Requirement existingRequirement = requirementService.getRequirementById(id);
            existingRequirement.setId(id);
            existingRequirement.setReq_name(requirement.getReq_name());
            existingRequirement.setDescription(requirement.getDescription());

            requirementService.updateRequirement(existingRequirement);
            return "redirect:/projects/new/requirements";
        }


        @GetMapping("/projects/new/requirements/{id}")//getting pathing of new requirements
        public String deleteRequirement(@PathVariable Long id){
            requirementService.deleteRequirementById(id);
            return "redirect:/projects/new/requirements";

        }
    }*/
}
