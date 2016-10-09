package cardealer.com.dao;

import cardealer.com.model.Car;
import java.util.List;

public interface CarDao {

    public boolean createCar (Car car);
    public boolean updateCar(Car car);
    public boolean deleteCar(Car car);
    public List<Car> showCars();
    
}
