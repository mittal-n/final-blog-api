package com.blog.api.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.blog.api.controller.PostController;
import com.blog.api.domain.Comment;
import com.blog.api.domain.Post;

public class PostControllerTest {
	private PostController postController = mock(PostController.class);

	private Post constructPostObject(String type, Long id, String content, String user) {
		Comment comment = new Comment();
		comment.setText("Post Comments");
		comment.setId(1234L);

		List<Comment> comments = new ArrayList<Comment>();
		comments.add(comment);

		Post post = new Post();

		post.setId(id);
		post.setType(type);
		post.setContent(content);
		post.setComments(comments);
		post.setUsername(user);

		return post;
	}

	@Test
	public void testListPostController() throws Exception {
		Post post1 = constructPostObject("Post1Type", 1234L, "Content1", "user1");
		Post post2 = constructPostObject("Post2Type", 1235L, "Content2", "user2");

		when(postController.list()).thenReturn(Arrays.asList(post1, post2));

		assertTrue(postController.list().size() == 2);
	}

	@Test
	public void testSavePostController() throws Exception {
		Post post1 = constructPostObject("Post3Type", 1236L, "Content3", "user3");

		when(postController.save(post1)).thenReturn(post1);

		assertTrue(postController.save(post1).equals(post1));
	}

	@Test
	public void testGetPostController() throws Exception {
		Post post1 = constructPostObject("Post4Type", 1237L, "Content4", "user4");

		when(postController.get(1237L)).thenReturn(post1);

		assertTrue(postController.get(1237L).equals(post1));
	}

	@Test
	public void testUpdatePostController() throws Exception {
		Post post1 = constructPostObject("Post6Type", 12347L, "Content1", "user1");

		when(postController.update(post1)).thenReturn(post1);

		assertTrue(postController.update(post1).equals(post1));
	}

	@Test
	public void testDeletePostController() throws Exception {
		Post post1 = constructPostObject("Post3Type", 1234L, "Content3", "user3");

		postController.save(post1);

		postController.delete(1234L);

		assertTrue(postController.get(1234L) == null);
	}
}
