package com.afs.enities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
        if (direct.length() != 1 ||
                !(direct.equals(NORTH) ||
                        direct.equals(EAST) ||
                        direct.equals(SOUTH) ||
                        direct.equals(WEST))) {
            throw new Exception("Param direction error!");
        }
        currDirect = direct;
    }

    /**
     * 别人调用的方法
     * 会解析命令和updateMarsRover的坐标和方向
     * @param order 传入的命令
     */
    public void controlVehicle(String order) {

    }

    public int getLocationX() {
        return location.x;
    }
    public int getLocationY() {
        return location.x;
    }

}
