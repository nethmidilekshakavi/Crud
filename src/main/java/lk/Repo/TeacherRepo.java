package lk.Repo;

import lk.dbConnection.DBConnection;
import lk.model.TeacherModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherRepo {

    public static boolean saveTeacher(TeacherModel teacherModel) throws SQLException {

        try{
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teacher VALUES (?,?,?,?)");

            preparedStatement.setString(1, String.valueOf(teacherModel.getTid()));
            preparedStatement.setString(2,teacherModel.getName());
            preparedStatement.setString(3,teacherModel.getAddress());
            preparedStatement.setString(4, String.valueOf(teacherModel.getPhone()));

            int i;

            i = preparedStatement.executeUpdate();
           return i > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }



    public static boolean updateStudent(TeacherModel teacherModel) throws SQLException {

        try{
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE teacher SET name = ?, address = ?, phone = ? WHERE id = ?");

            preparedStatement.setString(1,teacherModel.getName());
            preparedStatement.setString(2,teacherModel.getAddress());
            preparedStatement.setString(3, String.valueOf(teacherModel.getPhone()));
            preparedStatement.setString(4, String.valueOf(teacherModel.getTid()));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean deleteTeacher(String id){
        try{

            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM teacher WHERE id = ?");

            preparedStatement.setString(1,id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
