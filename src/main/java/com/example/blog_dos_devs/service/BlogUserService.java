package com.example.blog_dos_devs.service;

import com.example.blog_dos_devs.dao.BlogUserDAO;
import com.example.blog_dos_devs.model.BlogUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogUserService {
    private final BlogUserDAO blogUserDAO;

    public BlogUser saveBlogUser(BlogUser user) {
        return blogUserDAO.save(user);
    }
}
