package edu.xust.repairservice.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author MI
 * @version 1.0
 * @description
 * @date 2021/1/12 22:57
 **/
public class LogInfo {
    private String code;
    private String level;
    private LogType data;

    public LogInfo() {
    }

    public LogInfo(String code, String level, LogType data) {
        this.code = code;
        this.level = level;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public LogType getData() {
        return data;
    }

    public void setData(LogType data) {
        this.data = data;
    }
}

