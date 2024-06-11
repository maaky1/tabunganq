package com.myself.tabunganq.configuration.mapping;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValueMapping {

    /* Security Secret */
    @Value("${security.secret.key}")
    public String securitySecretKey;
    @Value("${security.secret.init-vector}")
    public String securitySecretIv;

    /* Config Supabase */
    @Value("${spring.datasource.supabase.config}")
    public String supabaseConfig;
}
