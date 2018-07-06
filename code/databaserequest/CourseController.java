package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public Course findbyid(@PathVariable int id)
	{
	  Optional<Course> result=repository.findById((long) id);
	  return result.get();
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
