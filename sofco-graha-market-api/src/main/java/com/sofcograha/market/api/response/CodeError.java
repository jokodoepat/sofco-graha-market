package com.sofcograha.market.api.response;

//Created On : 11/28/19

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CodeError<T> {
    List<ErrorHandling> errors = new ArrayList();
    List<ErrorHandling> warnings = new ArrayList();
    T data;
    Object dictionaries;
}
