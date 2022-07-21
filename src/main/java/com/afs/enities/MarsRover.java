package com.afs.enities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

@Getter
@Setter
public class MarsRover {

    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String EAST = "E";
    private static final String WEST = "W";
    private static final String ORDER_M = "M";
    private static final String ORDER_R = "R";
    private static final String ORDER_L = "L";
    @AllArgsConstructor
    private class Location {
        int x, y;
    }

    private String currDirect;


    private Location location;
    public MarsRover(int x,int y,String direct) throws Exception {
        location = new Location(x, y);
        //初始化的方向只能是一个有效的方向
        if (!validSingleDirect(direct)) {
            throw new Exception("Param direction error!");
        }
        currDirect = direct;
    }
    /**
     * 验证方向是否能有效执行
     * @param direct
     * @return
     */
    private boolean validSingleDirect(String direct) {
        if (direct != null) {
            direct = direct.toUpperCase();
        }
        return StringUtils.isEmpty(direct) &&
                direct.length() == 1 &&
                (direct.equals(NORTH) ||
                        direct.equals(EAST) ||
                        direct.equals(SOUTH) ||
                        direct.equals(WEST));
    }
    /**
     * 验证单个命令是否能有效执行的命令
     * @param order
     * @return
     */
    private boolean validSingleOrder(String order) {
        if (order != null) {
            order = order.toUpperCase();
        }
        return StringUtils.isEmpty(order) &&
                order.length() == 1 &&
                (order.equals(ORDER_M) ||
                        order.equals(ORDER_L) ||
                        order.equals(ORDER_R));
    }

    /**
     * 别人调用的方法
     * 会解析命令和updateMarsRover的坐标和方向
     * @param order 传入的命令
     */
    public void controlVehicle(String order) {
        String parseOrder = parseOrder(order);
        executeOrder(parseOrder);
    }

    private String parseOrder(String order) {
        return validSingleOrder(order) ? order : batchOrder(order);
    }

    public int getLocationX() {
        return location.x;
    }
    public int getLocationY() {
        return location.x;
    }


    private String batchOrder(String order) {
        order = order.trim();
        order = order.toUpperCase();
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = order.toCharArray();
        for (int idx = 0; idx < chars.length; idx++) {
            if (validSingleOrder(String.valueOf(chars[idx]))) {
                stringBuilder.append(chars[idx]);
            }
        }
        return stringBuilder.toString();
    }

    public void executeOrder(String order) {
        char[] singleOrders = order.toCharArray();
        for (int idx = 0; idx < singleOrders.length; idx++) {
            update(String.valueOf(singleOrders[idx]));
        }
    }

    /**
     * 传进来的Order都是单个有效的Order
     * @param order 命令
     */
    public void update(String order) {
        if (order.equals(ORDER_M)) {
            if (currDirect.equals(NORTH)) {
                location.y += 1;
            } else if (currDirect.equals(SOUTH)) {
                location.y -= 1;
            } else if (currDirect.equals(WEST)) {
                location.x -= 1;
            } else if (currDirect.equals(EAST)) {
                location.x += 1;
            }
        } else if (order.equals(ORDER_R)) {
            turnRight();
        } else if (order.equals(ORDER_L)) {
            turnLeft();
        }
    }

    public void turnLeft() {
        if (currDirect.equals(NORTH)) {
            currDirect = WEST;
        } else if (currDirect.equals(WEST)) {
            currDirect = SOUTH;
        } else if (currDirect.equals(SOUTH)) {
            currDirect = EAST;
        } else if (currDirect.equals(EAST)) {
            currDirect = NORTH;
        }
    }

    public void turnRight() {
        if (currDirect.equals(NORTH)) {
            currDirect = EAST;
        } else if (currDirect.equals(EAST)) {
            currDirect = SOUTH;
        } else if (currDirect.equals(SOUTH)) {
            currDirect = WEST;
        } else if (currDirect.equals(WEST)) {
            currDirect = NORTH;
        }
    }

    public void move() {

    }

}
