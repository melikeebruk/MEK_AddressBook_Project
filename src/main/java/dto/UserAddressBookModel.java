package dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserAddressBookModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "userName")
    private String userName;
    @Column(name = "userSurname")
    private String userSurname;
    @Column(name = "userAddress")
    private String userAddress;

    protected UserAddressBookModel() {}

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public UserAddressBookModel(String userName, String userSurname, String userAddress){
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return String.format("UserAddressBookModel[ID=%d, Name=%s, Surname=%s, Address=%s]",
                userId, userName, userSurname, userAddress);
    }

    UserAddressBookModel userAddressBookModel = new UserAddressBookModel("Melike", "Ebru", "Maslak");

}
