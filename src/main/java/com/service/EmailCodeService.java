package com.service;

import lombok.Data;
import org.json.JSONObject;


public interface EmailCodeService {
    JSONObject sendEmailCode(String emailName);

    Boolean validateEmailCode(String code);
}
