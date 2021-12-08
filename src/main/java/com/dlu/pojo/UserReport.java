package com.dlu.pojo;

import javax.persistence.*;

/**
 * @author moonjay
 */

@Entity(name = "users_report")
public class UserReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 64)
    private Integer id;
    @Column(name = "dealt_user_id", length = 64, nullable = false)
    private Integer userId;
    @Column(name = "dealt_video_id", length = 64, nullable = false)
    private Integer videoId;
    @Column(length = 128, nullable = false)
    private String title;
    private String content;
    @Column(length = 64, nullable = false)
    private Integer uId;
    @Column(name = "create_time", nullable = false)
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserReport{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", uId=" + uId +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
