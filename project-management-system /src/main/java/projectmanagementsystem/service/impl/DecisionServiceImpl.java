package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Decision;
import projectmanagementsystem.repository.DecisionRepository;
import projectmanagementsystem.service.DecisionService;

import java.util.List;
@Service
public class DecisionServiceImpl implements DecisionService{
    private DecisionRepository decisionRepository;

    public DecisionServiceImpl(DecisionRepository decisionRepository) {
        super();
        this.decisionRepository = decisionRepository;
    }
    @Override
    public List<Decision> getAllDecisions(){
        return decisionRepository.findAll();
    }
    @Override
    public Decision saveDecisions(Decision decision){
        return decisionRepository.save(decision);
    }
    @Override
    public Decision getDecisionById(Long id){
        return decisionRepository.findById(id).get();
    }
    public Decision updateDecision(Decision decision){
        return decisionRepository.save(decision);
    }
    @Override
    public void deleteDecisionById(Long id){
        decisionRepository.deleteById(id);
    }
}
