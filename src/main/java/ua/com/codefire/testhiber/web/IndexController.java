/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.testhiber.web;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.com.codefire.testhiber.db.repo.StudentRepository;

/**
 *
 * @author human
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private StudentRepository studentRepository;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRoot() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("studentList", studentRepository.findAll());
        
        return mav;
    }
}
