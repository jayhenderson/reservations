package com.j.controllers;

import com.j.business.domain.RoomReservation;
import com.j.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by J on 5/17/2017.
 */
@Controller
@RequestMapping(value="/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(method= RequestMethod.GET)
    public String getReservations(@RequestParam(value="date", required=false)String dateString, Model model){
        List<RoomReservation> roomReservationList = this.reservationService.getRoomReservationsForDate(dateString);
        model.addAttribute("roomReservations", roomReservationList);
        return "reservations";
    }
}