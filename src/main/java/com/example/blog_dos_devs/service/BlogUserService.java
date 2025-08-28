package com.example.blog_dos_devs.service;

import com.example.blog_dos_devs.dao.BlogUserDAO;
import com.example.blog_dos_devs.model.BlogUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogUserService {
    private final BlogUserDAO blogUserDAO;

    public BlogUser saveBlogUser(BlogUser user) {
        return blogUserDAO.save(user);
    }

    public List<BlogUser> getAllBlogUsers() {
        return blogUserDAO.findAll();
    }

    public void updateBlogUser(BlogUser user) {
        blogUserDAO.save(user);
    }

    public Optional<BlogUser> getBlogUserById(Long id) {
        return blogUserDAO.findById(id);
    }
}
