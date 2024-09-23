package org.Edu.navigator.Config.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JWTService {
    @Value( "${application.security.jwt.secretKey}" )
    private String secretKey;

    @Value( "${application.security.jwt.expiration}" )
    private Long jwtExpiration;

    public < T > T extractClaim( String token, Function<Claims, T > claimsResolver ) {
        final Claims claims = extractAllClaims( token );
        return claimsResolver.apply( claims );
    }

    public boolean isTokenValid( String token, UserDetails user ) {
        final String username = extractUsername( token );
        return ( username.equals( user.getUsername() ) ) && !isTokenExpired( token );
    }

    public String extractUsername( String token ) {
        return extractClaim( token, Claims::getSubject );
    }

    public String generateToken( UserDetails user ) {
        return generateToken( new HashMap<>(), user );
    }

    public String generateToken(
            Map< String, Object > extraClaims,
            UserDetails user
    ) {
        return buildToken( extraClaims, user, jwtExpiration );
    }

    private String buildToken(
            Map< String, Object > extraClaims,
            UserDetails user,
            long expiration
    ) {
        Set< String > authorities = user
                .getAuthorities()
                .stream()
                .map( GrantedAuthority::getAuthority )
                .collect( Collectors.toSet() );

        return Jwts
                .builder()
                .claims( extraClaims )
                .subject( user.getUsername() )
                .issuedAt( new Date( System.currentTimeMillis() ) )
                .expiration( new Date( System.currentTimeMillis() + expiration ) )
                .claim( "authorities", authorities )
                .signWith( getSingInKey() )
                .compact();
    }

    private boolean isTokenExpired( String token ) {
        return extractExpiration( token ).before( new Date() );
    }

    private Date extractExpiration( String token ) {
        return extractClaim( token, Claims::getExpiration );
    }

    private Claims extractAllClaims( String token ) {
        return Jwts
                .parser()
                .verifyWith( getSingInKey() )
                .build()
                .parseSignedClaims( token )
                .getPayload();
    }

    private SecretKey getSingInKey() {
        byte[] keyBytes = Decoders.BASE64.decode( secretKey );
        return Keys.hmacShaKeyFor( keyBytes );
    }
}