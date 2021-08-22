package location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
	Location location1 = new Location("l1", "Kigali");
	Location location2 = new Location("l2", "Monrovia");
	Location location3 = new Location("l3", "Singapore");
	
	//saving objects in the List<Location> collection as arrays
	//private List<Location> locations = Arrays.asList(location1, location2, location3);
	private List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3));
	
	public List<Location> getAllLocations(){
		return locations;
	}
	
	//finding record by id using the stream API. Filtering the array of the location List collection
	public Location getLocation(String id) {
		Location location = locations.stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		
		return location;
	}
	
	//add location method (business logic to add location)
	public void addLocation(Location location) {
		locations.add(location);
	}
	
	//business logic to update the location list
	public void updateLocation(String id, Location location) {
		for(int i = 0; i < locations.size(); i++) {
			//getting the objects from the lists of locations according to the index of the loop (i) 
			//and saving it in an object of the Location class
			Location l = locations.get(i);
			if(l.getId().equals(id)) {
				locations.set(i, location);
			}
		}
	}
	
	//delete method 
	public void deleteLocation(String id) {
		locations.removeIf(l -> l.getId().equals(id));
	}
}
