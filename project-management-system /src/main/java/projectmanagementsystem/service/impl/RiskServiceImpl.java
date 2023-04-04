package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Risk;
import projectmanagementsystem.repository.RiskRepository;
import projectmanagementsystem.service.RiskService;

import java.util.List;
@Service
public class RiskServiceImpl implements RiskService{
    private RiskRepository riskRepository;

    public RiskServiceImpl(RiskRepository riskRepository) {
        super();
        this.riskRepository = riskRepository;
    }
    @Override
    public List<Risk> getAllRisks(){
        return riskRepository.findAll();
    }
    @Override
    public Risk saveRisks(Risk risk){
        return riskRepository.save(risk);
    }
    @Override
    public Risk getRiskById(Long id){
        return riskRepository.findById(id).get();
    }
    public Risk updateRisk(Risk risk){
        return riskRepository.save(risk);
    }
    @Override
    public void deleteRiskById(Long id){
        riskRepository.deleteById(id);
    }
}
