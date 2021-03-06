package demo.hateoas;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
	@ResponseBody
	public HttpEntity<Greeting> greeting(
			@RequestParam(value="name", required=false, defaultValue="") String name) {

        Greeting greeting = new Greeting("Hello " + name);
		
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name))
				.withSelfRel());

		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
	}
}