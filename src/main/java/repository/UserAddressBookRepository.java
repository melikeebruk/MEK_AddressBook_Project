package repository;

import dto.UserAddressBookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserAddressBookRepository extends CrudRepository<UserAddressBookModel, Long> {
    List<UserAddressBookModel> findByUserSurname(String userSurname);
}
