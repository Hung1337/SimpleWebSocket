package me.hung.simplewebsocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Danila Avdeyenko
 * @date 04.06.2022 | 11:42
 */

@Data
@AllArgsConstructor
public class OutputMessageEntity {

    private String from;
    private String message;
    private String date;

}
