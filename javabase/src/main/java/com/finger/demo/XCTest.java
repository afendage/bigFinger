package com.finger.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class XCTest {

    @Test
    public void tt(){
        List<HallManagerRespDTO> listHalls = new ArrayList<>();
        HallManagerRespDTO hall1 = new HallManagerRespDTO();
        hall1.setId(10000l);
        HallManagerRespDTO hall2 = new HallManagerRespDTO();
        hall2.setId(10001l);
        HallManagerRespDTO hall3 = new HallManagerRespDTO();
        hall3.setId(10003l);
        listHalls.add(hall1);
        listHalls.add(hall2);
        listHalls.add(hall3);
        listHalls.removeIf(hall -> hall.getId() == 10000L);
        for (HallManagerRespDTO hall : listHalls) {
            System.out.println(hall.getId());
        }
    }
}
