package com.example.blog_dos_devs.controller.mapper;

import com.example.blog_dos_devs.controller.dto.BlogUserDTO;
import com.example.blog_dos_devs.model.BlogUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogUserMapper {
    BlogUser toEntity(BlogUserDTO dto);
    BlogUserDTO toDTO(BlogUser entity);
}
