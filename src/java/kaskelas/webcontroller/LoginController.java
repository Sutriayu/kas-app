package kaskelas.webcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kaskelas.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
        if (req.getParameter("message") != null) {
            ModelAndView modelandview = new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();
    }

    @RequestMapping(value = "/login/submit")
    public ModelAndView save(@ModelAttribute("lg") LoginModel emp) {
        ModelAndView modelandview = new ModelAndView("redirect:/login.html");
        if (emp.getUsername().equalsIgnoreCase("ayu")
                && emp.getPassword().equalsIgnoreCase("ayu")) {
            return new ModelAndView("redirect:/home.html");
        } else {
            modelandview.addObject("message", "Username dan Password salah");
        }
        return modelandview;
    }
}
