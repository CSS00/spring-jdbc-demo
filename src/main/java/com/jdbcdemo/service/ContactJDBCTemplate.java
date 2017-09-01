package com.jdbcdemo.service;

import com.jdbcdemo.entity.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

/**
 * Contact JDBC Template.
 */
@Slf4j
@Component
public class ContactJDBCTemplate implements ContactDAO {
    /**
     * Data source.
     */
    private final DataSource dataSource;
    /**
     * Jdbc template.
     */
    private final JdbcTemplate jdbcTemplateObject;

    /**
     * Constructor.
     *
     * @param dataSource data source
     */
    @Autowired
    public ContactJDBCTemplate(final DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
    }

    @Override
    public void createContact(
        final String name,
        final String email,
        final String mobile
    ) {
        final String sql = "INSERT INTO contact ("
            + "name, email, mobile"
            + ") VALUES (?, ?, ?)";
        jdbcTemplateObject.update(sql, name, email, mobile);
        log.info(
            "Created Record name = {}, email = {}, mobile = {}",
            name, email, mobile
        );
    }

    @Override
    public Contact getContact(final Integer id) {
        final String sql = "SELECT * FROM contact WHERE id = ?";
        return jdbcTemplateObject.queryForObject(
            sql, new Object[]{id}, new ContactMapper()
        );
    }

    @Override
    public List<Contact> listContacts() {
        final String sql = "SELECT * FROM contact";
        return jdbcTemplateObject.query(sql, new ContactMapper());
    }

    @Override
    public void updateContact(
        final Integer id,
        final String name,
        final String email,
        final String mobile
    ) {
        final String sql = "UPDATE contact SET "
            + "name = ?, email = ?, mobile = ? "
            + "WHERE id = ?";
        jdbcTemplateObject.update(sql, name, email, mobile, id);
        log.info("Updated Record with ID = {}", id);
    }

    @Override
    public void deleteContact(final Integer id) {
        final String sql = "DELETE FROM contact WHERE id = ?";
        jdbcTemplateObject.update(sql, id);
        log.info("Deleted Record with ID = {}", id);
    }
}
