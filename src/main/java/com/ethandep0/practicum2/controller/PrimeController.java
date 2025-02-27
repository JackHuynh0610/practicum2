package com.ethandep0.practicum2.controller;

import org.springframework.web.bind.annotation.*;

import com.ethandep0.practicum2.service.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimeController {
    IPrimesService primesService;

    public PrimeController(IPrimesService primesService) {
        this.primesService = primesService;
    }

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n) {
        return primesService.isPrime(n);
    }
}