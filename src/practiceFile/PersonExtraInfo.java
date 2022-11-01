package practiceFile;

public class PersonExtraInfo extends Person {

    private String phone;

    private String email;

    public PersonExtraInfo(String name, int age, Gender gender) {
        super(name, age, gender);
    }
    
    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }


    
}
