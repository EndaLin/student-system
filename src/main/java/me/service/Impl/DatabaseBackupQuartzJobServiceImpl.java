package me.service.Impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: wt
 * @Date: 2019/2/21 9:38
 */
public class DatabaseBackupQuartzJobServiceImpl implements Job {
    @Override
    public void execute(JobExecutionContext var1) throws JobExecutionException {
        DataBaseBackupServiceImpl dataBaseBackupService = new DataBaseBackupServiceImpl();
        dataBaseBackupService.backup();
    }
}
