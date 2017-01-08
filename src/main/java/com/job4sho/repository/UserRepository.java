package com.job4sho.repository;

import com.job4sho.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nsovo on 2016/12/30.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
