package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.codejava.DAO.CheckoutRepository;
import net.codejava.DAO.ExamRepository;
import net.codejava.DAO.UserRepository;
import net.codejava.model.Checkout;
import net.codejava.model.Exam;
import net.codejava.model.User;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CheckoutRepository CheckoutRepo;
	
	
	
	@Autowired
	private ExamRepository ExamRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String view() {
		
		
		return "Homepage";
	}
	@GetMapping("/Homepage")
	public String view4() {
		
		
		return "Homepage";
	}

	@GetMapping("/user")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "user";	}
	
	
	
	@GetMapping("/Checkout")
	public String view1() {
		
		
		return "Checkout";
	}
	
	
	@PostMapping("/Checkout1")
	public String checkoutform(Checkout Checkout) {
	
		CheckoutRepo.save(Checkout);
		return "Success";
	}
	
	@GetMapping("/java")
	public String view2() {
		
		
		return "java";
	}
	
	@GetMapping("/c++")
	public String view3() {
		
		
		return "c++";
	}
	@GetMapping("/phps")
	public String view5() {
		
		
		return "phps";
	}
	@GetMapping("/springboot")
	public String view6() {
		
		
		return "springboot";
	}

	@GetMapping("/java1")
		public String view7() {
			return "java1";
		}
	@GetMapping("/SQL")
	public String view8() {
		
		
		return "SQL";
	}
	@GetMapping("/springboot1")
	public String view9() {
		
		
		return "springboot1";
	}
	@GetMapping("/BootStrap")
	public String view10() {
		
		
		return "BootStrap";
	}
	
	
	
	@GetMapping("/Exam")
	public String view11() {
		
		
		return "exam";
	}
	
	@PostMapping("/Exam1")
	public String examform(Exam exam) {
	
		ExamRepo.save(exam);
		return "Success1";
	}
	
	@GetMapping("/Score")
	public String view13() {
		
		
		return "Score";
	}
	
 
}
