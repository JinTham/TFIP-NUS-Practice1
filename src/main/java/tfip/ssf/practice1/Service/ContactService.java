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

    public List<Contact> listContact(){
        return contactRepo.listAllContact();
    }

    public Contact findContactByID(String contactID){
        //if contactID not exist,
        return new Contact();
        //else do as usual
    }
}
