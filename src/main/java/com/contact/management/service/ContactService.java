package com.contact.management.service;


import com.contact.management.entity.Contact;

import java.util.List;

public interface ContactService {
    Contact addContact(Contact contact);
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact updateContact(Contact contact, long id);
    void deleteContact(Long id);
}
