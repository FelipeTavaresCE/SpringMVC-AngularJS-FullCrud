package cardealer.com.controller;

import cardealer.com.daoImpl.BrandDaoImpl;
import cardealer.com.model.Brand;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BrandController {

    BrandDaoImpl dao = new BrandDaoImpl();

    /**
     *
     * Add a new brand to the database after getting the parameters that come
     * from AngularJS controller. Will have to do some sort of validation here
     * to check whether there's already a brand with the same name or not. If
     * there's one, it will be verified in the database and won't let pass to
     * the "dao.createBrand(brand);". *
     *
     */
    
    @RequestMapping(value = "/brand", method = RequestMethod.POST)
    public @ResponseBody Brand createBrand(@RequestBody Brand brand) {
        if (!dao.brandVerification(brand)) {
            dao.createBrand(brand);
        }
        return brand;
    }

    //Send via get to AngularJS controller a list of brands already created. Nothing unusual though.
    @RequestMapping(value = "/listbrands", method = RequestMethod.GET)
    public @ResponseBody List<Brand> listBrands() {
        List<Brand> brands = dao.showBrands();
        return brands;
    }

    //Update a brand using PUT method. Get the full object coming from AngualrJS controller so that it can be sent to the DAO class to do database update.
    @RequestMapping(value = "/updateBrand", method = RequestMethod.PUT)
    public @ResponseBody Brand updateBrand(@RequestBody Brand brand) {
        if (!dao.brandVerification(brand)) {
            dao.updateBrand(brand);
        }
        return brand;
    }

    //Delete brand using DELETE method. Works simply like the UPDATE.
    @RequestMapping(value = "/deleteBrand", method = RequestMethod.DELETE)
    public @ResponseBody Brand deleteBrand(@RequestBody Brand brand) {
        dao.deleteBrand(brand);
        return brand;
    }

}
