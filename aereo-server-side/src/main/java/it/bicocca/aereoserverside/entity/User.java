package it.bicocca.aereoserverside.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
//, indexes = {@Index(name = "IDX_email", columnList = "email ASC")}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private LocalDateTime dateOfBirth;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    //@JsonIgnore
    private String password;
    @OneToOne
    private FideltyCard fideltyCardNumber;
    @NotNull
    private LocalDateTime dateCreation;
    private LocalDateTime dateDeletion;

    @OneToMany(mappedBy = "buyer")
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", surname='" +
               surname + '\'' + ", dateOfBirth=" + dateOfBirth + ", email='" +
               email + '\'' + ", password='" + password + '\'' +
               ", fideltyCardNumber=" + fideltyCardNumber + ", dateCreation=" +
               dateCreation + ", dateDeletion=" + dateDeletion + '}';
    }
}//end class
