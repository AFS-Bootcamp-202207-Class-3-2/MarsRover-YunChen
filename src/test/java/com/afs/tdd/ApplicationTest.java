package com.afs.tdd;

import com.afs.enities.MarsRover;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Fail;
class ApplicationTest {
    @Test
    void should_init_right_direct_when_init_mars_rover_given_direct_A() {
        //given
        try {
            MarsRover marsRover = new MarsRover(0, 0, "A");
            Fail.fail("Param direction error!");
        } catch (Exception e) {
            Assertions.assertThat(e).hasMessageContaining("Param direction error!");
        }
        //when

        //then
    }

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
