package cardealer.com.controller;

import cardealer.com.daoImpl.BrandDaoImpl;
import cardealer.com.daoImpl.CarDaoImpl;
import cardealer.com.daoImpl.ModelDaoImpl;
import cardealer.com.model.Brand;
import cardealer.com.model.Car;
import cardealer.com.model.Model;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

    CarDaoImpl daoc = new CarDaoImpl();
    ModelDaoImpl daom = new ModelDaoImpl();
    BrandDaoImpl daob = new BrandDaoImpl();

     ////Get list of brands to post.   
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public @ResponseBody List<Brand> getBrands() {
        List<Brand> brands = daob.showBrands();
        return brands;

    }
    
    //Get list of models to post.
    @RequestMapping(value = "/models", method = RequestMethod.GET)
    public @ResponseBody List<Model> getModels() {
        List<Model> models = daom.showModels();
        return models;
    }
    
    //Create a new car.
    @RequestMapping(value = "/car", method = RequestMethod.POST)
    public @ResponseBody Car createCar(@RequestBody Car car){
        daoc.createCar(car);
        return car;
    }
    
    //Show cars registered.
    @RequestMapping(value = "/listcars", method = RequestMethod.GET)
    public @ResponseBody List<Car> getCars(){
        List<Car> cars = daoc.showCars();
        return cars;
    }
    
    //Update a car.
    @RequestMapping(value = "/updateCar", method = RequestMethod.PUT)
    public @ResponseBody Car updateCar(@RequestBody Car car) {
        daoc.updateCar(car);
        return car;
    }

    //Delete a car.
    @RequestMapping(value = "/deleteCar", method = RequestMethod.DELETE)
    public @ResponseBody Car deleteCar(@RequestBody Car car) {
        daoc.deleteCar(car);
        return car;
    }

}
