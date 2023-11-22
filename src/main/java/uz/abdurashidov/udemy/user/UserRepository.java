package uz.abdurashidov.udemy.user;

import org.springframework.stereotype.Repository;
import uz.abdurashidov.udemy.common.repository.GenericSpecificationRepository;
import uz.abdurashidov.udemy.user.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends GenericSpecificationRepository<User, UUID>
{
}
