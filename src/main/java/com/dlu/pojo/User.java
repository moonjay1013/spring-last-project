package com.dlu.pojo;

import javax.persistence.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author moonjay
 */

@ApiModel(value = "用户实体类", description = "用户信息描述")
@Entity(name="users")
public class User {
    /** 主键设置为id id自增长*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 64)
    @ApiModelProperty(hidden = true,name = "id",value = "用户id（唯一）")
    /**属性描述 在swagger文档*/
    private Integer id;
    @Column(name = "username", length = 20,nullable = false)
    private String name;
    @Column(name = "password", length = 64, nullable = false)
    private String pwd;
    @Column(name = "face_image")
    private String faceImage;
    @Column(length = 20, nullable = false)
    private String nickname;
    @Column(name = "fans_counts", length = 11)
    private Integer fansCounts;
    @Column(name = "follow_counts", length = 11)
    private Integer followCounts;
    @Column(name = "receive_like_counts", length = 11)
    private Integer receiveLikes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getFansCounts() {
        return fansCounts;
    }

    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    public Integer getFollowCounts() {
        return followCounts;
    }

    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    public Integer getReceiveLikes() {
        return receiveLikes;
    }

    public void setReceiveLikes(Integer receiveLikes) {
        this.receiveLikes = receiveLikes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", faceImage='" + faceImage + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
