package uz.pdp.shaftoli.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.shaftoli.entity.UserEntity;
import uz.pdp.shaftoli.service.emailCode.EmailCodeService;
import uz.pdp.shaftoli.service.user.UserService;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final EmailCodeService emailCodeService;

    @RequestMapping(value = "/auth/sign-up", method = RequestMethod.POST)
    public String signUp(
            @ModelAttribute UserEntity user,
            Model model
    ) {
        model.addAttribute("user", user);

        if(userService.add(user) == null){
            emailCodeService.sendCodeToEmailAndReturn(user.getEmail());
            return "verification";
        }
        return "index";
    }

    @RequestMapping(value = "/auth/sign-in", method = RequestMethod.POST)
    public String signInPage(@RequestParam String email, @RequestParam String password) {
        UserEntity user = userService.signIn(email, password);
        if (user != null ){
            return "manage-cards";
        }
        return "index";
    }

}
