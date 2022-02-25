package com.rnd.learning.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stevanus Prasetyo Dwicahyono
 * stevanus.dwicahyono@ist.id
 * 25/02/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class CustomerResponseDto extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 6817836815093726092L;
    private List<Customer> data;

}
