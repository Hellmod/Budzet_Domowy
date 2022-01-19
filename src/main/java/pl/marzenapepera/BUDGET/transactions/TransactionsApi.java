package pl.marzenapepera.BUDGET.transactions;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marzenapepera.BUDGET.plan.Plan;
import pl.marzenapepera.BUDGET.user.UserService;
import pl.marzenapepera.BUDGET.utilities.UserUtilities;
import pl.marzenapepera.BUDGET.plan.PlanService;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TransactionsApi {

    @Autowired
    MessageSource messageSource;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlanService planService;

    @RequestMapping({"/api/transaction"})
    public String transaction() {
        Date date = new Date();
        date.setDate(1);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        List<Transaction> transactionList = transactionService.findAllByMonth(userService.findUserByEmail(UserUtilities.getLoggedUser()), date);
        return new Gson().toJson(transactionList);
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @RequestMapping({"/api/left"})
    public String left() {
        Date date = new Date();
        date.setDate(1);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        List<Transaction> transactionList = transactionService.findAllByMonth(userService.findUserByEmail(UserUtilities.getLoggedUser()), date);

        Plan plan = planService.findPlanByIdAndDate(userService.findUserByEmail(UserUtilities.getLoggedUser()).getId(), date);
        if (plan == null) {
            plan = new Plan();
            plan.setAmount(0.0);
        }

        Double amount = transactionList.stream().mapToDouble(t -> {
            if (t.getAmount() < 0)
                return t.getAmount();
            else return 0;
        }).sum();

        Amount left = new Amount();
        Double l = plan.getAmount() + amount;
        df.format(l);
        left.setAmount(df.format(l));
        return new Gson().toJson(left);
    }

}
