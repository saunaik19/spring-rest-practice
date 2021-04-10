package com.saurabh.example.springrestpractice.models;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
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
    @Size(min = 4,max=8,message = "Name should have at least 2 chars")
    private String userName;
    @Past
    private LocalDate birthDate;

}
