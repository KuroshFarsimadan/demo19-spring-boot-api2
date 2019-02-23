package ir.kuroshfarsimadan.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/*
 * 
 * The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to handle web requests. 
 * @RequestMapping maps / to the index() method. When invoked from a browser or using curl on the command line, 
 * the method returns pure text. That’s because @RestController combines @Controller and @ResponseBody, two annotations 
 * that results in web requests returning data rather than a view.
 */
@RestController
public class ProductController {

	@RequestMapping("/")
	public String index() {
		return "Product controller works.";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseBody.html
	@ResponseBody
	public String getProducts() {
		return "{products: [ { id: 1 , productName: \"some name\"  } ] }";
	}

	@RequestMapping(value = "/products/{id:[\\\\d]+}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getProductPathVariable(@PathVariable("id") long id) {
		return "The path variable is: " + id;
	}

	@RequestMapping(value = "/products2", params = { "id", "id2" }, method = RequestMethod.GET)
	@ResponseBody
	public String getProductRequestParameter3(@RequestParam("id") long id,@RequestParam("id2") long id2) {
		return "The request variables are: " + id  + " " + id2;
	}

	@RequestMapping(value = "/products3", params = "id", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getProductRequestParameter2(@RequestParam("id") long id) {
		return "The request variable is: " + id;
	}
	
	@RequestMapping(value = "/products4", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getProductRequestParameter(@RequestParam("id") long id) {
		return "The request variable is: " + id;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String postProduct() {
		return "The path variable is: ";
	}


}
