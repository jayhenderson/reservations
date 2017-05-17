package com.j.business.service;

import com.j.business.domain.RoomReservation;
import com.j.models.Guest;
import com.j.models.Reservation;
import com.j.models.Room;
import com.j.models.data.GuestDao;
import com.j.models.data.ReservationDAO;
import com.j.models.data.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by J on 5/17/2017.
 */
@Service
public class ReservationService {

    private RoomDAO roomDAO;
    private GuestDao guestDao;
    private ReservationDAO reservationDAO;

    @Autowired
    public ReservationService(RoomDAO roomDAO, GuestDao guestDao, ReservationDAO reservationDAO) {
        this.roomDAO = roomDAO;
        this.guestDao = guestDao;
        this.reservationDAO = reservationDAO;
    }

    public List<RoomReservation> getRoomReservationsForDate(Date date){
        Iterable<Room> rooms = this.roomDAO.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        for(Room room : rooms){
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        }

        Iterable<Reservation> reservations = this.reservationDAO.findByDate(new java.sql.Date(date.getTime()));
        if (null != reservations) {
            for(Reservation reservation : reservations){
                Guest guest = this.guestDao.findOne(reservation.getGuestId());
                if (null != guest) {
                    RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
                    roomReservation.setDate(date);
                    roomReservation.setFirstName(guest.getFirstName());
                    roomReservation.setLastName(guest.getLastName());
                    roomReservation.setGuestId(guest.getId());
                }
            }
        }

        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long roomId : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(roomId));
        }
        return roomReservations;

    }

}
