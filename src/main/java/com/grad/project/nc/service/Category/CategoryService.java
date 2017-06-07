package com.grad.project.nc.service.Category;

import com.grad.project.nc.model.Category;
import com.grad.project.nc.model.ProductInstance;

import java.util.Collection;


public interface CategoryService {
    public Category getByProductInstanceId(Long productInstanceId);
    public Collection<Category> findByCategoryTypeName(String categoryTypeName);
    public Collection<Category> findByCategoryType(long categoryTypeId);
}
