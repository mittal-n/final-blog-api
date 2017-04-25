package com.blog.api.tests;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;



import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.awt.List;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.blog.api.service.*;

import static org.mockito.Mockito.*;
import org.testng.annotations.Test;
import org.mockito.stubbing.OngoingStubbing;
import com.blog.api.domain.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.blog.api.domain.Post;
import com.blog.api.domain.User;
import com.blog.api.service.PostService;
import com.blog.api.service.UserService;
import com.blog.api.domain.Post;


public class UserServiceTest {



	// Data Provide
	@DataProvider(name = "data")
	public Object[][] getData(Method name) {
		Object[][] obj = null;
		if (name.getName().equalsIgnoreCase("getUserTest")) {
			obj = new Object[1][2];
			obj[0][0] = "Nidhi";
			obj[0][1] = 1234L;
		}

		if (name.getName().equalsIgnoreCase("saveTest")) {
			obj = new Object[1][4];
			obj[0][0] = 123456L;
			obj[0][1] = "Piyush";
			obj[0][2] = "Mittal";
			obj[0][3] = "mittal.p";
		}

		if (name.getName().equalsIgnoreCase("updateTest")) {
			obj = new Object[1][4];
			obj[0][0] = 123456L;
			obj[0][1] = "Rahul";
			obj[0][2] = "Singhal";
			obj[0][3] = "mittal.p";
		}

		if (name.getName().equalsIgnoreCase("deleteTest")) {
			obj = new Object[1][1];
			obj[0][0] = 123456L;
		}


		return obj;

	}


	// Verify getUser by adding one user
	@Test(dataProvider = "data")
	public void getUserTest(String name, Long id) {
		User user = mock(User.class);
		when(user.getUsername()).thenReturn(name);
		when(user.getId()).thenReturn(id);

		UserService service1 = mock(UserService.class);
		when(service1.getUser(id)).thenReturn(user);
		AssertJUnit.assertTrue(service1.getUser(id) != null);
	}

	// Verify save method by adding one user
	@Test(dataProvider = "data")
	public void saveTest(Long id, String firstName, String lastName, String username) {
		User user = mock(User.class);
		when(user.getId()).thenReturn(id);
		when(user.getFirstName()).thenReturn(firstName);
		when(user.getLastName()).thenReturn(lastName);
		when(user.getUsername()).thenReturn(username);


		UserService service1 = mock(UserService.class);
		when(service1.save(user)).thenReturn(user);
		AssertJUnit.assertTrue(service1.save(user).getFirstName() == "Piyush");
	}

	// Verify update method 
	@Test(dataProvider = "data")
	public void updateTest(Long id, String firstName, String lastName, String username) {
		User user = mock(User.class);
		when(user.getId()).thenReturn(id);
		when(user.getFirstName()).thenReturn(firstName);
		when(user.getLastName()).thenReturn(lastName);
		when(user.getUsername()).thenReturn(username);


		UserService service1 = mock(UserService.class);
		when(service1.update(user)).thenReturn(user);
		AssertJUnit.assertTrue(service1.update(user).getFirstName() == "Rahul");
	}

	// Verify delete method 
	/*@Test(dataProvider = "data")
	public void deleteTest(Long id) {
		User user = mock(User.class);
		when(user.getId()).thenReturn(id);

		UserService service1 = mock(UserService.class);
		when(service1.delete(id));
		AssertJUnit.assertTrue(service1.delete(id));
	}*/

}













