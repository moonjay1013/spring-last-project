package com.dlu.pojo;

import javax.persistence.*;

/**
 * @author moonjay
 */

@Entity(name = "users_fans")
public class UserFan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 64)
    private Integer id;
    @Column(name = "user_id", length = 64, nullable = false)
    private Integer userId;
    @Column(name = "fan_id", length = 64, nullable = false)
    private Integer fanId;

}
