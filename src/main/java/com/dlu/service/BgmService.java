package com.dlu.service;

import com.dlu.pojo.Bgm;

import java.util.List;

/**
 * @author moonjay
 */
public interface BgmService {
    List<Bgm> findAll();

    void addBgm(Bgm bgm);

    void delBgm(Integer id);
}
