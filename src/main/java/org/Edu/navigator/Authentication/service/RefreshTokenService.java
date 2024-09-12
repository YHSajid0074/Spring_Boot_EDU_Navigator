package org.Edu.navigator.Authentication.service;

import org.Edu.navigator.Authentication.model.RefreshToken;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(Long userId);

    RefreshToken verifyRefreshTokenExpiration(RefreshToken refreshToken);

    RefreshTokenResponse tokenRefresh(RefreshTokenRequest request);
}