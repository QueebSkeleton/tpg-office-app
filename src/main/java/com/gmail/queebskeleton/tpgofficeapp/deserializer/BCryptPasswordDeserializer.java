package com.gmail.queebskeleton.tpgofficeapp.deserializer;

import java.io.IOException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class BCryptPasswordDeserializer extends JsonDeserializer<String> {
	
	private PasswordEncoder passwordEncoder;
	
	public BCryptPasswordDeserializer() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	@Override
	public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        String encodedPassword = passwordEncoder.encode(node.textValue());
        return encodedPassword;
    }
	
}
