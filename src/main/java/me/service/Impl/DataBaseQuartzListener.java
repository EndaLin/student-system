package me.service.Impl;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author: wt
 * @Date: 2019/2/21 9:43
 */
public class DataBaseQuartzListener implements ServletContextListener {
    private Scheduler scheduler = null;

    @Override
    public void contextInitialized(ServletContextEvent var1) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            /*
             * 通过schedulerFactory 获取一个调度器
             * Trigger和JobDetail可以注册到Scheduler中， 两者在Scheduler中拥有各自的组及名称
             * 名称是Scheduler查找定位容器中某一对象的依据
             */
            scheduler = schedulerFactory.getScheduler();

            /*
             * Quartz每次调度Job时，都会重新创建一个Job实例，但是它不接受Job实例，而是接收一个JobDetail类（Job的实现类）
             * JobDetail:描述Job的的一些静态信息，如Job名字，描述等等
             * 创建jobDetail实例，并指定job的名称以及所在组的名称
             */
            JobDetail jobDetail = JobBuilder.newJob(DatabaseBackupQuartzJobServiceImpl.class)
                    .withIdentity("Job_1", "JobGroup")
                    .build();

            /*
             * Trigger 描述的是Job执行时间的促发规则
             * 主要有SimpleTrigger和CronTrigger
             * 以下例子使用CronTrigger
             */
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("CronTrigger_1", "ConTriggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 45 19 * * ? *"))
                    .startNow()
                    .build();

            /*
             * 将作业和触发器注册到任务调度中
             */
            scheduler.scheduleJob(jobDetail, trigger);

            scheduler.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent var1) {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
