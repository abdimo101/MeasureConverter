package com.testing.measureconverter.Measures;

import java.sql.*;

public class Grades {

    private String grade;
    private String result;

    public Grades(String grade) {
        this.grade = grade;
        this.result = null;
    }

    public String convertToAmerican(){
        return convert("cDenmark", "cUSA");
    }


    private String convert(String convertFrom, String convertTo) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/converter", "root", "ppf46jrd");
            String query = "SELECT " + convertTo + " FROM grades WHERE " + convertFrom + " = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.grade);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                this.result = resultSet.getString(convertTo);
                return this.result;
            } else {
                return "Grade not found";
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return "Error connection to the database";
        }
    }

}
