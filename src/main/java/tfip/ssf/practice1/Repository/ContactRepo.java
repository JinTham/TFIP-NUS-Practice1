package tfip.ssf.practice1.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tfip.ssf.practice1.Model.Contact;

@Repository
public class ContactRepo {
    final String dirPath = "C:/Users/user/My File/TFIP/Code/practice1";
    final String filename = "contacts.txt";
    private List<Contact> contactList = new ArrayList<>();

    public void saveToLocalFile(Contact contact) throws IOException{
        contactList.add(contact);
        File file = new File(dirPath+"/"+filename);
        FileOutputStream fos = new FileOutputStream(file,true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // Write objects
        oos.writeObject(contact);
        oos.close();
        fos.close();
    }

    public List<Contact> listAllContact() throws IOException, ClassNotFoundException{
        List<Contact> outputList = new ArrayList<>();
        File file = new File(dirPath+"/"+filename);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        // Read objects
        while (true){
            Contact contact = (Contact) ois.readObject();
            if (contact == null){
                break;
            }
            outputList.add(contact);
        }
        ois.close();
        fis.close();
        return outputList;
    }

}
