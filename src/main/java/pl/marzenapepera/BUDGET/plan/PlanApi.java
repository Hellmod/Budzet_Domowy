package pl.marzenapepera.BUDGET.plan;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marzenapepera.BUDGET.user.UserService;
import pl.marzenapepera.BUDGET.utilities.UserUtilities;

import java.util.List;

@RestController
public class PlanApi {

    @Autowired
    MessageSource messageSource;

    @Autowired
    private UserService userService;

    @Autowired
    private PlanService planService;

    @RequestMapping({"/api/plan"})
    public String plan() {
        List<Plan> planList = planService.findAllByUserId(userService.findUserByEmail(UserUtilities.getLoggedUser()).getId());
        return new Gson().toJson(planList);
    }
}
