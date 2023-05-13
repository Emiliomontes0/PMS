package projectmanagementsystem.service;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Risk;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface RiskService {
    List<Risk> getAllRisks();
    Risk saveRisks(Risk risk);
    Risk getRiskById(Long id);
    Risk updateRisk(Risk risk);
    void deleteRiskById(Long id);
    List<Risk> getAllRisksById(Long id);
}
