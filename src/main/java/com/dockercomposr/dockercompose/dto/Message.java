package com.dockercomposr.dockercompose.dto;

import lombok.*;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    public String id;
    public String msg;
    private final String NOTHING = "NICHTS";

    @Override
    public String toString() {
        String idStr = StringUtils.hasLength(this.id) ? this.id : NOTHING;
        String msgStr = StringUtils.hasLength(this.msg) ? this.msg : NOTHING;
        return idStr + "    " + msgStr;
    }
}
