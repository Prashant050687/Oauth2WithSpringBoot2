package com.prashant.oauth2client.rest;

/**
 * Dto to capture token request.
 * @author prashant
 *
 */
public class TokenRequest {
  String clientId;

  String refreshToken;

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

}
