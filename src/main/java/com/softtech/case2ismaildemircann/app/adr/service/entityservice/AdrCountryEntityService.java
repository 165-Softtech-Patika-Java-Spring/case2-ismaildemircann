package com.softtech.case2ismaildemircann.app.adr.service.entityservice;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrCountryDao;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrCountry;
import com.softtech.case2ismaildemircann.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AdrCountryEntityService extends BaseEntityService<AdrCountry, AdrCountryDao> {

    public AdrCountryEntityService(AdrCountryDao dao) {
        super(dao);
    }

    public AdrCountry findByCountryCode(String countryCode){

        return getDao().findByCountryCode(countryCode);
    }
}
