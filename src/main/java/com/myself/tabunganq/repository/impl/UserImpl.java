package com.myself.tabunganq.repository.impl;

import com.myself.tabunganq.configuration.variable.ConstantVariable;
import com.myself.tabunganq.entity.UserEntity;
import com.myself.tabunganq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserImpl implements UserRepository {

    @Qualifier(ConstantVariable.BEAN_JDBC_SUPABASE)
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String queryFindByEmail = "select * from m_user where email = ?";

    @Override
    public UserEntity findByEmail(String email) {
        return jdbcTemplate.query(queryFindByEmail, new BeanPropertyRowMapper<>(UserEntity.class), email).stream().findFirst().orElse(null);
    }
}
