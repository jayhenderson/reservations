package com.j.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by J on 5/17/2017.
 */

@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations(){
        return "reservations";
    }

}
