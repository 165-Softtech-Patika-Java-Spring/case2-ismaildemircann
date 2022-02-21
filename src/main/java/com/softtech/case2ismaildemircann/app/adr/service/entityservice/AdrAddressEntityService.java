package com.softtech.case2ismaildemircann.app.adr.service.entityservice;

import com.softtech.case2ismaildemircann.app.adr.dao.AdrAddressDao;
import com.softtech.case2ismaildemircann.app.adr.entitiy.AdrAddress;
import com.softtech.case2ismaildemircann.app.adr.entitiy.results.AdrAddressResult;
import com.softtech.case2ismaildemircann.app.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AdrAddressEntityService extends BaseEntityService<AdrAddress, AdrAddressDao> {

    public AdrAddressEntityService(AdrAddressDao dao) {
        super(dao);
    }

    public void deleteById(Long id) {

        getDao().deleteById(id);
    }

    public AdrAddressResult findAddressByIdWithDetail(Long id) {

        return getDao().findAddressByIdWithDetail(id);
    }
}