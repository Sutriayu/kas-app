package kaskelas.webcontroller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kaskelas.dao.kasDAO;
import kaskelas.dao.kasDAOProcces;
import kaskelas.model.Kas;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {

    kasDAO kasDao = null;

    public HomeController() {
        kasDao = new kasDAOProcces();
    }

    private ModelAndView listKas(HttpServletRequest req, HttpServletResponse res) {
        List<Kas> newlist = kasDao.get();
        ModelAndView modelandview = new ModelAndView();
        modelandview.addObject("listKas", newlist);
        return modelandview;
    }

    @RequestMapping(value = "/home")
    public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        return listKas(req, res);
    }
}
