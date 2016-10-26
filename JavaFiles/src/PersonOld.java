public class PersonOld {
    private int id;
    private String name;
    private String phone;
    private String email;

    public PersonOld(int i, String mayur) {

        this(0, "", "", "");
    }

    public PersonOld(int id, String name,
                     String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonOld [id=" + id + ", name="
                + name + ", phone=" + phone
                + ", email=" + email + "]";
    }
}