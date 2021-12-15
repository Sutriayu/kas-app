package kaskelas.webcontroller;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kaskelas.dao.kasDAO;
import kaskelas.dao.kasDAOProcces;
import kaskelas.model.Kas;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class FormController {

    kasDAO kasDao = null;

    public FormController() {
        kasDao = new kasDAOProcces();
    }

    private ModelAndView editKas(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        Kas kas = kasDao.getSinggle(Integer.parseInt(id));
        ModelAndView modelandview = new ModelAndView();
        modelandview.addObject("kas", kas);
        return modelandview;
    }

    private ModelAndView deleteKas(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("id");
        if (kasDao.delete(Integer.parseInt(id))) {
            return new ModelAndView("redirect:/home.html");
        } else {
            req.setAttribute("message", "gagal delete");
            return addKas(req, res);
        }
    }

    private ModelAndView addKas(HttpServletRequest req, HttpServletResponse res) {
        if (req.getParameter("message") != null) {
            ModelAndView modelandview = new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();

    }

    @RequestMapping(value = "/kas-form")
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res) {
        String action = req.getParameter("action");
        ModelAndView modelandview;
        if (action == null) {
            action = "ADD";
        }
        switch (action.toUpperCase()) {
            case "EDIT":
                modelandview = editKas(req, res);
                break;
            case "DELETE":
                modelandview = deleteKas(req, res);
                break;
            default:
                modelandview = addKas(req, res);
                break;
        }
        Date today = new Date(System.currentTimeMillis());
        modelandview.addObject("today", today);
        return modelandview;
    }

    @RequestMapping(value = "/kas-form", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("lg") Kas ks) {
        ModelAndView modelandview = new ModelAndView("redirect:/kas-form.html");
        if (ks.getId() != 0) {
            if (kasDao.update(ks)) {
                return new ModelAndView("redirect:/home.html");
            } else {
                modelandview.addObject("message", "gagal updatte data");
            }
        } else {
            if (kasDao.save(ks)) {
                return new ModelAndView("redirect:/home.html");
            } else {
                modelandview.addObject("message", "gagal simpan data");
            }
        }
        return modelandview;

    }
}
