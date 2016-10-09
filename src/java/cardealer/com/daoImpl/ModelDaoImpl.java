package cardealer.com.daoImpl;

import cardealer.com.dao.ModelDao;
import cardealer.com.model.Brand;
import cardealer.com.model.Model;
import cardealer.com.util.db;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDaoImpl implements ModelDao {

    @Override
    public boolean createModel(Model model) {
        try {
            
            Brand brand = new Brand();
            
            Connection con = db.getDb();
            String query = "{CALL model__createModel(?,?)}";
            CallableStatement ptmt = con.prepareCall(query);
            
            
            ptmt.setString(1, model.getNameModel());
            ptmt.setInt(2, model.getBrand().getIdBrand());

            ptmt.execute();
            con.close();

            return true;

        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean updateModel(Model model) {
        try {
            Connection con = db.getDb();
            String query = "{CALL model__updateModel(?,?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setString(1, model.getNameModel());
            ptmt.setInt(2, model.getIdModel());

            int ret = ptmt.executeUpdate();
            con.close();

            return true;

        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean deleteModel(Model model) {
        try {
            Connection con = db.getDb();
            String query = "{CALL model__deleteModel(?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setInt(1, model.getIdModel());

            ptmt.execute();
            ptmt.close();

            return true;

        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public List<Model> showModels() {
        try {
            Connection con = db.getDb();
            String query = "{CALL model__showModels}";
            CallableStatement ptmt = con.prepareCall(query);
            List<Model> models = new ArrayList<Model>();

            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Model model = new Model();
    
                
                model.setIdModel(rs.getInt("idmodel"));
                model.setNameModel(rs.getString("nameModel"));
                model.getBrand().setNameBrand(rs.getString("nameBrand"));
                model.getBrand().setIdBrand(rs.getInt("idBrand"));

                models.add(model);
            }
            rs.close();
            ptmt.close();
            return models;
        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public boolean modelVerification(Model model) {
        try {
            Connection con = db.getDb();
            String query = "{CALL model__modelVerification(?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setString(1, model.getNameModel());
            ResultSet rs = ptmt.executeQuery();
            boolean check = false;

            while (rs.next()) {
                check = true;
            }
            rs.close();
            ptmt.close();

            return check;

        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            return false;
        } catch (SQLException sql) {
            System.out.println(sql);
            return false;
        }
    }
}
