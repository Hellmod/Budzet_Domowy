package pl.marzenapepera.BUDGET.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service("planService")
@Transactional
public class PlanServiceImpl implements PlanService {

    @Qualifier("planRepository")
    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan findPlanById(int id) {
        return (Plan) planRepository.findById(id);
    }

    @Override
    public List<Plan> findAllByUserId(int id) {
        return planRepository.findAllByUserId(id);
    }

    @Override
    public void savePlan(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public void updatePlan(Plan plan) {
        planRepository.updatePlan(plan.getId_plan(), plan.getAmount(), plan.getDescription(), plan.getDate());
    }

    @Override
    public Plan findPlanByIdAndDate(int id, Date date) {
        return planRepository.findByIdAndDate(id, date);
    }

}
