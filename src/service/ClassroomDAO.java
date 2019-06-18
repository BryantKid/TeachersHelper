package service;

import java.util.List;


import entity.Classroom;

public interface ClassroomDAO {
	
	public List<Classroom> queryAllClassroom();
	

	
	public boolean addClassroom(Classroom classroom);
	
	public boolean deleteClassroom(int cid);
	
}
