package com.job4sho.repository;

import com.job4sho.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nsovo on 2016/12/31.
 */
public interface JobRepository extends JpaRepository<Job, Long> {
}
