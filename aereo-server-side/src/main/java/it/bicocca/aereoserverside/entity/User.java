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

    public User() {
    }

    public User(@NotNull String name, @NotNull String surname,
                @NotNull String email, @NotNull String password, String address,
                FidelityCard fidelityCard, @NotNull LocalDateTime dateCreation,
                LocalDateTime dateDeletion, List<Ticket> tickets) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.fidelityCard = fidelityCard;
        this.dateCreation = dateCreation;
        this.dateDeletion = dateDeletion;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FidelityCard getFidelityCard() {
        return fidelityCard;
    }

    public void setFidelityCard(FidelityCard fidelityCard) {
        this.fidelityCard = fidelityCard;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateDeletion() {
        return dateDeletion;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}//end class
