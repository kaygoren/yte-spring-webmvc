package yte.spring.webmvc;

import org.junit.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import yte.spring.webmvc.entity.Comment;
import yte.spring.webmvc.entity.Post;

import java.net.URI;
import java.util.Arrays;

public class RestTemplateTest {

	private static final String BASE_URL =
			"https://jsonplaceholder.typicode.com/";

	private RestTemplate restTemplate = new RestTemplate();

	@Test
	public void getAllPosts() {
		URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.pathSegment("posts")
				.build()
				.toUri();

		RequestEntity requestEntity = RequestEntity.get(uri).build();

		ResponseEntity<Post[]> responseEntity = restTemplate
				.exchange(requestEntity, Post[].class);

		System.out.println(Arrays.asList(responseEntity.getBody()));
	}

	@Test
	public void getSinglePost() {
		URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.pathSegment("posts", "2")
				.build()
				.toUri();

		RequestEntity requestEntity = RequestEntity.get(uri).build();

		ResponseEntity<Post> responseEntity = restTemplate
				.exchange(requestEntity, Post.class);

		System.out.println(responseEntity.getBody());
	}

	@Test
	public void addPost() {
		URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.pathSegment("posts")
				.build()
				.toUri();

		RequestEntity requestEntity = RequestEntity.post(uri)
				.body(new Post(null, null,
						"Hebele", "Hubele"));

		ResponseEntity<Post> responseEntity = restTemplate
				.exchange(requestEntity, Post.class);

		System.out.println(responseEntity.getBody());
	}

	@Test
	public void getPostsByUserId() {
		URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.pathSegment("posts")
				.queryParam("userId", "2")
				.build()
				.toUri();

		RequestEntity requestEntity = RequestEntity.get(uri).build();

		ResponseEntity<Post[]> responseEntity = restTemplate
				.exchange(requestEntity, Post[].class);

		System.out.println(Arrays.asList(responseEntity.getBody()));
	}

	@Test
	public void addComment() {
		URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.pathSegment("posts", "2", "comments")
				.build()
				.toUri();

		RequestEntity requestEntity = RequestEntity.post(uri)
				.body(new Comment(null, 2L, "Hebeke",
						"fasa@ea.com", "ada"));

		ResponseEntity<Comment> responseEntity = restTemplate
				.exchange(requestEntity, Comment.class);

		System.out.println(responseEntity.getBody());

	}

	@Test
	public void getPostComments() {
		URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.pathSegment("posts", "2", "comments")
				.build()
				.toUri();
		RequestEntity requestEntity = RequestEntity.get(uri).build();

		ResponseEntity<Comment[]> responseEntity = restTemplate
				.exchange(requestEntity, Comment[].class);

		System.out.println(Arrays.asList(responseEntity.getBody()));

	}

	@Test
	public void updateComment() {
		URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.pathSegment("comments", "5")
				.build()
				.toUri();

		RequestEntity requestEntity = RequestEntity.put(uri)
				.body(new Comment(5L, null, "Hebeke",
						"fasa@ea.com", "ada"));

		ResponseEntity<Comment> responseEntity = restTemplate
				.exchange(requestEntity, Comment.class);

		System.out.println(responseEntity.getBody());

	}

	@Test
	public void deletePost() {
		URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.pathSegment("posts", "1")
				.build()
				.toUri();

		RequestEntity requestEntity = RequestEntity.delete(uri).build();

		ResponseEntity<Void> responseEntity = restTemplate
				.exchange(requestEntity, Void.class);
	}
}
