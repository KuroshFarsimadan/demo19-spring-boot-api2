package ir.kuroshfarsimadan.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ir.kuroshfarsimadan.beans.User;;

/*
 * 
 * The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to handle web requests. 
 * @RequestMapping maps / to the index() method. When invoked from a browser or using curl on the command line, 
 * the method returns pure text. That’s because @RestController combines @Controller and @ResponseBody, two annotations 
 * that results in web requests returning data rather than a view.
 */
@RestController
public class UserController {

	// Aggregate root

	@GetMapping("/employees")
	List<User> all() {
		User user1 = new User(1, "name1");
		User user2 = new User(2, "name2");
		List<User> users = null;
		users.add(user1);
		users.add(user2);
		return users;
	}

	@PostMapping("/employees")
	User postUser(@RequestBody User user) {
		return user;
	}

	// Single item

	@GetMapping("/employees/{id}")
	User getUser(@PathVariable int id) {
		User user1 = new User(id, "name1");
		return user1;
	}

	@PutMapping("/employees/{id}")
	User putUser(@RequestBody User user, @PathVariable int id) {
		user.setId(id);
		return user;
	}

	@DeleteMapping("/employees/{id}")
	String deleteUser(@PathVariable Long id) {
		return "User " + id + " has been deleted";
 	}

}
