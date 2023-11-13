package uz.abdurashidov.udemy.group;

import org.springframework.stereotype.Repository;
import uz.abdurashidov.udemy.common.repository.GenericSpecificationRepository;
import uz.abdurashidov.udemy.group.entity.Group;

import java.util.UUID;

@Repository
public interface GroupRepository extends GenericSpecificationRepository<Group, UUID> {
}
