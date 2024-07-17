package com.susmith.passwordgenerator;


import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/password")
public class PasswordController {

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/generate")
    public String generatePassword(@RequestBody PasswordRequest passwordRequest){
        try{
            return PasswordGenerator.generate(passwordRequest);
        }
        catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
