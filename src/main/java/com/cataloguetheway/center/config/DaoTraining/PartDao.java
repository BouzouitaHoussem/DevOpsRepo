package com.cataloguetheway.center.config.DaoTraining;

import com.cataloguetheway.center.config.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PartDao extends JpaRepository< Part,Integer>, JpaSpecificationExecutor<Part> {
}
