package com.cataloguetheway.center.config.services.implem;

import com.cataloguetheway.center.config.DaoTraining.CategoryDao;
import com.cataloguetheway.center.config.model.Category;
import com.cataloguetheway.center.config.services.CategoryInt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl extends CrudAllEntity<CategoryDao, Category> implements CategoryInt {

    public List<Category> CategoryByTheme(String theme){
        return entityDao.CategByTheme(theme); }

}
