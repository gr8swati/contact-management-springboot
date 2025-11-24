package com.contact.management.service.impl;

import com.contact.management.entity.Contact;
import com.contact.management.repository.ContactRepository;
import com.contact.management.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact updateContact(Contact contact, long id) {
        Contact con = contactRepository.findById(id).orElse(null);
        con.setName(contact.getName());
        con.setEmail(contact.getEmail());
        con.setMobile(contact.getMobile());
        return contactRepository.save(con);
    }


    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
