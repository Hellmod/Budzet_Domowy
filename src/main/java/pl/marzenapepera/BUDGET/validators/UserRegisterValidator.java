package pl.marzenapepera.BUDGET.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.marzenapepera.BUDGET.constants.BUDGETConstants;
import pl.marzenapepera.BUDGET.user.User;
import pl.marzenapepera.BUDGET.utilities.AppdemoUtils;

public class UserRegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");

        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

        if (user.getEmail() != null) {
            boolean isMatch = AppdemoUtils.checkEmailOrPassword(BUDGETConstants.EMAIL_PATTERN, user.getEmail());
            if (!isMatch) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }

		if (user.getPassword() != null) {
			boolean isMatch = AppdemoUtils.checkEmailOrPassword(BUDGETConstants.PASSWORD_PATTERN, user.getPassword());
			if(!isMatch) {
				errors.rejectValue("password", "error.userPasswordIsNotMatch");
			}
		}

    }


    public void validateEmailExist(User user, Errors errors) {
        if (user != null) {
            errors.rejectValue("email", "error.userEmailExist");
        }
    }
}
