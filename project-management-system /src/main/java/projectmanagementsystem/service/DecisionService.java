package projectmanagementsystem.service;
import projectmanagementsystem.entity.Decision;
import projectmanagementsystem.entity.Requirement;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface DecisionService {
    List<Decision> getAllDecisions();
    Decision saveDecisions(Decision decision);
    Decision getDecisionById(Long id);
    Decision updateDecision(Decision decision);
    void deleteDecisionById(Long id);
    List<Decision> getAllDecisionsById(Long id);
}
