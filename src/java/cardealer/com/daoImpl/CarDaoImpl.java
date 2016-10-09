package cardealer.com.daoImpl;

import cardealer.com.dao.CarDao;
import cardealer.com.model.Car;
import cardealer.com.util.db;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    @Override
    public boolean createCar(Car car) {
        try {
            Connection con = db.getDb();
            String query = "{CALL car__createCar(?,?,?,?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setInt(1, car.getBrand().getIdBrand());
            ptmt.setInt(2, car.getModel().getIdModel());
            ptmt.setString(3, car.getPrice());
            ptmt.setString(4, car.getYear());
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
    public boolean updateCar(Car car) {
        try {
            Connection con = db.getDb();
            String query = "{CALL car__updateCar(?,?,?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setString(1, car.getPrice());
            ptmt.setString(2, car.getYear());
            ptmt.setInt(3, car.getIdCar());
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
    public boolean deleteCar(Car car) {
        try {
            Connection con = db.getDb();
            String query = "{CALL car__deleteCar(?)}";
            CallableStatement ptmt = con.prepareCall(query);

            ptmt.setInt(1, car.getIdCar());

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
    public List<Car> showCars() {
        try {
            Connection con = db.getDb();
            String query = "{CALL car__showCars}";
            CallableStatement ptmt = con.prepareCall(query);
            List<Car> cars = new ArrayList<Car>();

            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setIdCar(rs.getInt("idcar"));
                car.getBrand().setNameBrand(rs.getString("nameBrand"));
                car.getModel().setNameModel(rs.getString("nameModel"));
                car.setPrice(rs.getString("price"));
                car.setYear(rs.getString("year"));

                cars.add(car);
            }
            rs.close();
            ptmt.close();
            return cars;
        } catch (SQLException sql) {
            System.out.println(sql);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
