package cardealer.com.model;

public class Car {
    
    private int idCar;
    private Brand brand;
    private Model model;
    private String price;
    private String year;

    public Car(){
        
        brand = new  Brand();
        model = new Model();
        
    }
    

    public int getIdcar() {
        return idCar;
    }

    public void setIdcar(int idCar) {
        this.idCar = idCar;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    
    
    
}
