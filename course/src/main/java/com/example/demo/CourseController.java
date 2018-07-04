package com.example.demo;

import java.util.List;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CourseController {
	@Autowired
	private Coursecalling cour;


	@RequestMapping(method=RequestMethod.GET,value="/course")
	public List<Course> get()
	{
	  return (Arrays.asList(new Course("1","Java","Abc"),new Course("2","Design Patterns","Abc"),new Course("3","Android","Abc")));
	}
	@RequestMapping(method=RequestMethod.POST,value="/course")
	public void add(@RequestBody Course c)
	{
		
	   cour.addcourse(c);
	   
	   
	}
	@RequestMapping(method=RequestMethod.PUT,value="/course/{id}")
	public void update(@PathVariable String id, @RequestBody Course upd)
	{
	   cour.update(id,upd);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/course/{id}")
	public void delete(@PathVariable String id)
	{
		cour.delete(id);
	}
}
