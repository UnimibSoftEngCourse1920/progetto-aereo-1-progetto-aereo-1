package it.bicocca.aereoserverside.entity;


import it.bicocca.aereoserverside.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Column(unique = true)
    private String email;
    @NotNull
    //@JsonIgnore
    private String password;
    private String address;
    @OneToOne
    private FidelityCard fidelityCard;
    @NotNull
    private LocalDateTime dateCreation;
    private LocalDateTime dateDeletion;

    @OneToMany(mappedBy = "buyer")
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", surname='" +
               surname + '\'' + " email='" + email + '\'' + ", password='" +
               password + '\'' + ", fidelityCard=" + fidelityCard +
               ", dateCreation=" + dateCreation + ", dateDeletion=" +
               dateDeletion + '}';
    }

    public User(UserDTO other, FidelityCard card) {
        this.name = other.getName();
        this.surname = other.getSurname();
        this.email = other.getEmail();
        this.password = other.getPassword();
        this.address = (address == null) ? "" : address;
        this.fidelityCard = card;
        this.dateCreation = LocalDateTime.now();
        this.tickets = new ArrayList<>();
    }

    public void setDateDeletion(LocalDateTime dateDeletion) {
        this.dateDeletion = dateDeletion;
    }
}//end class
