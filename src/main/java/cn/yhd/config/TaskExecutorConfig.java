package cn.yhd.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池配置信息
 * @author Bingo_G
 * <p>
 * 🐭 🐂 🐯 🐰 🐲 🐍 🐎 🐑 🐒 🐔 🐶 🐷
 */
@Configuration
public class TaskExecutorConfig {

    @Bean(name = "normalTaskExecutor")
    public ThreadPoolTaskExecutor normalTaskExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        poolTaskExecutor.setCorePoolSize(4);
        //线程池维护线程的最大数量
        poolTaskExecutor.setMaxPoolSize(4);
        //线程池所使用的缓冲队列
        poolTaskExecutor.setQueueCapacity(10);
        //线程池维护线程所允许的空闲时间
        poolTaskExecutor.setKeepAliveSeconds(30000);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return poolTaskExecutor;
    }

    @Bean(name = "normalExecutor")
    public ThreadPoolExecutor normalExecutor(){
        ThreadPoolExecutor normalExecutor =
                new ThreadPoolExecutor(4,4,30000L, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(10),
                        new ThreadFactoryBuilder().setNameFormat("push-thread-%d").build(),new ThreadPoolExecutor.AbortPolicy());
        return normalExecutor;
    }

    @Bean(name = "illegalSelfieAddExecutor")
    public ThreadPoolTaskExecutor illegalSelfieAddExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        poolTaskExecutor.setCorePoolSize(1);
        //线程池维护线程的最大数量
        poolTaskExecutor.setMaxPoolSize(10);
        //线程池所使用的缓冲队列
        poolTaskExecutor.setQueueCapacity(20);
        //线程池维护线程所允许的空闲时间
        poolTaskExecutor.setKeepAliveSeconds(30);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        poolTaskExecutor.setThreadNamePrefix("illegal-selfie-thread-");
        return poolTaskExecutor;
    }

    @Bean(name = "illegalSelfieRecordExecutor")
    public ThreadPoolTaskExecutor illegalSelfieRecordExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量
        poolTaskExecutor.setCorePoolSize(5);
        //线程池维护线程的最大数量
        poolTaskExecutor.setMaxPoolSize(50);
        //线程池所使用的缓冲队列
        poolTaskExecutor.setQueueCapacity(200);
        //线程池维护线程所允许的空闲时间
        poolTaskExecutor.setKeepAliveSeconds(30);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        poolTaskExecutor.setThreadNamePrefix("illegal-selfie-record-thread-");
        return poolTaskExecutor;
    }

}
