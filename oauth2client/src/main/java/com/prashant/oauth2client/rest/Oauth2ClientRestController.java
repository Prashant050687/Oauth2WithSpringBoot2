package com.prashant.oauth2client.rest;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prashant.oauth2client.OauthClientDetailsConfig;

@RestController
@RequestMapping("/oauth2")
public class Oauth2ClientRestController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	OauthClientDetailsConfig oauthClientDetailsConfig;

	@PostMapping("/token")
	public Object getAccessToken(TokenRequest tokenRequest, @RequestHeader("Authorization") String authHeader) {

		restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(tokenRequest.getClientId(),
				oauthClientDetailsConfig.getClientDetailsMap().get(tokenRequest.getClientId()).getClientSecret()));
		ResponseEntity<?> response = post(preparePostParameters(authHeader));
		return response.getBody();

	}

	private MultiValueMap<String, String> preparePostParameters(String authHeader) {
		final MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<>();
		if (authHeader != null && authHeader.startsWith("Basic")) {
			String[] authParts = authHeader.split("\\s+");
			String authInfo = authParts[1];
			// Decode the data back to original string
			byte[] bytes = null;
			bytes = new Base64().decode(authInfo);
			String decodedAuth = new String(bytes);
			String[] userNameAndPassword = decodedAuth.split(":");
			System.out.println(decodedAuth);

			postParameters.add("grant_type", "password");
			postParameters.add("username", userNameAndPassword[0]);
			postParameters.add("password", userNameAndPassword[1]);
		}

		return postParameters;
	}

	private ResponseEntity<?> post(MultiValueMap<String, String> postParameters) {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		final HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(postParameters, headers);
		ResponseEntity<?> response;
		response = this.restTemplate.postForEntity("http://localhost:7777/oauth/token", request, Object.class);

		return response;
	}
}
