package tfip.ssf.practice1.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfip.ssf.practice1.Model.Contact;
import tfip.ssf.practice1.Repository.ContactRepo;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public void saveContact(Contact contact) throws IOException{
        contactRepo.saveToLocalFile(contact);
    }

    public List<Contact> listContact() throws ClassNotFoundException, IOException{
        return contactRepo.listAllContact();
    }

    public Contact findContactByID(String contactID) throws ClassNotFoundException, IOException{
        Contact contact = contactRepo.listAllContact().stream().filter(e -> e.getContactID().equals(contactID)).findFirst().get();
        if (contact!=null){
            return contact;
        } else {
            return new Contact();
        }
    }
}
