package ej;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Modelo {
    String url = "localhost";
    String dbName = "codigo";
    private String jdbcDriver;
    private String urlRoot;

    private ActionListener listener;

    public Modelo() {
        jdbcDriver = "com.mysql.cj.jdbc.Driver";
        urlRoot = "jdbc:mysql://" + url + "/";

        listener = null;

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            reportException(e.getMessage());
        }

    }

    public String getCode(char letra){
        String rawCode="";
        String code="";
        try {

            Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
            Statement stmt = con.createStatement();
            stmt.execute("SELECT traduccion FROM codigo.representacion WHERE caracter='"+letra+"';");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                //System.out.println(rs.getString(1));
                rawCode=rs.getString(1);
            }
            con.close();
        } catch (SQLException e) {
            reportException(e.getMessage());
        }
        for(char c : rawCode.toCharArray()){

            try {
                Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
                Statement stmt = con.createStatement();
                stmt.execute("SELECT traduccion FROM codigo.representacion WHERE caracter='"+c+"';");
                ResultSet rs = stmt.getResultSet();
                while (rs.next()) {
                    code=code+rs.getString(1);
                }
                con.close();
            } catch (SQLException e) {
                reportException(e.getMessage());
            }


        }

        return code;
    }

    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }
}
