package controller;

import dto.UserAddressBookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import repository.UserAddressBookRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserAddressBookController {

    @Autowired
    UserAddressBookRepository userAddressBookRepository;

    @RequestMapping(value="/userAddressBookModel",  produces= MediaType.APPLICATION_JSON_VALUE)
    public List<UserAddressBookModel> getUserAddressBookData() {
        List<UserAddressBookModel> userAddressBookList = new ArrayList<>();
        Iterable<UserAddressBookModel> userAddresses = userAddressBookRepository.findAll();

        userAddresses.forEach(userAddressBookList::add);
        return userAddressBookList;
    }

    @PostMapping(value="/postUserAddressBookModel")
    public UserAddressBookModel postUserAddressBook(@RequestBody UserAddressBookModel userAddressBookModel) {

        userAddressBookRepository.save(new UserAddressBookModel(userAddressBookModel.getUserName(),
                userAddressBookModel.getUserSurname(), userAddressBookModel.getUserAddress()));
        return userAddressBookModel;
    }

    @GetMapping(value="/findByUserSurname/{userSurname}",  produces=MediaType.APPLICATION_JSON_VALUE)
    public List<UserAddressBookModel> findByUserSurname(@PathVariable String userSurname) {

        List<UserAddressBookModel> userAddresses = userAddressBookRepository.findByUserSurname(userSurname);
        return userAddresses;
    }

    @DeleteMapping(value="/userAddressBook/{userId}")
    public void deleteCustomer(@PathVariable long userId){

        userAddressBookRepository.deleteById(userId);
    }


}
