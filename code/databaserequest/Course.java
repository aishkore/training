package com.example.demo;


import javax.persistence.*;

@Entity
@Table(name="courses")
public class Course  { 

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private long id;
    
	@Column(name="name")
	private  String name;
    
	@Column(name="content")
	 private  String content;
    
	public Course() {}
	
   /* public Course(long id,String name,String content) {
        this.id = id;
	this.name=name;
        this.content = content;
    }
    
    public String toString()
    {
    	return String.format("Customer[id=%d,name=%s,content=%s",id,name,content);
    }
*/
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}
	public void setname(String name)
	{
		 this.name=name;
	}
	public void setcontent(String content)
	{
		 this.content=content;
	}
	
}

