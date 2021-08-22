package students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	//Method for retrieving all students from the database
	public List<Students> getAllStudents(){
		List<Students> students = new ArrayList<>();
		
		studentRepository.findAll().forEach(students::add);
		return students;
	}
	
	//Method for adding student to the database
	public void addStudent(Students student) {
		studentRepository.save(student);
	}
	
	//Method for getting student by ID
	public Optional<Students> getStudent(String id){
		return studentRepository.findById(id);
	}
	
	//Method for updating student record
	public void updateStudent(String id, Students student) {
		studentRepository.save(student);
	}
	
	//Method to delete studet record
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}
}
