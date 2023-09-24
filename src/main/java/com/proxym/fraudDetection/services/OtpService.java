package com.proxym.fraudDetection.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OtpService {
    Random random = new Random(100001);

    public int createOtp(){
        int otp = random.nextInt(999999);
        return otp;
    }
}
