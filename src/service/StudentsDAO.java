package service;

import java.util.List;

import entity.Students;


public interface StudentsDAO {


	public List<Students> queryAllStudents();
	

	public Students queryStudentsById(String sid);
	
	
	public List<Students> queryStudentsByClassroom(String address);
	

	public boolean addStudents(Students students);
	

	public boolean updateStudents(Students students);
	

	public boolean deleteStudents(String sid);
}
