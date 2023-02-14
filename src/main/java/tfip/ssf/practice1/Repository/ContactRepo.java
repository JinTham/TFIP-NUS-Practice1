package tfip.ssf.practice1.Repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Repository;

import tfip.ssf.practice1.Model.Contact;

@Repository
public class ContactRepo {
    private String dirPath;

    public void saveToLocalFile(Contact contact) throws IOException{
        FileWriter fileWriter = new FileWriter(String.format("%s/employee.txt"));
    }

    public List<Contact> listAllContact(){
        return null;
    }

}
