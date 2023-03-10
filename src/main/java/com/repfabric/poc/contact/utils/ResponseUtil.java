/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repfabric.poc.contact.utils;

import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Henry
 */
public class ResponseUtil {

    private ResponseUtil() {
    }

    /**
     * Wrap the optional into a {@link ResponseEntity} with an
     * {@link HttpStatus#OK} status, or if it's empty, it returns a
     * {@link ResponseEntity} with {@link HttpStatus#NOT_FOUND}.
     *
     * @param <X> type of the response
     * @param maybeResponse response to return if present
     * @return response containing {@code maybeResponse} if present or
     * {@link HttpStatus#NOT_FOUND}
     */
    public static <X> ResponseEntity<X> wrapOrNotFound(Optional<X> maybeResponse) {
        return wrapOrNotFound(maybeResponse, null);
    }

    /**
     * Wrap the optional into a {@link ResponseEntity} with an
     * {@link HttpStatus#OK} status with the headers, or if it's empty, it
     * returns a {@link ResponseEntity} with {@link HttpStatus#NOT_FOUND}.
     *
     * @param <X> type of the response
     * @param maybeResponse response to return if present
     * @param header headers to be added to the response
     * @return response containing {@code maybeResponse} if present or
     * {@link HttpStatus#NOT_FOUND}
     */
    public static <X> ResponseEntity<X> wrapOrNotFound(Optional<X> maybeResponse, HttpHeaders header) {
        return maybeResponse.map(response -> ResponseEntity.ok().headers(header).body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
