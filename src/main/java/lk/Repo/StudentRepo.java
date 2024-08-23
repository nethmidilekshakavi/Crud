package lk.Repo;

import lk.dbConnection.DBConnection;
import lk.model.StudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentRepo {

    public static boolean saveStudent(StudentModel studentModel) throws SQLException {

        try {

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student VALUES (?,?,?,?)");

        preparedStatement.setString(1, String.valueOf(studentModel.getSid()));
        preparedStatement.setString(2, studentModel.getName());
        preparedStatement.setString(3, studentModel.getAddress());
        preparedStatement.setString(4, String.valueOf(studentModel.getPhone()));

        int i;
        i = preparedStatement.executeUpdate();
        return i > 0;
    } catch (SQLException e) {
           e.fillInStackTrace();
        }
        return false;
    }

    public static boolean updateStudent(StudentModel studentModel){

        try{

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET NAME = ?, ADDRESS = ?, phone = ? WHERE SID = ?");

            preparedStatement.setString(1,studentModel.getName());
            preparedStatement.setString(2,studentModel.getAddress());
          preparedStatement.setString(3, String.valueOf(studentModel.getPhone()));
          preparedStatement.setString(4, String.valueOf(studentModel.getSid()));

            return preparedStatement.executeUpdate() > 0;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static boolean deleteStudent(String id){

        try{

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where SID=?");

            preparedStatement.setString(1,id);


            return preparedStatement.executeUpdate() > 0;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static ArrayList<StudentModel> getAll() throws SQLException {

        ArrayList<StudentModel> studentModel = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
        ResultSet resultSet = preparedStatement.executeQuery();

        try{

            while (resultSet.next()){

                StudentModel list = new StudentModel(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
                studentModel.add(list);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentModel;
    }

}
