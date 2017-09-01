package com.jdbcdemo.controller;

import com.jdbcdemo.entity.Contact;
import com.jdbcdemo.service.ContactJDBCTemplate;
import com.jdbcdemo.entity.ContactParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contact Controller.
 */
@RestController
@RequestMapping("/contacts")
public class ContactController {
    /**
     * JDBC Template.
     */
    @Autowired
    private ContactJDBCTemplate contactJDBCTemplate;

    /**
     * Create contact.
     *
     * @param param parameters
     * @return operation status
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createContact(
        @RequestBody
        final ContactParam param
    ) {
        contactJDBCTemplate.createContact(
            param.getName(), param.getEmail(), param.getMobile()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Get list of contacts.
     *
     * @return list of contacts
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getContacts() {
        final List<Contact> contacts = contactJDBCTemplate.listContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    /**
     * Get contact by id.
     *
     * @param id index
     * @return contact object
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getContact(
        @PathVariable(value = "id")
        final Integer id
    ) {
        try {
            final Contact contact = contactJDBCTemplate.getContact(id);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (final EmptyResultDataAccessException exp) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete contact.
     *
     * @param id contact index
     * @return operation status
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteContact(
        @PathVariable(value = "id")
        final Integer id
    ) {
        contactJDBCTemplate.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Update contact.
     *
     * @param id    contact index
     * @param param parameters
     * @return operation status
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateContact(
        @PathVariable(value = "id")
        final Integer id,
        @RequestBody
        final ContactParam param
    ) {
        contactJDBCTemplate.updateContact(
            id, param.getName(), param.getEmail(), param.getMobile()
        );
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
