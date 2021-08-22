package location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	
	//dependency injection application
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/locations")
	public List<Location> getAllLocations(){
		return locationService.getAllLocations();
	}
	
	//retrieve location by id
	@RequestMapping(value = "/locations/{id}")
	public Location getLocation(@PathVariable String id) {
		return locationService.getLocation(id);
	}
	
	//addLocation method
	@RequestMapping(method = RequestMethod.POST, value = "/locations")
	public void addLocation(@RequestBody Location location) {
		locationService.addLocation(location);
	}
	
	//method to update location
	@RequestMapping(method = RequestMethod.PUT, value = "/locations/{id}")
	public void updateLocation(@PathVariable String id, @RequestBody Location location) {
		locationService.updateLocation(id, location);
	}
	
	//method to delete a location
	@RequestMapping(value="/locations/{id}", method = RequestMethod.DELETE)
	public void deleteLocation(@PathVariable String id) {
		locationService.deleteLocation(id);
	}
}
