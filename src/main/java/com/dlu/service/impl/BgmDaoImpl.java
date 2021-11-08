package com.dlu.service.impl;

import com.dlu.dao.BgmDao;
import com.dlu.pojo.Bgm;
import com.dlu.service.BgmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BgmService")
public class BgmDaoImpl implements BgmService {
    @Autowired
    private BgmDao bgmDao;
    @Override
    public List<Bgm> findAll() {
        return bgmDao.findAll();
    }

    @Override
    public void addBgm(Bgm bgm) {
        bgmDao.save(bgm);
    }
}
