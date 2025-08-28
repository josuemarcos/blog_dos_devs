package com.example.blog_dos_devs.controller;
import com.example.blog_dos_devs.controller.dto.BlogUserDTO;
import com.example.blog_dos_devs.controller.mapper.BlogUserMapper;
import com.example.blog_dos_devs.model.BlogUser;
import com.example.blog_dos_devs.service.BlogUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<BlogUserDTO>> findAll() {
        List<BlogUser> blogUsersEntity = blogUserService.getAllBlogUsers();
        List<BlogUserDTO> blogUsersDTO = blogUsersEntity
                .stream()
                .map(blogUserMapper::toDTO)
                .toList();
        return ResponseEntity.ok(blogUsersDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<BlogUserDTO> findById(@PathVariable Long id) {
        return blogUserService.getBlogUserById(id)
                .map(
                        blogUser -> {
                            BlogUserDTO blogUserDTO = blogUserMapper.toDTO(blogUser);
                            return ResponseEntity.ok(blogUserDTO);
                        }
                ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@RequestBody BlogUserDTO dto, @PathVariable Long id) {
        return blogUserService.getBlogUserById(id)
                .map(
                        blogUser -> {
                            blogUser.setName(dto.name());
                            blogUser.setEmail(dto.email());
                            blogUserService.saveBlogUser(blogUser);
                            return  ResponseEntity.ok().build();
                        }
                ).orElseGet(() -> ResponseEntity.notFound().build());
    }

   // @DeleteMapping("{id}")




}
