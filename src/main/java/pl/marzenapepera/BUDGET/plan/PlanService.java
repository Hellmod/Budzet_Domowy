package pl.marzenapepera.BUDGET.plan;

import java.util.Date;
import java.util.List;


public interface PlanService {
    List<Plan> findAll();
    Plan findPlanById(int id);
    List<Plan> findAllByUserId(int id);
    void savePlan(Plan plan);
    void updatePlan(Plan plan);
    Plan findPlanByIdAndDate(int id, Date date);
}
