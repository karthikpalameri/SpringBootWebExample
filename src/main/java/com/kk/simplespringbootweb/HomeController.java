package com.kk.simplespringbootweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        System.out.println("home method called");
        return "index";
    }
/*
      HttpServletRequest, HttpSession , JSTL demo
 */
/*
    @RequestMapping("/add")
    public String add(HttpServletRequest req, HttpSession session) {
        System.out.println("add method called");
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        int res = Integer.parseInt(num1) + Integer.parseInt(num2);
        System.out.println("res = " + res);

        //setting res in session and using in reult.jsp using <%= session.getAttribute("res") %>
        // or using JSTL lib which allows directly use certain tags like ${res}
        session.setAttribute("res", res);
        return "result.jsp";
    }
*/

    /*
        if request param names just use same var name ex:num1 or use @RequestParam("var")
        Model is used to pass data to view from the controller
     */
/*
    @RequestMapping("/add")
    public String add2(@RequestParam("num1") int num1, @RequestParam("num2") int num2, Model model) {
        System.out.println("add method called");

        int res = num1 + num2;
        System.out.println("res = " + res);

        model.addAttribute("res", res);
        return "result";
    }
*/

    /*
    ModelAndView Demo, which is object to return res val and view name to return;
     */
/*
    @RequestMapping("/add")
    public ModelAndView add2(@RequestParam("num1") int num1, @RequestParam("num2") int num2, ModelAndView mv) {
        System.out.println("add method called");

        int res = num1 + num2;
        System.out.println("res = " + res);

        mv.addObject("res", res);//setting res to return
        mv.setViewName("result");//setting view to return
        return mv;
    }
*/

    /*
     * If you have few requestParams then use this
     * */
/*
    @RequestMapping("/addAlien")
    public ModelAndView addAlien(@RequestParam("aid") int aid, @RequestParam("aname") String aname, ModelAndView mv) {
        System.out.println("add method called");

        Alien alien = new Alien();
        alien.setAid(aid);
        alien.setAname(aname);
        System.out.println("res = " + alien);

        mv.addObject("alien", alien);//setting res to return
        mv.setViewName("result");//setting view to return
        return mv;
    }
*/


    @ModelAttribute("course")
    public String getCourceName() {
        return "Java";
    }

    /*
     * @ModelAttribute maps form values to Pojo object ,
     * note: form names should match pojo properties names
     * */
    @RequestMapping("/addAlien")
    public String addAlien(@ModelAttribute("alien") Alien alien) {
        System.out.println("addAlien method called");

        System.out.println("res = " + alien);
        return "result";
    }
}
