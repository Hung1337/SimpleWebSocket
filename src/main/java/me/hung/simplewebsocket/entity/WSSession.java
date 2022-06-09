package me.hung.simplewebsocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Danila Avdeyenko
 * @date 09.06.2022 | 7:24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WSSession {

    private String sessionId;
    private String username;

}
