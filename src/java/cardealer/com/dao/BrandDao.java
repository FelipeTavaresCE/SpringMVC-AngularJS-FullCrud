package cardealer.com.dao;

import cardealer.com.model.Brand;
import java.util.List;

public interface BrandDao {
    
    public boolean createBrand(Brand brand);
    public boolean updateBrand(Brand brand);
    public boolean deleteBrand(Brand brand);
    public List<Brand> showBrands();
    public boolean brandVerification(Brand brand);
}
