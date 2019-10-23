package cn.yhd.thread;

import cn.yhd.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuhuadong
 * @date 2019/10/18
 */
@Component
public class NormalThread implements Runnable{
    @Resource
    UserService userService;
    private static final Integer queueLength = 5000;
    public static LinkedBlockingQueue QUEUE = new LinkedBlockingQueue<Long>(queueLength);

    @Override
    public void run() {
        while (QUEUE.peek()!=null){
            System.out.println(QUEUE.poll());
        }
    }

}
