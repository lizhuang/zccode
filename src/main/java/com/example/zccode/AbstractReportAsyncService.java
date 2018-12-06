//package com.example.zccode;
//
//import com.example.zccode.service.report.ReportAsyncService;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.util.UUID;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.atomic.AtomicLong;
//
//public abstract class AbstractReportAsyncService implements ReportAsyncService, ApplicationContextAware {
//
//    private static final int DEFAULT_WORKER_NUMBER = Runtime.getRuntime().availableProcessors() * 2;
//
//    private AutowireCapableBeanFactory autowireCapableBeanFactory;
//
//    private ExecutorService workers;
//
//    @PostConstruct
//    public void init() {
//        int workerNumber = workerNumber();
//        if (workerNumber <= 0) {
//            workerNumber = DEFAULT_WORKER_NUMBER;
//        }
//
//        workers = Executors.newFixedThreadPool(workerNumber, new ThreadFactory() {
//            private final AtomicLong number = new AtomicLong();
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread newThread = Executors.defaultThreadFactory().newThread(r);
//                newThread.setName("worker" + "-" + this.number.getAndIncrement());
//                newThread.setDaemon(false);
//                return newThread;
//            }
//        });
//    }
//
//    @PreDestroy
//    public void destroy(){
//        workers.shutdown();
//        try{
//            if (!workers.awaitTermination(5, TimeUnit.SECONDS)){
//                workers.shutdownNow();
//
//                if (!workers.awaitTermination(5, TimeUnit.SECONDS)){
//                    System.err.println("Pool did not terminate.");
//                }
//            }
//        } catch (InterruptedException e) {
//            workers.shutdown();
//            Thread.currentThread().interrupt();
//        }
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
//    }
//
//    protected void assemblyReportDataQueryIterator(ReportDataQueryIteator iteator){
//        autowireCapableBeanFactory.autowireBean(iterator);
//    }
//
//    /**
//     * 由子类实现，给出需要的工作者线程
//     *
//     * @return 工作者线程数量
//     */
//    protected abstract int workerNumber();
//
//    /**
//     * 生成票据
//     *
//     * @return 票据
//     */
//    private String buildTicket() {
//        return UUID.randomUUID().toString().replace("-", "");
//    }
//
//}
