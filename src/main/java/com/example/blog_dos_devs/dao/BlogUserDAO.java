package com.example.blog_dos_devs.dao;

import com.example.blog_dos_devs.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogUserDAO extends JpaRepository<BlogUser,Long> {
}
