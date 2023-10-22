package com.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.AdminModel;
import com.spring.pojo.Student;

@Controller
@SessionAttributes("user")
public class SpringController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String homeI() {
		return "index";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/details")
	public ModelAndView details() {

		ModelAndView mv = null;
		ArrayList<Student> al = new AdminModel().getAllStudents();
		// System.out.println("controller -> " +al);

		mv = new ModelAndView("details", "LIST", al);

		return mv;
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
		}

	@RequestMapping("/adminHome")
	public String adminHome() {
		return "adminHome";
	}

	@RequestMapping("/checkLogin")
	public ModelAndView loginCheck(@RequestParam("uname") String u, @RequestParam("pwd") String pwd) {
		
		ModelAndView mv = null;
		
		
		// HttpServletRequest req
//		String u = req.getParameter("uname");
//		String pwd = req.getParameter("pwd");

		AdminModel model = new AdminModel();
		int i = model.checkLogin(u, pwd);

		if (i != 0) {
			mv = new ModelAndView("adminHome", "msg", "Login Successsfull");
			mv.addObject("user",u);
			return mv;
		} else {
			return new ModelAndView("login", "msg", "incorrect credentials");

		}
	}

	// public ModelAndView studentInsert(@RequestParam("name") String
	// name),@RequestParam("rollno")int rollno,@RequestParam("marks") int
	// marks,@RequestParam("address") String addresss ) {

	@RequestMapping("/studentInsert")
	public ModelAndView studentInsert(@ModelAttribute("Student") Student std) {
		ModelAndView mv = null;

		AdminModel model = new AdminModel();
		int i = model.insertStudent(std);
		if (i != 0) {
			mv = new ModelAndView("register", "msg", "student registration success");
		} else {
			mv = new ModelAndView("register", "msg", "student registration failed");
		}

		return mv;
	}
	
	
	@RequestMapping("/update_ctrl")
	public ModelAndView update(@RequestParam("roll_no") int rr) {
		
		ModelAndView mv = null;
		AdminModel model = new AdminModel();
		Student std = model.getAStudent(rr);
		
		mv = new ModelAndView("editStudent","STD",std);
		
		return mv;
	}
	
	@RequestMapping("/updateInsert")
	public ModelAndView updateInsert(@ModelAttribute("Student") Student std ) {
		
		ModelAndView mv = null;
		
		AdminModel model = new AdminModel();
		int  i = model.updateStudent(std);
		
		if(i!=0) {
			mv = new ModelAndView("details","msg","Student update Successfully");
		}else {
			mv = new ModelAndView("details","msg","Student not update");
		}
		
		return null;
	}
	
	
	@RequestMapping("/delete_ctrl")
	public ModelAndView delete(@RequestParam("roll_no") int rr) {
		ModelAndView mv = null;
		AdminModel model = new AdminModel();
		int i = model.deleteStudent(rr);
		
		ArrayList<Student> list = model.getAllStudents();
			if(i!=0) {
				mv = new ModelAndView("details","msg","data deleted");
				mv.addObject("LIST",list);
			}else {
				mv = new ModelAndView("details","msg","data not deleted");
				mv.addObject("LIST",list);
			}
		
		return mv;
	}
	

}
