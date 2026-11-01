package in.strikes.springJDBCDemo.repository;

import in.strikes.springJDBCDemo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository {

//No need for this because now we are using it from data source.
//    String url = "jdbc:mysql://localhost:3306/students_db";
//    String username = "root";
//    String password = "x1x2x3x4x5";


    private JdbcTemplate jdbcTemplate;
    //We can make three different object for this class.
    //private StudentRowMapper studentRowMapper = new StudentRowMapper();
    //private RowMapper<Student> rowMapper=new StudentRowMapper();
    private RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);



    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public void createStudent(Student student) {

        String sql = """
                         INSERT INTO studentttt(name, email, age)
                         VALUES(?, ?, ?)
                         """;

        int rowAffected = jdbcTemplate.update(
                sql, student.getName(), student.getEmail(), student.getAge());

        if(rowAffected == 1) {
            System.out.println("Create Student successful");
        }
        else {
            System.out.println("Create Student failed");
        }


    }

    public void updateStudent(Student student, Long id) {
        String sql = """
                     UPDATE studentttt
                     SET name = ?,
                         email = ?,
                         age = ?
                     WHERE id = ?
                     """;


        int rowAffected=jdbcTemplate.update(
                sql, student.getName(), student.getEmail(), student.getAge(), id);
        if(rowAffected == 1) {
            System.out.println("Update operation successful");
        } else {
            System.out.println("Updation failed");
        }

    }



    public void deleteStudent(Long id) {
        String sql = """
                    DELETE from studentttt WHERE id = ?
                     """;

        int rowAffected = jdbcTemplate.update(sql, id);

        if(rowAffected == 1) {
            System.out.println("Delete operation successful");
        }
        else {
            System.out.println("Deletion failed");
        }
    }

    public Student getStudentById(Long id) {

        String sql = """
                SELECT id, name, email, age FROM studentttt
                WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<Student> getStudent() {


          String sql = """
                SELECT id, name, email, age FROM studentttt
                """;

          List<Student> students = jdbcTemplate.query(sql, rowMapper);

          return students;


    }

//    public void completeCRUD() {
//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//
//            String sql = "SELECT id, name, email, age " +
//                    "FROM studentttt where id = 7";
//
//            boolean result = statement.execute(sql);
//
//            if(result) {
//                ResultSet resultSet = statement.getResultSet();
//            }
//            else {
//                int rowAffected = statement.getUpdateCount();
//            }
//
//            connection.close();
//        }
//        catch(SQLException e) {
//            System.out.println("Database connection failed");
//            e.printStackTrace();
//        }
//    }


}