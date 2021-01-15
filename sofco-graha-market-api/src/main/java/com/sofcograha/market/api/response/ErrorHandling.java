package com.sofcograha.market.api.response;

//Created On : 11/28/19

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorHandling {
    private String code;
    private String title;
    private String description;
    private Source source;
    private String status;
}
