package com.tenbeggar.pob.events;

import com.tenbeggar.pob.entity.MatchTaskEntity;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MatchTaskEvent extends ApplicationEvent {

    private final MatchTaskEntity matchTaskEntity;

    public MatchTaskEvent(Object source, MatchTaskEntity matchTaskEntity) {
        super(source);
        this.matchTaskEntity = matchTaskEntity;
    }
}
