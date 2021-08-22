package students;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	//rout for getAllStudents
	@RequestMapping(value = "/students")
	public List<Students> getAllStudets(){
		return studentService.getAllStudents();
	}
	
	//rout for getting students by ID on the page
	@RequestMapping(value = "/students/{id]")
	public Optional<Students> getStudent(@PathVariable String id) {
		return studentService.getStudent(id);
	}
	
	//rout for adding student to the db
	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public void addStudent(@RequestBody Students student) {
		studentService.addStudent(student);
	}
	
	//rout for updating a student record in the db
	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public void updateStudent(@RequestBody Students student, @PathVariable String id) {
		studentService.updateStudent(id, student);
	}
	
	//route to delete a student record
	@RequestMapping(value = "/students/{id]", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
	}
}
