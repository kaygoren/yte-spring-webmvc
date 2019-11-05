package yte.spring.webmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yte.spring.webmvc.entity.Person;
import yte.spring.webmvc.entity.User;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class TestController {

	@GetMapping("/courses/{id}")
	public void test(@RequestParam String name, @RequestParam String instructor,
					 @PathVariable Integer id) {
		System.out.println(id + " " + name + " " + instructor);
	}

	@PostMapping("/persons")
	public ResponseEntity<List<Person>> addOneToAge(@RequestBody List<Person> personList) {
		for( Person person : personList) {
			person.setAge(person.getAge() +1);
		}
		return ResponseEntity.badRequest()
				.header("hataliMi","false")
				.contentType(MediaType.APPLICATION_JSON)
				.body(personList);
	}

	@PostMapping("/users")
	public void users(@Valid @RequestBody User user) {
		System.out.println(user);
	}

	@GetMapping("/illegal")
	public void illegal()throws IOException {
		throw new IOException();
	}
}
