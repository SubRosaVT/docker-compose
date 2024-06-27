package com.dockercomposr.dockercompose.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;


@Data
@Document("messages")
@Builder
public class MessageEntity {
    @Id
    private String id;
    private String msg;
    public static final String NOTHING = "NICHTS";

    @Override
    public String toString() {
        String idStr = StringUtils.hasLength(this.id) ? this.id : NOTHING;
        String msgStr = StringUtils.hasLength(this.msg) ? this.msg : NOTHING;
        return idStr + "    " + msgStr;

    }
}
