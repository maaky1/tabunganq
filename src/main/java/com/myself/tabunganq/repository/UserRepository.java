package com.myself.tabunganq.repository;

import com.myself.tabunganq.entity.UserEntity;

public interface UserRepository {

    UserEntity findByEmail(String email);
}
