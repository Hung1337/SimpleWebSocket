package me.hung.simplewebsocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Danila Avdeyenko
 * @date 04.06.2022 | 11:37
 */

@Data
@AllArgsConstructor
public class MessageEntity {

    private String from;
    private String message;

}
