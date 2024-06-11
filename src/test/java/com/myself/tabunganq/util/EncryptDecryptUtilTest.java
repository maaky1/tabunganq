package com.myself.tabunganq.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class EncryptDecryptUtilTest {


    @Test
    void encrypt() {
        String encrypt = EncryptDecryptUtil.encrypt("ngarangajagimana", "busetdikarangaja", "testing");
        log.info("{}", encrypt);
        assertNotNull(encrypt);
    }

    @Test
    void decrypt() {
        String decrypt = EncryptDecryptUtil.decrypt("ngarangajagimana", "busetdikarangaja", "q8CGsgGlNsY8y/G6u9oQLw==");
        log.info("{}", decrypt);
        assertNotNull(decrypt);
        assertEquals("testing", decrypt);
    }
}