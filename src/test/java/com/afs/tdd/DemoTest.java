package com.afs.tdd;

import com.afs.enities.MarsRover;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class DemoTest {
    @Test
    void should_Local_0_1_when_Order_M_given_M()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");
        //when
        marsRover.controlVehicle("M");
        //then
        int exceptX  = 0;
        int exceptY  = 1;
        String exceptDirect = "N";
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
        assertThat(marsRover.getCurrDirect()).isEqualTo(exceptDirect);
    }

    
}
