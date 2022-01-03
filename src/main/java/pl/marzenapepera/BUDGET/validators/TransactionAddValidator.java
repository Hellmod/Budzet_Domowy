package pl.marzenapepera.BUDGET.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.marzenapepera.BUDGET.user.User;

public class TransactionAddValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        //Transaction h = (Transaction) obj;

        ValidationUtils.rejectIfEmpty(errors, "hour_from", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "hour_to", "error.userLastName.empty");


//		if (!h.getHour_from().equals(null)) {
//			boolean isMatch = AppdemoUtils.checkDate(BUDGETConstants.HOUR_PATTERN, h.getHour_from());
//			if(!isMatch) {
//				errors.rejectValue("hour_from", "hour.error.dateNotMatch");
//			}
//		}

    }

}
