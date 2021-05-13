
package com.woloxnetwork.dto;

import lombok.Data;

@Data
public class Todos {

    public Integer userId;
    public Integer id;
    public String title;
    public Boolean completed;
}
