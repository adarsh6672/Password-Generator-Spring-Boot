package com.susmith.passwordgenerator;

import lombok.Data;

@Data
public class PasswordRequest {

    private int length;
    private boolean lowercase;
    private boolean uppercase;
    private boolean numbers;
    private boolean specialChars;

}
