package com.sofcograha.market.api.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Joko on Jan, 2021
 */

@Data
public class OrderTotalRequest {

    private int jumlah;

}
