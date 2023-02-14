package tfip.ssf.practice1.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import tfip.ssf.practice1.Model.Contact;
import tfip.ssf.practice1.Service.ContactService;

public class Controller {

    @Autowired
    private ContactService contactService;
    
    //Landing page, which is a registration form
    @GetMapping(path="/")
    public String showContactForm(Model model){
        model.addAttribute("form", new Contact());
        return "form.html";
    }

    //Add an posting action after submitting the form, and will lead to a view page that shows the contact details
    @PostMapping(path="/contact")
    public String submitContact(@Valid Contact contact, BindingResult result, Model model, HttpServletResponse response) throws IOException{
    //@valid is to check is the creation of Contact object has any invalid fields
    //BindingResult is to take in the input of the form
    //HttpServletResponse is to customize the HTTP response output
        if (result.hasErrors()){ //To check if the submitted form has any input error
            return "form.html";
        }
        contactService.saveContact(contact);
        model.addAttribute("contactDetails", contact);
        response.setStatus(HttpServletResponse.SC_CREATED); //Have Http to send out CREATED response code
        return "contactDetails.html";
    }

    //Add a viewing path, to search the contact details by giving contactID in the path 
    @GetMapping(path="/contact/{contactID}")
    public String getContactDetails(@PathVariable(value="contactID") Model model, String contactID) throws ClassNotFoundException, IOException{
        Contact contact = contactService.findContactByID(contactID);
        if (contact.getName()==null){
            return "error.html";
        }
        model.addAttribute("contactDetails", contact);
        return "contactDetails.html";
    }

    //Add a page to show a list of all existing contacts in the database (accepts a variable to determine the number of contacts listed)
    @GetMapping(path="/contact")
    public String listContacts(@RequestParam(name="startIndex") Integer startIndex, Model model) throws ClassNotFoundException, IOException{
        List<Contact> contactList = contactService.listContact();
        model.addAttribute("contactList", contactList);
        return "contactList.html";
    }
}
