package com.grad.project.nc.controller.api.admin;

import com.grad.project.nc.controller.api.dto.FrontendProductType;
import com.grad.project.nc.model.ProductType;
import com.grad.project.nc.service.product.type.ProductTypeService;
import com.grad.project.nc.support.validation.ProductTypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminProductTypesController {

    private final ProductTypeService productTypeService;
    private final ProductTypeValidator productTypeValidator;

    @Autowired
    public AdminProductTypesController(ProductTypeService productTypeService, ProductTypeValidator productTypeValidator) {
        this.productTypeService = productTypeService;
        this.productTypeValidator = productTypeValidator;
    }

    @RequestMapping(value = "/productTypes/add", method = RequestMethod.POST)
    public Map<String, String> addProductType(@RequestBody FrontendProductType frontendProductType) {
        productTypeValidator.validate(frontendProductType);

        ProductType productType = frontendProductType.toModel();
        productTypeService.add(productType);

        return new HashMap<String, String>() {{
            put("status", "success");
            put("message", "Product type was successfully added");
            put("id", productType.getProductTypeId().toString());
        }};
    }

    @RequestMapping(value = "/productTypes/update", method = RequestMethod.POST)
    public Map<String, String> updateProductType(@RequestBody FrontendProductType frontendProductType) {
        productTypeValidator.validate(frontendProductType);

        ProductType productType = frontendProductType.toModel();
        productTypeService.update(productType);

        return new HashMap<String, String>() {{
            put("status", "success");
            put("message", "Product type was successfully updated");
            put("id", productType.getProductTypeId().toString());
        }};
    }
}
