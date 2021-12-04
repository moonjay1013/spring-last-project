package com.dlu.service;

import com.dlu.pojo.Bgm;

import java.util.List;

/**
 * @author moonjay
 */
public interface BgmService {
    List<Bgm> findAll();

    void addBgm(Bgm bgm);

    Bgm getById(Integer id);

    void delBgm(Integer id);

    void updateBgm(String address,String musicName,String author, Integer id);
}
