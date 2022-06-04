package me.hung.simplewebsocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Danila Avdeyenko
 * @date 04.06.2022 | 11:37
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageEntity {

    private String from;
    private String message;

}
