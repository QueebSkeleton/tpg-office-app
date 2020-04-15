package com.gmail.queebskeleton.tpgofficeapp.service;

import com.gmail.queebskeleton.tpgofficeapp.entity.dto.LoginForm;
import com.gmail.queebskeleton.tpgofficeapp.entity.dto.LoginResponse;

public interface AuthService {

	LoginResponse login(LoginForm loginForm);

}