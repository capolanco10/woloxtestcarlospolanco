
package com.woloxnetwork.dto;

import lombok.Data;

@Data
public class Users {

    public Integer id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;
}
