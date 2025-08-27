package com.example.blog_dos_devs.controller;
import com.example.blog_dos_devs.controller.dto.BlogUserDTO;
import com.example.blog_dos_devs.controller.mapper.BlogUserMapper;
import com.example.blog_dos_devs.model.BlogUser;
import com.example.blog_dos_devs.service.BlogUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/blog-users")
@RequiredArgsConstructor
public class BlogUserController implements GenericController {
    private final BlogUserService blogUserService;
    private final BlogUserMapper blogUserMapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody BlogUserDTO dto) {
        BlogUser blogUserEntity = blogUserMapper.toEntity(dto);
        blogUserService.saveBlogUser(blogUserEntity);
        URI location = generateHeaderLocation(blogUserEntity.getId());
        return ResponseEntity.created(location).build();
    }

}
