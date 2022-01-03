package pl.marzenapepera.BUDGET.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.marzenapepera.BUDGET.validators.UserRegisterValidator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.Locale;

@Controller
public class RegisterController {

    @Autowired
    MessageSource messageSource;
    @Autowired
    private UserService userService;

    @GET
    @RequestMapping(value = "/register")
    public String registerForm(Model model) {
        User u = new User();
        model.addAttribute("user", u);
        return "register";
    }

    @POST
    @RequestMapping(value = "/adduser")
    public String registerAction(User user, BindingResult result, Model model, Locale locale) {

        String returnPage = null;
        user.setMark(50);
        user.setActive(1);
        user.setIs_fired(false);
        user.setIs_new(true);

Role role = null;


        User userExist = userService.findUserByEmail(user.getEmail());

        new UserRegisterValidator().validateEmailExist(userExist, result);
        new UserRegisterValidator().validate(user, result);


        if (result.hasErrors()) {
            returnPage = "register";
        } else {
            userService.saveUser(user);
            model.addAttribute("message", messageSource.getMessage("user.register.success", null, locale));
            model.addAttribute("user", new User());
            returnPage = "register";
        }

        return returnPage;
    }

    public void validateEmailExist(User user, Errors errors) {
        if (user != null) {
            errors.rejectValue("email", "error.userEmailExist");
        }
    }


}

