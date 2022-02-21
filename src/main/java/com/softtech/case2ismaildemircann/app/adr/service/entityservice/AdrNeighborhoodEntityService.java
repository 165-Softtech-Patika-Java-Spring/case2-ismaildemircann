package com.softtech.case2ismaildemircann.app.adr.service.entityservice;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrDistrictDao;
import com.softtech.case2ismaildemircann.app.adr.dao.AdrNeighborhoodDao;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrDistrict;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrNeighborhood;
import com.softtech.case2ismaildemircann.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdrNeighborhoodEntityService extends BaseEntityService<AdrNeighborhood, AdrNeighborhoodDao> {

    public AdrNeighborhoodEntityService(AdrNeighborhoodDao dao) {
        super(dao);
    }

    public List<AdrNeighborhood> findAllByDistrictId(Long id) {

        return getDao().findAllByDistrictId(id);
    }
}