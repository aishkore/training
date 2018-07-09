package com.example.demo;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/courses")
public class CourseController 
{
	@Autowired
	private CourseRepository repository;


	@RequestMapping(method=RequestMethod.POST)
	public Course save(@RequestBody Course newCourse)
	{
		 return repository.save(newCourse);
	 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Course> findall() {
	  return repository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ResponseEntity<Course> findbyid(@PathVariable int id)
	{
	  Optional<Course> result=repository.findById((long) id);
	  return(result.isPresent())?
		 new ResponseEntity<Course>(result.get(),HttpStatus.OK)
	  :new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
	/* return result.map(course ->new ResponseEntity<Course>(course,HttpStatus.OK) )
	 .orElse(new ResponseEntity<Course>(HttpStatus.NOT_FOUND));//functional programing syntax*/
	 
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findbyname/{name}")
	public List<Course> findbyname(@PathVariable String name)
	{
		 List<Course> result=repository.findByname(name);
		  return result;
	  
	}

	@RequestMapping(method=RequestMethod.PUT,value="/update/{id}")
	public Course update(@PathVariable long id, @RequestBody Course upd)
	{
	  /* Optional <Course> cour=repository.findById(id);
	   cour.setname(upd.getName);
	   cour.setcontent(upd.getContent);*/
	  return repository.save(upd);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{id}")
	public void delete(@PathVariable("id")long id)
	{
		repository.deleteById(id);
	}
}
