package com.myself.tabunganq.configuration.database;

import com.myself.tabunganq.configuration.mapping.ValueMapping;
import com.myself.tabunganq.configuration.variable.ConstantVariable;
import com.myself.tabunganq.util.EncryptDecryptUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfig {

    private final ValueMapping valueMapping;

    @Autowired
    public DatabaseConfig(ValueMapping valueMapping) {
        this.valueMapping = valueMapping;
    }

    @Bean(name = ConstantVariable.BEAN_DS_SUPABASE)
    protected DataSource dataSource() throws URISyntaxException {
        String[] supabaseConfig = EncryptDecryptUtil.decrypt(valueMapping.securitySecretKey, valueMapping.securitySecretIv, valueMapping.supabaseConfig).split("\\|");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(supabaseConfig[0]);
        config.setUsername(supabaseConfig[1]);
        config.setPassword(supabaseConfig[2]);
        config.setPoolName(supabaseConfig[3]);

        return new HikariDataSource(config);
    }

    @Bean(name = ConstantVariable.BEAN_JDBC_SUPABASE)
    protected JdbcTemplate jdbcTemplate(@Qualifier(ConstantVariable.BEAN_DS_SUPABASE) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
