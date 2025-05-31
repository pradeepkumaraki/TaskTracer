package com.self.learn.TaskTracer.model;

import com.self.learn.TaskTracer.utility.Status;
import lombok.*;


@AllArgsConstructor
@ToString
@Builder
public class Task {
    private @Getter @Setter String description;
    private @Getter @Setter int id;
    private @Getter @Setter Status status;
}
