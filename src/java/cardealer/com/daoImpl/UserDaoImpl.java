package cardealer.com.daoImpl;

import cardealer.com.dao.UserDao;
import cardealer.com.model.User;
import cardealer.com.util.db;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean createUser(User user) {
        try {
            Connection con = db.getDb();
            String query = "{CALL user__createUser(?,?,?,?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setString(1, user.getName());
            ptmt.setString(2, user.getLastname());
            ptmt.setString(3, user.getPassword());
            ptmt.setString(4, user.getEmail());

            ptmt.execute();
            con.close();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public User loginUser(User user) {
        try {
            Connection con = db.getDb();
            String query = "{CALL user__login(?,?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setString(1, user.getEmail());
            ptmt.setString(2, user.getPassword());

            ResultSet rs = ptmt.executeQuery();

            while (rs.next()) {

                user.setIduser(rs.getInt("iduser"));
                user.setName(rs.getString("name"));
                user.setLastname(rs.getString("lastname"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));

                return user;

            }
            rs.close();
            ptmt.close();

        } catch (SQLException sql) {
            System.out.println(sql);

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;

    }

}
