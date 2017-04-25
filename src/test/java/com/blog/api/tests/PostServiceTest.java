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


public class PostServiceTest {

	PostService service;
	Post post;
	IdGenerator idGenerate;

	// Data Provide
	@DataProvider(name = "data")
	public Object[][] getData(Method name) {
		Object[][] obj = null;

		if (name.getName().equalsIgnoreCase("getPostsTest")) {
			obj = new Object[1][4];
			obj[0][0] = 87L;
			obj[0][1] = "content";
			obj[0][2] = "type";
			obj[0][3] = "username";
		}

		if (name.getName().equalsIgnoreCase("addTest")) {
			obj = new Object[1][4];
			obj[0][0] = 97L;
			obj[0][1] = "content1";
			obj[0][2] = "type1";
			obj[0][3] = "username1";
		}

		if (name.getName().equalsIgnoreCase("updateTest")) {
			obj = new Object[1][4];
			obj[0][0] = 97L;
			obj[0][1] = "newContent";
			obj[0][2] = "type2";
			obj[0][3] = "username1";
		}

		return obj;

	}




	// Verify getUserPost by adding one PostId
	@Test(dataProvider = "data")
	public void getPostsTest(Long id, String content, String type, String username) {
		Post post = mock(Post.class);
		
		when(post.getId()).thenReturn(id);
		//when(post.getId()).thenReturn(idGenerate.generate());
		// when(post.getUsername()).thenReturn("Nidhi");
		service = mock(PostService.class);
		when(service.getPost(id)).thenReturn(post);
		AssertJUnit.assertTrue(service.getPost(id) != null);
	}

	// Verify add method by adding one post
	@Test(dataProvider = "data")
	public void addTest(Long id, String content, String type, String username) {
		Post post = mock(Post.class);
		when(post.getId()).thenReturn(id);
		when(post.getContent()).thenReturn(content);
		when(post.getType()).thenReturn(type);
		when(post.getUsername()).thenReturn(username);


		service = mock(PostService.class);
		when(service.add(post)).thenReturn(post);
		AssertJUnit.assertTrue(service.add(post).getContent() == "content1");
	}

	// Verify update
	@Test(dataProvider = "data")
	public void updateTest(Long id, String content, String type, String username) {
		Post post = mock(Post.class);
		when(post.getId()).thenReturn(id);
		when(post.getContent()).thenReturn(content);
		when(post.getType()).thenReturn(type);
		when(post.getUsername()).thenReturn(username);


		service = mock(PostService.class);
		when(service.update(post)).thenReturn(post);
		AssertJUnit.assertTrue(service.update(post).getContent() == "newContent");
	}




}












