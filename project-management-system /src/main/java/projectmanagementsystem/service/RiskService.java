package projectmanagementsystem.service;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Risk;

import java.util.List;

public interface RiskService {
    List<Risk> getAllRisks();
    Risk saveRisks(Risk risk);
    Risk getRiskById(Long id);
    Risk updateRisk(Risk risk);
    void deleteRiskById(Long id);
    List<Risk> getAllRisksById(Long id);
}
