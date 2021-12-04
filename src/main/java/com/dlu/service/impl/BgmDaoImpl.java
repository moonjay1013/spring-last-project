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

    @Override
    public Bgm getById(Integer id) {
        return bgmDao.getById(id);
    }

    @Override
    public void delBgm(Integer id) {
        Bgm bgm = bgmDao.getById(id);
        bgmDao.delete(bgm);
    }

    @Override
    public void updateBgm(String address, String musicName, String author, Integer id) {
        bgmDao.updateBgmAddress(address, musicName, author, id);
    }
}
