package com.softtech.case2ismaildemircann.app.adr.service.entityservice;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrNeighborhoodDao;
import com.softtech.case2ismaildemircann.app.adr.dao.AdrStreetDao;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrNeighborhood;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrStreet;
import com.softtech.case2ismaildemircann.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdrStreetEntityService extends BaseEntityService<AdrStreet, AdrStreetDao> {

    public AdrStreetEntityService(AdrStreetDao dao) {
        super(dao);
    }

    public List<AdrStreet> findAllByNeighborhoodId(Long id) {

        return getDao().findAllByNeighborhoodId(id);
    }
}