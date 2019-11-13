package com.github.abigail830.oauthserver.infrastructure.mapper;

import com.github.abigail830.oauthserver.infrastructure.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Select("SELECT * " +
            "FROM ROLE " +
            "LEFT JOIN USER_ROLE on USER_ROLE.role_id = ROLE.id " +
            "WHERE id = '${id}'")
    List<RoleEntity> getRolesByUserId(Long id);
}
