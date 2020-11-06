package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.RoleDao;
import com.upgrad.hirewheels.dao.UsersDao;
import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);

		UsersDao usersDao = context.getBean(UsersDao.class);

		Users users1 = new Users();

		users1.setFirstName("Akhil");
		users1.setLastName("Sahu");
		users1.setEmail("sahu.akhil1811@outlook.com");
		users1.setMobileNo("839355555");
		users1.setPassword("akhill123@");

		Users users2 = new Users();
		users2.setFirstName("Sumit");
		users2.setLastName("patidar");
		users2.setEmail("sumit@outlook.com");
		users2.setMobileNo("8399999999");
		users2.setPassword("sumit123@");

		Users users3 = new Users();
		users3.setFirstName("Kajal");
		users3.setLastName("Sharma");
		users3.setEmail("kajal@outlook.com");
		users3.setMobileNo("1234567890");
		users3.setPassword("kajal123@");

		Users users4 = new Users();
		users4.setFirstName("Sonu");
		users4.setLastName("Sharma");
		users4.setEmail("sonu@outlook.com");
		users4.setMobileNo("9875648569");
		users4.setPassword("sonu123@");

		Users users5 = new Users();
		users5.setFirstName("Kapil");
		users5.setLastName("Sahu");
		users5.setEmail("sahu.kapil1811@outlook.com");
		users5.setMobileNo("9907356248");
		users5.setPassword("kapil123@");


		//Saving all users at once
		List<Users> usersList = new ArrayList<>();
		usersList.add(users1);
		usersList.add(users2);
		usersList.add(users3);
		usersList.add(users4);
		usersList.add(users5);
		usersDao.saveAll(usersList);

		//Printing All user details on Console
		usersDao.findAll().forEach(users -> System.out.println(users.toString()));

		//Making a paginated request to fetch a page with 2 users
		Page<Users> page0 = usersDao.findAll(PageRequest.of(0,2));
		page0.stream().forEach(users -> System.out.println(users.toString()));


		//Fetching users using cutome query methods
		usersDao.findByFirstNameIgnoreCase("Kapil").forEach(users -> System.out.println(users.toString()));

		usersDao.findByFirstNameOrLastNameIgnoreCase("Akhil", "Sharma").forEach(users -> System.out.println(users.toString()));

		usersDao.findByEmailIgnoreCase("sahu.kapil1811@outlook.com").forEach(users -> System.out.println(users.toString()));
	}

}
