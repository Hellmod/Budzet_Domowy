package pl.rafalmiskiewicz.BUDGET.transactions;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rafalmiskiewicz.BUDGET.plan.PlanService;
import pl.rafalmiskiewicz.BUDGET.user.UserService;
import pl.rafalmiskiewicz.BUDGET.utilities.UserUtilities;

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
    public String hours() {
        Date date = new Date();
        date.setDate(1);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        List<Transaction> transactionList = transactionService.findAllByMonth(userService.findUserByEmail(UserUtilities.getLoggedUser()),date);
        return new Gson().toJson(transactionList);
    }

}
