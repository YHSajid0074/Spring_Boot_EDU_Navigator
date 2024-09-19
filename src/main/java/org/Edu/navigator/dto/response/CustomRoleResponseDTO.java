package org.Edu.navigator.dto.response;

import java.net.http.HttpResponse;
import java.util.Set;

public interface CustomRoleResponseDTO {

    Long getId();

    String getRoleType();

    Set< UserInfo > getUsers();

    interface UserInfo {
        Long getId();

        String getUsername();

        String getEmail();
    }
}
