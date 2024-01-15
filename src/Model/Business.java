package Model;

abstract public class Business {

    /* Restaurant attributes */
    private int id;
    private String name;
    private String address;
   // private Calendar opening_date;
    private long contact_number;
    private String email;

    public Business(int restaurantId, String name, String address,  long contact_number, String email) {
        setId(restaurantId);
        setName(name);
        setAddress(address);
        setContactNumber(contact_number);
        setEmail(email);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(long contact_number) {
        this.contact_number = contact_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    /*public Calendar getOpeningDate() {
        return this.opening_date;
    }*/

    public String getContactNumber() {
        return String.valueOf(this.contact_number);
    }

    public String getEmail() {
        return this.email;
    }

     final public String display()
    {
        return ("Id: "+this.getId() + " ,Name :"+this.getName()+" ,Address :"+this.getAddress()+" ,Contact number :"+this.getContactNumber()+" ,Email :"+this.getEmail());
    }
}