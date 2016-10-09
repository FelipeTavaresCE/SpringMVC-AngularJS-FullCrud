package cardealer.com.daoImpl;

import cardealer.com.dao.BrandDao;
import cardealer.com.model.Brand;
import cardealer.com.util.db;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDaoImpl implements BrandDao {

    @Override
    public boolean createBrand(Brand brand) {
        try {
            Connection con = db.getDb();
            String query = "{CALL brand__createBrand(?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setString(1, brand.getNameBrand());

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
    public boolean updateBrand(Brand brand) {
        try {
            Connection con = db.getDb();
            String query = "{CALL brand__updateBrand(?,?)}";
            CallableStatement ptmt = con.prepareCall(query);
            
            ptmt.setString(1, brand.getNameBrand());
            ptmt.setInt(2, brand.getIdBrand());
            
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
    public boolean deleteBrand(Brand brand) {
        try {
            Connection con = db.getDb();
            String query = "{CALL brand__deleteBrand(?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setInt(1, brand.getIdBrand());

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
    public List<Brand> showBrands() {
        try {
            Connection con = db.getDb();
            String query = "{CALL brand__showBrands}";
            CallableStatement ptmt = con.prepareCall(query);
            List<Brand> brands = new ArrayList<Brand>();

            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand();
                brand.setIdBrand(rs.getInt("idbrand"));
                brand.setNameBrand(rs.getString("nameBrand"));

                brands.add(brand);
            }
            rs.close();
            ptmt.close();
            return brands;
        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public boolean brandVerification(Brand brand) {
        try {
            Connection con = db.getDb();
            String query = "{CALL brand__brandVerification(?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setString(1, brand.getNameBrand());
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
