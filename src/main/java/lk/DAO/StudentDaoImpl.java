package lk.DAO;

import lk.DaoFactory;
import lk.Entity.Student;
import lk.SQLUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao{

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Student entity) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO student VALUES (?,?,?,?)",entity.getSid(),entity.getName(),entity.getAddress(),entity.getAddress());
    }

    @Override
    public boolean update(Student entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("delete from student where SID=?",id);
    }
}
