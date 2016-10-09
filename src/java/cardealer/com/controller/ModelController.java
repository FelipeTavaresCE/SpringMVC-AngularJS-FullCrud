package cardealer.com.controller;

import cardealer.com.daoImpl.BrandDaoImpl;
import cardealer.com.daoImpl.ModelDaoImpl;
import cardealer.com.model.Brand;
import cardealer.com.model.Model;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModelController {

    ModelDaoImpl dao = new ModelDaoImpl();
    BrandDaoImpl daob = new BrandDaoImpl();

    //Get brands to post
    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public @ResponseBody
    List<Brand> getBrand() {
        List<Brand> brands = daob.showBrands();
        return brands;
    }

    //Create a new model and firstly verify if there's already a model with that name in the database.
    @RequestMapping(value = "/model", method = RequestMethod.POST)
    public @ResponseBody
    Model createModel(@RequestBody Model model) {
        if (!dao.modelVerification(model)) {
             dao.createModel(model);
        }
        return model;
    }

    //List of models
    @RequestMapping(value = "/listmodels", method = RequestMethod.GET)
    public @ResponseBody
    List<Model> listModels() {
        List<Model> models = dao.showModels();
        return models;
    }

    //Update a model. Will do the same verification to check if there's already that model created.
    @RequestMapping(value = "/updateModel", method = RequestMethod.PUT)
    public @ResponseBody
    Model updateModel(@RequestBody Model model) {
        if(!dao.modelVerification(model)){
            dao.updateModel(model);
        }
        return model;
    }

    //Simply delete a model. Nothing fancy.
    @RequestMapping(value = "/deleteModel", method = RequestMethod.DELETE)
    public @ResponseBody Model deleteModel(@RequestBody Model model) {
        dao.deleteModel(model);
        return model;
    }
}
