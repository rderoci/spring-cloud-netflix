package com.springcloud.netflix.mspayroll.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Payment {

    String name;
    Double daySalary;
    Integer workDays;
}
