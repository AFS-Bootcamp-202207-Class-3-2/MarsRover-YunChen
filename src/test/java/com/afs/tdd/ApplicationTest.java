package com.afs.tdd;

import com.afs.enities.MarsRover;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.Fail;
class ApplicationTest {
    @Test
    void should_init_right_direct_when_init_mars_rover_given_direct_A() {
        try {
            //given
            MarsRover marsRover = new MarsRover(0, 0, "A");
            //when
            Fail.fail("Param direction error!");
        } catch (Exception e) {
            //then
            Assertions.assertThat(e).hasMessageContaining("Param direction error!");
        }
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
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    
    @Test
    void should_local_2_0_when_init_local_1_0_E_given_M()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(1, 0, "E");
        //when
        marsRover.controlVehicle("M");
        //then
        int exceptX  = 2;
        int exceptY  = 0;
        String exceptDirect = "E";
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }

    @Test
    void should_heading_W_heading_N_given_L()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");
        //when
        marsRover.controlVehicle("L");
        //then
        String exceptDirect = "W";
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    @Test
    void should_heading_N_heading_E_given_L()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "E");
        //when
        marsRover.controlVehicle("L");
        //then
        String exceptDirect = "N";
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    @Test
    void should_heading_E_heading_N_given_R()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");
        //when
        marsRover.controlVehicle("R");
        //then
        String exceptDirect = "E";
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    @Test
    void should_heading_S_heading_E_given_R()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "E");
        //when
        marsRover.controlVehicle("R");
        //then
        String exceptDirect = "S";
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }

    @Test
    void should_heading_N_when_order_R_given_heading_W()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "W");
        //when
        marsRover.controlVehicle("R");
        //then
        int exceptX  = 0;
        int exceptY  = 0;
        String exceptDirect = "N";
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    @Test
    void should_heading_N_heading_W_L_given_L()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "W");
        //when
        marsRover.controlVehicle("R");
        //then
        String exceptDirect = "N";
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }

    @Test
    void should_local_4_5_when_local_5_5_W_given_M()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(5, 5, "W");
        //when
        marsRover.controlVehicle("M");
        //then
        int exceptX  = 4;
        int exceptY  = 5;
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
    }
    @Test
    void should_heading_E_when_heading_S_given_L()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "S");
        //when
        marsRover.controlVehicle("L");
        //then
        String exceptDirect = "E";
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    @Test
    void should_heading_W_when_heading_S_given_R()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "S");
        //when
        marsRover.controlVehicle("R");
        //then
        String exceptDirect = "W";
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    @Test
    void should_local_5_4_when_local_5_5_S_given_M()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(5, 5, "S");
        //when
        marsRover.controlVehicle("M");
        //then
        int exceptX  = 5;
        int exceptY  = 4;
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
    }

    /**
     * 下列的测试是batchCommandTest
     * @throws Exception
     */
    @Test
    void should_local_1_0_N_when_local_0_0_N_given_RML()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 0, "N");
        //when
        marsRover.controlVehicle("RML");
        //then
        int exceptX  = 1;
        int exceptY  = 0;
        String exceptDirect = "N";
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }

    @Test
    void should_local_low_1_0_N_when_local_0_low_4_N_given_MMLMRMM()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, -4, "N");
        //when
        marsRover.controlVehicle("MMLMRMM");
        //then
        int exceptX  = -1;
        int exceptY  = 0;
        String exceptDirect = "N";
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    @Test
    void should_local_2_0_N_when_local_1_0_S_given_LMRMLLM()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(1, 0, "S");
        //when
        marsRover.controlVehicle("LMRMLLM");
        //then
        int exceptX  = 2;
        int exceptY  = 0;
        String exceptDirect = "N";
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
    //LMRMMMLMRM
    @Test
    void should_local_low_2_8_N_when_local_0_4_N_given_LMRM_DUMMLMRM()throws Exception {
        //given
        MarsRover marsRover = new MarsRover(0, 4, "N");
        //when
        marsRover.controlVehicle("LMRM DUMMLMRM");
        //then
        int exceptX  = -2;
        int exceptY  = 8;
        String exceptDirect = "N";
        assertThat(marsRover.getLocationX()).isEqualTo(exceptX);
        assertThat(marsRover.getLocationY()).isEqualTo(exceptY);
        assertThat(marsRover.getHeading()).isEqualTo(exceptDirect);
    }
}
