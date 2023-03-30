package projectmanagementsystem.service;
import projectmanagementsystem.entity.Decision;

import java.util.List;

public interface DecisionService {
    List<Decision> getAllDecisions();
    Decision saveDecisions(Decision decision);
    Decision getDecisionById(Long id);
    Decision updateDecision(Decision decision);
    void deleteDecisionById(Long id);
}
