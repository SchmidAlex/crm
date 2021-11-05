package ch.zli.m223.crm.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.zli.m223.crm.model.AppUser;
import ch.zli.m223.crm.service.UserService;

/**
 *  Das ist der Webcontroller für den User
 * @author User
 *
 */
@Controller
@RequestMapping("/web/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	 * Is to get and see all users
	 * @param model black magic of spring
	 * @return the template userList.html
	 */
	@GetMapping("")
	public String getAllUsers(Model model) {
		List<AppUser> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "userList";
	}
	
	/**
	 * Is to see one user (single-view)
	 * @param id of the user
	 * @param model black magic of spring
	 * @return to the template user.html
	 */
	@GetMapping("/{id}")
	public String getOneUserById(@PathVariable("id") long id, Model model) {
		AppUser user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user";
	}
	
	/**
	 * Is to delete a user
	 * @param id of the user
	 * @param model black magic of spring
	 * @return lets the function getAllUsers(Model model) run
	 */
	@GetMapping("/{id}/delete")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		userService.deleteById(id);
		return getAllUsers(model);
	}
	
	/**
	 * shows the form to add an user
	 * @return the view addUserForm
	 */
	@GetMapping("/adduserform")
	public String addAnUserForm() {
		return "addUserForm";
	}
	
	/**
	 * adds a new user and shows all again
	 * @param model black magic of spring
	 * @param email of the new user
	 * @param password of the new user
	 * @return the new view of all users
	 */
	@PostMapping("/adduser")
	public String addAnUser(Model model, @RequestParam String email, @RequestParam String password) {
		userService.addUser(email, password);
		return getAllUsers(model);
	}
}
