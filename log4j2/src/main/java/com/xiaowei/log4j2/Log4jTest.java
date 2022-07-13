package com.xiaowei.log4j2;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author : lxw
 * @date : 2022/7/13
 */
public class Log4jTest {


    @Test
    public void test01(){

        //单纯使用log4j
//        Logger logger = LogManager.getLogger(Log4jTest.class);
//        logger.fatal("fatal信息");
//        logger.error("error信息");
//        logger.warn("warn信息");
//        logger.info("info信息");
//        logger.debug("debug信息");
//        logger.trace("trace信息");

    }

    @Test
    public void test02(){
        //使用配置文件
        /*
        使用配置文件
            log4j2是参考logback创作出来的，所以配置文件也是使用xml
            log4j2同样是默认加载类路径（resources）下的log4j2.xml文件中的配置

            根标签，所有日志相关信息，都是在根标签中进行配置
            <Configuration status="debug" monitorInterval="数值"></Configuration>
            在根标签中，可以加属性
            status="debug" 日志框架本身的日志输出级别
            monitorInterval="5" 自动加载配置文件的间隔时间，不低于5秒
         */
//        Logger logger = LogManager.getLogger(Log4jTest.class);
//        logger.fatal("fatal信息");
//        logger.error("error信息");
//        logger.warn("warn信息");
//        logger.info("info信息");
//        logger.debug("debug信息");
//        logger.trace("trace信息");

    }

    @Test
    public void test03(){

        /*
            虽然log4j2也是日志门面，但是现在市场的主流趋势仍然是slf4j
            所以我们仍然需要使用slf4j作为日志门面，搭配log4j2强大的日志实现功能，进行日志的相关操作

            接下来我们配置的就是当今市场上最强大，最主流的日志使用搭配方式：slf4j+log4j2

            1.导入slf4j的日志门面
            2.导入log4j的适配器
            3.导入log4j的日志门面
            4.导入log4j2的日志实现

            执行原理：
                slf4j门面调用的是log4j2的门面，再由log4j2的门面调用log4j2的实现

         */

        Logger logger = LoggerFactory.getLogger(Log4jTest.class);
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");


    }

    @Test
    public void test04(){

        /*
            将日志输出到文件中
         */

        Logger logger = LoggerFactory.getLogger(Log4jTest.class);
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");

    }

    @Test
    public void test05(){

        /*
            日志的拆分

         */
        Logger logger = LoggerFactory.getLogger(Log4jTest.class);
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");

    }

    @Test
    public void test06(){

        /*
            异步日志实现
                方式1：使用AsyncAppender的方式

                1.添加异步日志依赖
                2.在Appenders标签中，对于异步进行配置
                     使用Async标签
                3.rootlogger引用Async

         */
        Logger logger = LoggerFactory.getLogger(Log4jTest.class);

        //日志的记录
        for (int i = 0; i < 2000; i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }
        //系统业务逻辑
        for (int i = 0; i < 1000; i++) {
            System.out.println("------------------");
        }


    }

    @Test
    public void test07(){

        /*
            异步日志实现（单独分配线程做日志的记录）
                方式2：使用AsyncLogger的方式
                      全局异步
                        所有的日志都是异步的日志记录，在配置文件上不用做任何的改动
                        只需要在类路径resources下添加一个properties属性文件，做一步配置即可
                        文件名要求是：log4j2.component.properties
                        Log4jContextSelector==org.apache.logging.log4j.core.async.AsyncLoggerContextSelector
         */

        Logger logger = LoggerFactory.getLogger(Log4jTest.class);

        //日志的记录
        for (int i = 0; i < 2000; i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }
        //系统业务逻辑
        for (int i = 0; i < 1000; i++) {
            System.out.println("------------------");
        }


    }

}
