package com.example.demo;

import java.awt.List;

public class Course {
    
    private final String id;
    private final String CourseName;
    private final String CourseContent;

   
    public String getId() {
        return id;
    }
	
    public String getName() {
        return CourseName;
    }

    public String getContent() {
        return CourseContent;
    }

    public Course(String id,String CourseName,String CourseContent) {
        this.id = id;
	this.CourseName=CourseName;
        this.CourseContent = CourseContent;
    }
    
}
