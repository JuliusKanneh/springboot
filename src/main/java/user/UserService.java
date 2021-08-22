package user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import location.Location;

@Service
public class UserService {
	
	User user1 = new User(
			"u1", 
			"Jany", 
			"Lawrence",
			new Location("l1", "Lagos"),
			"Jany@gmail.com");
			
	User user2 = new User(
			"u2", 
			"Jadon", 
			"Mills",
			new Location("l2", "Asaba"),
			"Jadon@gmail.com");
	
	//private List<User> users = Arrays.asList(user1, user2); //storing record in list collection as arrays
	private List<User> users = new ArrayList<>(Arrays.asList(user1, user2)); //use this because we want to be able to create new objects.
	
	//method called by the controller to display records of ArrayList on the webpage. 
	public List<User> getAllUsers(){
		return users;
	}
	
	//finding record by id using the stream API. Filtering the array of the location List collection
	public User getUser(String id) {
		User user = users.stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		return user;
	}
	
	//using the POST method to create objects
	public void addUser(User user) {
		users.add(user);
	}
	
	//business logic to update the location list
	public void updateUser(String id, User user) {
		for(int i = 0; i < users.size(); i++) {
			//getting the objects from the lists of users according to the index of the loop (i) and 
			//and saving it in an object of the User class
			User u = users.get(i);
			if (u.getId().equals(id)) {
				users.set(i, user);
			}
		}
	}
	
	//delete method
	public void deleteUser(String id) {
		users.removeIf(t -> t.getId().equals(id));
	}
}
