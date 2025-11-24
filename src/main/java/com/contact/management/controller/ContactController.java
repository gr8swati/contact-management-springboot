package com.contact.management.controller;

import com.contact.management.entity.Contact;
import com.contact.management.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // http://localhost:8080/api/contacts/addContact
    @PostMapping("/addContact")
    public Contact addContact(@RequestBody Contact contact){
        return contactService.addContact(contact);
    }

   // http://localhost:8080/api/contacts/getAllContacts
    @GetMapping("/getAllContacts")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }

    // http://localhost:8080/api/contacts/getContactById?id=
    @GetMapping("/getContactById")
    public Contact getContactById(@RequestParam Long id){
        return contactService.getContactById(id);
    }

    // http://localhost:8080/api/contacts/deletecontact?id=
    @DeleteMapping("/deleteContact")
    public String deleteContact(@RequestParam Long id){
        contactService.deleteContact(id);
        return "Deleted";
    }

    // http://localhost:8080/api/contacts/updateContact?id=3
    @PutMapping("/updateContact")
    public Contact updateContact(@RequestBody Contact contact, @RequestParam long id){
        return contactService.updateContact(contact, id);
    }
}
