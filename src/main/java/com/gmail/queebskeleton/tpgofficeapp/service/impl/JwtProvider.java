package com.gmail.queebskeleton.tpgofficeapp.service.impl;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.gmail.queebskeleton.tpgofficeapp.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;

@Service
public class JwtProvider {

	private KeyStore keyStore;

	@PostConstruct
	public void init() {

		try {

			keyStore = KeyStore.getInstance("JKS");

			InputStream resourceAsStream = getClass().getResourceAsStream("/tpg_app.jks");

			keyStore.load(resourceAsStream, "tpg_app_pass".toCharArray());

		} catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException
				| java.io.IOException e) {

			throw new IOException("Exception occurred while loading keystore");

		}

	}

	public String generateToken(String username) {

		return Jwts.builder().setSubject(username).signWith(getPrivateKey()).compact();

	}

	public boolean validateToken(String token) {
		Jwts.parser().setSigningKey(getPublicKey()).parseClaimsJws(token);
		return true;
	}

	private PrivateKey getPrivateKey() {

		try {

			return (PrivateKey) keyStore.getKey("tpg_app", "tpg_app_pass".toCharArray());

		} catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {

			throw new RuntimeException("Error getting private key.");

		}

	}

	public PublicKey getPublicKey() {

		try {

			return keyStore.getCertificate("tpg_app").getPublicKey();

		} catch (KeyStoreException e) {

			throw new RuntimeException("Error getting public key.");

		}

	}

	public String getUsernameFromToken(String token) {

		Claims claims = Jwts.parser().setSigningKey(getPublicKey()).parseClaimsJws(token).getBody();

		return claims.getSubject();

	}

}
