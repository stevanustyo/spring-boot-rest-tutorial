package com.rnd.learning.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author Stevanus Prasetyo Dwicahyono
 * stevanus.dwicahyono@ist.id
 * 25/02/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 442954176689544599L;
    private String message;
}
