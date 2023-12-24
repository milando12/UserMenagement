package rs.raf.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rs.raf.demo.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);

//    @Modifying
//    @Query("update User u set u.balance = u.balance + :amount")
//    public void increaseBalance(@Param("amount") Integer amount);
//
//    @Modifying
//    @Query("update User u set u.balance = u.balance + :amount where u.username = :username")
//    public void increaseBalance(@Param("amount") Integer amount, @Param("username") String username);
//
//    @Query("update User u set u.loginCount = u.loginCount + :amount where u.username = :username")
//    @Modifying
//    public void increaseLogin(@Param("amount") Integer amount, @Param("username") String username);
}
