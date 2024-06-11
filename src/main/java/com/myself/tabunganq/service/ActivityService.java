package com.myself.tabunganq.service;

import com.myself.tabunganq.model.ActivityModel;
import com.myself.tabunganq.repository.ActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public void insertActivity(ActivityModel activityModel) {

        log.info("[{} - insertActivity][{}]", this.getClass().getSimpleName(), activityModel);

        /* Insert activity */
        activityRepository.insertData(activityModel);
    }
}
