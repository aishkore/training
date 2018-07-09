package com.example.demo;
import javax.persistence.*;
@Entity
@Table(name="Users")
public class User {



   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   public long id;
    
	@Column(name="firstname")
	public  String firstname;
    
	@Column(name="lastname")
	public  String lastname;

	 public User() {}
	
    public User(long id,String firstname,String lastname) {
        this.id = id;
	this.firstname=firstname;
        this.lastname= lastname;
    }
    
   /* public String toString()
    {
    	return String.format("Customer[id=%d,name=%s,content=%s",id,name,content);
    }
*/
	/*public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setname(String name)
	{
		 this.name=name;
	}
	public void setcontent(String content)
	{
		 this.content=content;
	}
	*/
}

