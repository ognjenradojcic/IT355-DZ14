/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.service;

import com.metropolitan.domain.Reservation;
import java.util.List;

/**
 *
 * @author Vlada
 */
public interface ReservationService {

    public List<Reservation> query(String courtName);
}
