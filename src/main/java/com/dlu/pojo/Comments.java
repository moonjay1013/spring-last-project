package com.dlu.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * @author moonjay
 */

@Entity(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "from_user_id",nullable = false)
    private Integer fromUserId;
    @Column(name = "video_id",nullable = false)
    private Integer videoId;
    @Column(nullable = false)
    private String comment;
    @Column(name = "create_time", nullable = false)
    private Date createTime;
}
