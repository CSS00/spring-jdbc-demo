package com.jdbcdemo.service;

import com.jdbcdemo.entity.Contact;

import java.util.List;

public interface ContactDAO {
    /**
     * Create contact.
     *
     * @param name   name
     * @param email  email
     * @param mobile mobile
     */
    void createContact(String name, String email, String mobile);

    /**
     * Get contact bu id.
     *
     * @param id index
     * @return contact
     */
    Contact getContact(Integer id);

    /**
     * Get all contacts.
     *
     * @return contact list
     */
    List<Contact> listContacts();

    /**
     * Update contact.
     *
     * @param id     index
     * @param name   name
     * @param email  email
     * @param mobile mobile
     */
    void updateContact(Integer id, String name, String email, String mobile);

    /**
     * Delete contact by id.
     *
     * @param id index
     */
    void deleteContact(Integer id);
}
