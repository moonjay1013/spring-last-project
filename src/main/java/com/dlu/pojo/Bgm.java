package com.dlu.pojo;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

/**
 * @author moonjay
 */

@ApiModel(value = "BGM实体类", description = "bgm信息描述")
@Entity(name = "bgm")
public class Bgm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 64)
    private Integer id;
    @Column(nullable = false)
    private String author;
    @Column(name = "music_name", nullable = false)
    private String musicName;
    @Column(nullable = false)
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
