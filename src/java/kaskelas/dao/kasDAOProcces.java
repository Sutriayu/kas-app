package kaskelas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kaskelas.model.Kas;
import kaskelas.model.DBConfig;

public class kasDAOProcces implements kasDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    @Override
    public List<Kas> get() {
        List<Kas> list = new ArrayList<Kas>();
        try {
            String sql = "Select * from kas";
            connection = DBConfig.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Kas ks = new Kas();
                ks.setId(resultSet.getInt("id"));
                ks.setNim(resultSet.getString("nim"));
                ks.setNama(resultSet.getString("nama"));
                ks.setTanggal(resultSet.getString("tanggal"));
                ks.setBayar(resultSet.getString("bayar"));
                list.add(ks);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Kas kas) {
        boolean flag = false;
        try {
            String sql = "Insert Into kas(nim,nama,tanggal,bayar) values(?,?,?,?)";
            connection = DBConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kas.getNim());
            preparedStatement.setString(2, kas.getNama());
            preparedStatement.setString(3, kas.getTanggal());
            preparedStatement.setString(4, kas.getBayar());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public Kas getSinggle(int id) {
        Kas kas = null;
        try {
            String sql = "select * from kas where id=?";
            connection = DBConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                kas = new Kas();
                kas.setId(resultSet.getInt("id"));
                kas.setNim(resultSet.getString("nim"));
                kas.setNama(resultSet.getString("nama"));
                kas.setTanggal(resultSet.getString("tanggal"));
                kas.setBayar(resultSet.getString("bayar"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kas;
    }

    @Override
    public boolean update(Kas kas) {
        boolean flag = false;
        try {
            String sql = "update kas set nim=?,nama=?,tanggal=?,bayar=? where id=?";
            connection = DBConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kas.getNim());
            preparedStatement.setString(2, kas.getNama());
            preparedStatement.setString(3, kas.getTanggal());
            preparedStatement.setString(4, kas.getBayar());
            preparedStatement.setInt(5, kas.getId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "delete from kas where id=?";
            connection = DBConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

}
