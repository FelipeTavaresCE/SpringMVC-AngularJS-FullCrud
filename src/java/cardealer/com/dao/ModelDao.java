package cardealer.com.dao;

import cardealer.com.model.Model;
import java.util.List;

public interface ModelDao {
    
    public boolean createModel(Model model);
    public boolean updateModel(Model model);
    public boolean deleteModel(Model model);
    public List<Model> showModels();
    public boolean modelVerification(Model model);
    
    
}
