package com.myself.tabunganq.repository.impl;

import com.myself.tabunganq.configuration.variable.ConstantVariable;
import com.myself.tabunganq.entity.ActivityEntity;
import com.myself.tabunganq.model.ActivityModel;
import com.myself.tabunganq.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class ActivityImpl implements ActivityRepository {

    @Qualifier(ConstantVariable.BEAN_JDBC_SUPABASE)
    private final JdbcTemplate jdbcTemplate;

    String queryDateSpecific = "select * from m_activity where date(created_at) = date '2024-06-10'";
    private final String queryInsert = "insert into m_activity (payment, price, activity, created_at, created_by) values (?, ?, ?, ?, ?)";

    @Autowired
    public ActivityImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ActivityEntity getData() {
        String sql = "select * from m_activity where id = 1";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ActivityEntity.class)).stream().findFirst().orElse(null);
    }

    @Override
    public void insertData(ActivityModel activityModel) {
        jdbcTemplate.update(queryInsert, activityModel.getPayment(), activityModel.getPrice(), activityModel.getActivity(), LocalDateTime.now(), ConstantVariable.BEAN_APP_NAME);
    }
}
