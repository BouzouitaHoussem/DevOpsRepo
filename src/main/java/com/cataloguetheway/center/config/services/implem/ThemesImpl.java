package com.cataloguetheway.center.config.services.implem;

import com.cataloguetheway.center.config.DaoTraining.ThemeDao;
import com.cataloguetheway.center.config.model.Themes;
import com.cataloguetheway.center.config.services.ThemesInt;
import org.springframework.stereotype.Service;


@Service
public class ThemesImpl extends CrudAllEntity<ThemeDao,Themes> implements ThemesInt {

}
