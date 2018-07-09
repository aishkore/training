package com.example.demo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.User;
public interface UserRepository extends CrudRepository <User,Long> {
	List<User> findByfirstname(String firstname);
}
