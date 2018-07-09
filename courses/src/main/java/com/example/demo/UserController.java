package com.example.demo;


import java.util.List;
import java.util.Optional;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserRepository repository;


	@RequestMapping(method=RequestMethod.POST)
	public User save(@RequestBody User newUser)
	{
		 return repository.save(newUser);
	 
	}

	@RequestMapping(method=RequestMethod.GET)
	public Iterable<User> findall() {
	  return repository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ResponseEntity<User> findbyid(@PathVariable int id)
	{
		Optional<User> result=repository.findById((long) id);
		  return(result.isPresent())?
			 new ResponseEntity<User>(result.get(),HttpStatus.OK)
		  :new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findbyfirstname")
	public  List<User>findbyname(@RequestParam("firstname")String firstname)
	{
	 
	  List<User> result=repository.findByfirstname(firstname);
	  return result;
	}

	@RequestMapping(method=RequestMethod.PUT,value="/update/{id}")
	public void update(@PathVariable long id, @RequestBody User upd)
	{
	   repository.save(upd);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{id}")
	public void delete(@PathVariable("id")long id)
	{
		repository.deleteById(id);
	}
}
