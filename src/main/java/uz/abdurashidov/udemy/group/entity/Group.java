package uz.abdurashidov.udemy.group.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "`group`" )
public class Group
{
    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;
    private String name;
    @Enumerated( EnumType.STRING )
    private GroupType groupType;
}
