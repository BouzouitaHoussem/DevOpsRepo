package com.cataloguetheway.center.config.DaoTraining;

import com.cataloguetheway.center.config.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface CategoryDao extends JpaRepository<Category,Integer>,JpaSpecificationExecutor<Category> {

    @Query("select c from Category c where c.theme = :themeValueP")
    List<Category> CategByTheme(@Param("themeValueP") String themeValue);

}
