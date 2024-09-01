package lk.DAO;

import lk.DaoFactory;
import lk.Entity.Student;
import lk.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao{

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<Student> all = new ArrayList<>();

        ResultSet resultSet = SQLUtil.execute("select * from student");

        while (resultSet.next()){

            Student student = new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));

            all.add(student);
        }
        return all;
    }

    @Override
    public boolean save(Student entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO student VALUES (?,?,?,?)",entity.getSid(),entity.getName(),entity.getAddress(),entity.getPhone());
    }

    @Override
    public boolean update(Student entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE student SET NAME = ?, ADDRESS = ?, phone = ? WHERE SID = ?",entity.getName(),entity.getAddress(),entity.getPhone(),entity.getSid());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("delete from student where SID=?",id);
    }
}
