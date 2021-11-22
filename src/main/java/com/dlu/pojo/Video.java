package com.dlu.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moonjay
 */

@Entity(name = "videos")
@ApiModel(value = "视频实体类", description = "视频信息描述")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "audio_id")
    private Integer audioId;
    @Column(name = "video_desc", length = 128)
    private String videoDesc;
    @Column(name = "video_path", nullable = false)
    private String videoPath;
    @Column(name = "video_seconds", precision = 6, scale = 2)
    /** precision和scale属性只在BigDecimal类型中有效*/
    private Float videoSeconds;
    @Column(name = "video_width")
    private Integer videoWidth;
    @Column(name = "video_height")
    private Integer videoHeight;
    @Column(name = "cover_path", nullable = false)
    private String coverPath;
    @Column(name = "like_counts")
    private Long likeCounts;
    private Integer status;
    @ApiModelProperty(value = "创建时间（datetime）")
    @Column(name = "create_time", nullable = false)
    private String crateTime;
    // 直接将java.util.Date存入数据库是不行的！


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

    public Integer getAudioId() {
        return audioId;
    }

    public void setAudioId(Integer audioId) {
        this.audioId = audioId;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public Float getVideoSeconds() {
        return videoSeconds;
    }

    public void setVideoSeconds(Float videoSeconds) {
        this.videoSeconds = videoSeconds;
    }

    public Integer getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
    }

    public Integer getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public Long getLikeCounts() {
        return likeCounts;
    }

    public void setLikeCounts(Long likeCounts) {
        this.likeCounts = likeCounts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(String crateTime) {
        this.crateTime = crateTime;
    }
}
