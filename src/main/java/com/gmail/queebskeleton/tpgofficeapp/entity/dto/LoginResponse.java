package com.gmail.queebskeleton.tpgofficeapp.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

	private String authenticationToken;
	
	private String username;
	
}
