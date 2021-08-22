package post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import location.Location;
import user.User;

@Service
public class PostService {
	
	User user1 = new User(
			"u1", 
			"Timothy",
			"Belekollie",
			new Location("loc1", "Fendell Comm"),
			"belekollietim@gmail.com");
	User user2 = new User("u2", 
			"Bedell", 
			"Sandi", 
			new Location("loc2", "Kicukiro"), 
			"bsandi@gmail.com");
	
	Post post1 = new Post(
			"post1",
			"April 13, 2021", 
			user1,
			"I am making my first demo post");
	Post post2 = new Post(
			"post2", 
			"April 14, 2021",
			user2,
			"I am mkang my second demo post");
	
	//private List<Post> posts = Arrays.asList(post1, post2);
	private List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2)); //use an object of the ArrayList to be able to add to the list
	
	public List<Post> getAllPosts(){
		return posts;
	}
	
	//finding record by id using the stream API. Filtering the array of the location List collection
	public Post getPost(String id) {
		Post post = posts.stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		return post;
	}
	
	//adding posts
	public void addPost(Post post) {
		posts.add(post);
	}
	
	//business logic to update the post list
	public void updatePost(String id, Post post) {
		for(int i = 0; i < posts.size(); i++) {
			//getting the objects from the lists of posts according to the index of the loop (i) 
			//and saving it in an object of the Post class
			Post p = posts.get(i);
			if (p.getId().equals(id)) {
				posts.set(i, post);
			}
		}
	}
	
	//delete a post
	public void deletePost(String id) {
		posts.removeIf(p -> p.getId().equals(id));
	}
}
