package in.strikes.springJDBCDemo.repository;

import in.strikes.springJDBCDemo.model.Student;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum)throws SQLException {
        Student student = new Student();

        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setAge(rs.getInt("age"));

        return student;

    }
}

//No need of this because we have already created different class for this section now we are using that.
//private Student mapRow(ResultSet resultSet) throws SQLException {
//    Student student = new Student();
//
//    student.setId(resultSet.getLong("id"));
//    student.setName(resultSet.getString("name"));
//    student.setEmail(resultSet.getString("email"));
//    student.setAge(resultSet.getInt("age"));
//
//    return student;
//}