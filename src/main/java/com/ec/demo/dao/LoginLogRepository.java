package com.ec.demo.dao;

import com.ec.demo.domain.LoginLog;
import com.ec.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginLogRepository extends JpaRepository<LoginLog,Integer> {
    List<LoginLog> findAllByUser(User user);
}
