package edu.xust.repairservice.pojo;

import java.util.Map;

/**
 * @author MI
 * @version 1.0
 * @description
 * @date 2021/1/12 23:19
 **/
public class LogType {
    private String list;
    private Map<String, String> map;

    public LogType(String list, Map<String, String> map) {
        this.list = list;
        this.map = map;
    }

    public LogType() {
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
