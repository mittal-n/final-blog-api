package com.blog.api.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.blog.api.controller.PostController;
import com.blog.api.controller.UserController;
import com.blog.api.domain.Comment;
import com.blog.api.domain.Post;
import com.blog.api.domain.User;

public class UserControllerTest {

	
	private UserController userController = mock(UserController.class);

	private User constructUserObject(String f_name, Long id, String l_name, String username) {
		

		User user = new User();

		user.setId(id);
		user.setFirstName(f_name);
		user.setLastName(l_name);
		user.setUsername(username);

		return user;
	}

	@Test
	public void testListUserController() throws Exception {
		User user1 = constructUserObject("Bashaer", 1234L, "Alkhathlan", "user1");
		User user2 = constructUserObject("Sarah", 1235L, "Smith", "user2");

		when(userController.list()).thenReturn(Arrays.asList(user1, user2));

		assertTrue(userController.list().size() == 2);
	}

	
	@Test
	public void testGetUserController() throws Exception {
		User user1 = constructUserObject("Nora", 1237L, "Morphy", "user4");

		when(userController.show(1237L)).thenReturn(user1);

		assertTrue(userController.show(1237L).equals(user1));
	}
	
	
	@Test
	public void testUpdateUserController() throws Exception {
		User user1 = constructUserObject("Lina", 12347L, "Smith", "user1");

		when(userController.update(12347L,user1)).thenReturn(user1);

		assertTrue(userController.update(12347L,user1).equals(user1));
	}
	
	
	
	@Test
	public void testSaveUserController() throws Exception {
		User user1 = constructUserObject("Adam", 1236L, "Jones", "user3");

		when(userController.save(user1)).thenReturn(user1);

		assertTrue(userController.save(user1).equals(user1));
	}

	
	

	@Test
	public void testDeleteUserController() throws Exception {
		User user1 = constructUserObject("Post3Type", 1234L, "Content3", "user3");

		userController.save(user1);

		userController.delete(1234L);

		assertTrue(userController.show(1234L) == null);
	}
	
	
}
