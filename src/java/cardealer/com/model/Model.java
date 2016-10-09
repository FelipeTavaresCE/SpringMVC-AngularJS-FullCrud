package cardealer.com.model;

public class Model {
    
    private int idModel;
    private String nameModel;
    private Brand brand;
    
    public Model(){

        brand = new Brand();
    }

    public int getIdModel() {
        return idModel;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    
    
    
    
}
