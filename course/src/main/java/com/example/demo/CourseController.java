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


	@RequestMapping(method=RequestMethod.GET)
	public Course save(@RequestBody Course newCourse)
	{
		 return repository.save(newCourse);
	 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Course> findall() {
	  return repository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public String findbyid(@RequestParam("id")int id)
	{
	  String result="";
	  result=repository.findById((long) id).toString();
	  return result;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findbyname")
	public String findbyname(@RequestParam("name")String name)
	{
	  String result="";
	  result=repository.findByname(name).toString();
	  return result;
	}

	@RequestMapping(method=RequestMethod.PUT,value="/update/{id}")
	public void update(@PathVariable long id, @RequestBody Course upd)
	{
	  /* Optional <Course> cour=repository.findById(id);
	   cour.setname(upd.getName);
	   cour.setcontent(upd.getContent);*/
	   repository.save(upd);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{id}")
	public void delete(@PathVariable("id")long id)
	{
		repository.deleteById(id);
	}
}
