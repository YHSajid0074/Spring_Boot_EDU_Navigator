package org.Edu.navigator.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class ErrorDetails {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class ErrorDeatils {
        private LocalDateTime timestrap;
        private String messege;
        private  String path;
        private  String errorCode;
    }
}
