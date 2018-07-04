package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Array;

import org.springframework.stereotype.Service;
@Service
public class Coursecalling {
	
	 private List<Course> course=Arrays.asList(new Course("1","Java","Abc"),new Course("2","Design Patterns","Abc"),new Course("3","Android","Abc"));
	public List<Course> get()
    {
      return course;
    }
    public void addcourse(Course c)
    {
       course.add(c);
    }
    public void update(String id,Course upd)
    {
       for(int i=0;i<course.size();i++)
    	{
       		Course cor=course.get(i);
                    if(cor.getId().equals(id))
                    { course.set(i,upd);break;}
    	}
    }
    public void delete(String id)
    {
    	 for(int i=0;i<course.size();i++)
     	{
    	Course cor=course.get(i);
                    if(cor.getId().equals(id))
                    { course.remove(i);break;}
    }
}
}
