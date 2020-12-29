package edu.xust.repairservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import sun.rmi.runtime.Log;

@SpringBootApplication
public class RepairserviceApplication {
    private static final Logger LOG = LoggerFactory.getLogger(RepairserviceApplication.class);

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(RepairserviceApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("System地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
