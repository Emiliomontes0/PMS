package projectmanagementsystem.service;
import projectmanagementsystem.entity.Decision;
import projectmanagementsystem.entity.Requirement;

import java.util.List;

public interface DecisionService {
    List<Decision> getAllDecisions();
    Decision saveDecisions(Decision decision);
    Decision getDecisionById(Long id);
    Decision updateDecision(Decision decision);
    void deleteDecisionById(Long id);
    List<Decision> getAllDecisionsById(Long id);
}
