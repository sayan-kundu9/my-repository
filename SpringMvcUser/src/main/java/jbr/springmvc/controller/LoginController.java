package jbr.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.dao.UserDaoImpl;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

@Controller
public class LoginController {

	@Autowired
	UserDaoImpl userDao;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
		
		ModelAndView mav = null;
		User user = userDao.validateUser(login);
		if (null != user) {
			mav = new ModelAndView("welcome");
			
			
			mav.addObject("firstname", user.getFirstname());
			
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		
		return mav;
	 }
	
	@RequestMapping("/view")
	public ModelAndView viewUser() {
		List<User> list = userDao.getUsers();
		return new ModelAndView("viewUser", "list", list);
	}
	
	
	@RequestMapping(value="/deleteUser/{username}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable String username){  
		userDao.delete(username);  
	  
        return new ModelAndView("deletesuccess", "username",username);  
    } 

	@RequestMapping(value="/editUser/{username}") 
	public ModelAndView edit(@PathVariable String username) {
		User user = userDao.getUserByUsername(username);
		return new ModelAndView("userEditForm", "command", user);
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST) 
	public ModelAndView editSave(@ModelAttribute("user") User user) {
		System.out.println("uuuu");
		userDao.update(user);  
		
        return new ModelAndView("editSuccessful");  
	}
}
