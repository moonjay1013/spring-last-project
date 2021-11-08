package com.dlu.pojo;

import javax.persistence.*;
import java.util.Date;

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
    private Date createTime;
}
