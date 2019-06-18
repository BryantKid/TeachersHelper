package service;

import java.util.List;

import entity.Course;

public interface CourseDAO {
	public List<Course> queryAllCourse();
	
	public List<Course> queryCourseByClassroom(String cscn);
	
	public List<Course> queryCourseByTeachername(String ctn);
	
	public List<Course> queryCourseByCoursename(String csname);
	
	public boolean addCourse(Course course);
	
	public boolean deleteCourse(int csid);
	
	public Course queryCourseByCsid(int csid);

    public boolean updateCourse(Course c);
}
