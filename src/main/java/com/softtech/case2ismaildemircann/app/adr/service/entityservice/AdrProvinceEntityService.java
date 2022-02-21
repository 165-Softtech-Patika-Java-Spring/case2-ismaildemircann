package com.softtech.case2ismaildemircann.app.adr.service.entityservice;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrProvinceDao;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrProvince;
import com.softtech.case2ismaildemircann.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AdrProvinceEntityService extends BaseEntityService<AdrProvince, AdrProvinceDao>{

    public AdrProvinceEntityService(AdrProvinceDao dao) {
        super(dao);
    }

    public AdrProvince findByCountryIdAndLicensePlate(Long countryId, String licensePlate) {

        return getDao().findByCountryIdAndLicensePlate(countryId, licensePlate);
    }
}