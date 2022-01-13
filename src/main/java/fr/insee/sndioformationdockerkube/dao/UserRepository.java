package fr.insee.sndioformationdockerkube.dao;

import fr.insee.sndioformationdockerkube.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Transactional
    @Modifying
    @Query("delete from User u where u.username =:username")
    void deleteByUsername(String username);
    User findByUsername(String username);
}
