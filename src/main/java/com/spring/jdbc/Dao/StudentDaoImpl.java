package com.spring.jdbc.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate templet;

	public JdbcTemplate getTemplet() {
		return templet;
	}

	public void setTemplet(JdbcTemplate templet) {
		this.templet = templet;
	}

	@Override
	public Student getStudent(int studentId) {
		// selecting single student data

		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImp();
		Student student = this.templet.queryForObject(query, rowMapper, studentId);

		return student;
	}

	@Override
	public List<Student> getStudentDetails() {
		// getting all the details of the students

		String query = "select * from student";

		List<Student> students = this.templet.query(query, new RowMapperImp());
		return students;
	}

	@Override
	public int insert(Student student) {

		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = this.templet.update(query, student.getId(), student.getName(), student.getCity());
		return result;
	}

	@Override
	public int change(Student student) {

		// updating the data
		String query = "update student set name=?,city=? where id=?";
		int result = this.templet.update(query, student.getName(), student.getCity(), student.getId());
		return result;
	}

	@Override
	public int delete(Student student) {

		// deleting the data
		String query = "delete from student where id=?";
		int result = this.templet.update(query, student.getId());
		return result;
	}

}
