package tfip.ssf.practice1.Model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Contact {
    @NotNull(message = "Mandatory field")
    @Size(min=3,max=64,message = "Must be between 3 and 64 characters")
    private String name;
    
    @NotNull(message = "Mandatory field")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Mandatory field")
    @Digits(fraction = 0, integer = 7, message = "Must be at least 7 digits")
    private Integer phone;
    
    @NotNull(message = "Mandatory field")
    @Past(message = "Must be in the past")
    @DateTimeFormat(pattern="MM-dd-yyyy")
    private LocalDate dOB;

    @Min(value = 10, message = "Must be at least 10 years old")
    @Max(value = 100, message = "Must be below 100 years old")
    private Integer age;

    private String contactID;
    
    //Constructors
    public Contact (){
        this.contactID = this.generateID(8);
    }
    public Contact(String name, String email, Integer phone, LocalDate dOB) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dOB = dOB;
        this.age = Period.between(dOB, LocalDate.now()).getYears();
        this.contactID = this.generateID(8);
    }
    //Methods
    public String generateID(int num){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length()<num){
            sb.append(Integer.toHexString(rand.nextInt(17)));
        }
        return sb.toString();
    }
    //Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public LocalDate getDOB() {
        return dOB;
    }
    public void setDOB(LocalDate dOB) {
        this.dOB = dOB;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getContactID() {
        return contactID;
    }
    public void setContactID(String contactID) {
        this.contactID = contactID;
    }
}
