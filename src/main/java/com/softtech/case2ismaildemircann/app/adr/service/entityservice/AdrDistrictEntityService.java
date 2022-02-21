package com.softtech.case2ismaildemircann.app.adr.service.entityservice;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrDistrictDao;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrDistrict;
import com.softtech.case2ismaildemircann.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdrDistrictEntityService extends BaseEntityService<AdrDistrict, AdrDistrictDao> {

    public AdrDistrictEntityService(AdrDistrictDao dao) {
        super(dao);
    }

    public List<AdrDistrict> findAllByProvinceId(Long id) {

        return getDao().findAllByProvinceId(id);
    }
}