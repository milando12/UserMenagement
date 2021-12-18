package rs.raf.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer loginCount = 0;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer balance = 0;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer salary = 0;

//    @Column
//    @Version
//    private Integer version;
}
