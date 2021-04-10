package com.saurabh.example.springrestpractice.models;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @NotNull
    private Integer userId;
    private String userName;
    private LocalDate birthDate;

}
