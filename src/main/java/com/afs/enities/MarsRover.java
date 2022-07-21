package com.afs.enities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
public class MarsRover {

    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String EAST = "E";
    private static final String WEST = "W";
    @AllArgsConstructor
    private class Location {
        int x, y;
    }

    private String currDirect;


    private Location location;
    public MarsRover(int x,int y,String direct) throws Exception {
        location = new Location(x, y);
        //初始化的方向只能是一个有效的方向
        if (StringUtils.isEmpty(direct) ||
                direct.length() != 1 ||
                !(direct.equals(NORTH) ||
                        direct.equals(EAST) ||
                        direct.equals(SOUTH) ||
                        direct.equals(WEST))) {
            throw new Exception("Param direction error!");
        }
        currDirect = direct;
    }
    /**
     * 验证单个命令是否能有效执行
     * @param order
     * @return
     */
    private boolean validSingleOrder(String order) {
        return StringUtils.isEmpty(order) &&
                order.length() == 1 &&
                (order.equals(NORTH) ||
                        order.equals(EAST) ||
                        order.equals(SOUTH) ||
                        order.equals(WEST));
    }

    /**
     * 别人调用的方法
     * 会解析命令和updateMarsRover的坐标和方向
     * @param order 传入的命令
     */
    public void controlVehicle(String order) {

    }

    private String parseOrder(String order) {
        if (!StringUtils.isEmpty(order) && order.length() == 1) {
            singleOrder(order);
        }
        order = order.trim();
        order = order.toUpperCase();
        List<String> stringList = new ArrayList<>();
        char[] chars = order.toCharArray();
        return "";
    }

    public int getLocationX() {
        return location.x;
    }
    public int getLocationY() {
        return location.x;
    }

    private void singleOrder(String order) {

    }

    private void batchOrder(String order) {

    }

    public void executeOrder(String order) {

    }

    public void update(String order) {

    }

    public void turnLeft() {

    }

    public void turnRight() {

    }

    public void move() {

    }

}
