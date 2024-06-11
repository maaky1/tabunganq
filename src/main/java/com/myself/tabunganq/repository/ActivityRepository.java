package com.myself.tabunganq.repository;

import com.myself.tabunganq.entity.ActivityEntity;
import com.myself.tabunganq.model.ActivityModel;

public interface ActivityRepository {

    ActivityEntity getData();
    void insertData(ActivityModel activityModel);
}
