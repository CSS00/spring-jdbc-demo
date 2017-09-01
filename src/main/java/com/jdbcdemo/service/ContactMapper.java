package com.jdbcdemo.service;

import com.jdbcdemo.entity.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Contact Mapper.
 */
public class ContactMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(
        final ResultSet resultSet,
        final int i
    ) throws SQLException {
        final Contact contact = new Contact();
        contact.setId(resultSet.getInt("id"));
        contact.setName(resultSet.getString("name"));
        contact.setEmail(resultSet.getString("email"));
        contact.setMobile(resultSet.getString("mobile"));
        return contact;
    }
}
