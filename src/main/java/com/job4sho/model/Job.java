package com.job4sho.model;

import com.job4sho.core.BaseEntity;

import javax.persistence.*;
import lombok.Data;

/**
 * Created by Nsovo on 2016/12/25.
 */
@Data
@Entity
public class Job extends BaseEntity {
    private static final long serialVersionUID = 8478960134455094377L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
