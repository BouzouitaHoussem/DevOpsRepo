package com.cataloguetheway.center.config.DaoTraining;

import com.cataloguetheway.center.config.model.Themes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("ThemeDao")
public interface ThemeDao extends JpaRepository<Themes,Integer>,JpaSpecificationExecutor<Themes> {
}
