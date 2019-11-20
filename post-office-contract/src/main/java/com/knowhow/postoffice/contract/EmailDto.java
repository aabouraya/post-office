package com.knowhow.postoffice.contract;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    private String subject;
    private String to;
    private Template template;
    private Map<String, Object> model;
}
