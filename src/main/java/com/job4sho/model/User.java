package com.job4sho.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.job4sho.core.BaseEntity;
import org.hibernate.validator.constraints.Email;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import lombok.Data;
/**
 * @author Nsovo Baloyi
 * @version 1.0.0
 */
@Data
@Entity
@Table(name="users")
public class User extends BaseEntity{


    private static final long serialVersionUID = 5018751575393432500L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Pattern(regexp = "^[_'.@A-Za-z0-9-]*$")
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    /**
     * The unique username of the people. Used as a unique identified for users
     * instead of long id's.
     */
    private String username;

    @JsonIgnore
    @NotNull
    @Size(min = 8, max = 60)
    @Column(length = 60, nullable = false)
    /**
     * Store the password of the people, No specification on how the
     * password will be stored in the backend is made, left as implementation
     * specific detail.
     */
    private String password;

    @NotNull
    @Size(max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    /**
     * Store the first name of the people.
     */
    private String firstName;

    @NotNull
    @Size(max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    /**
     * Store the last name of the people,
     */
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(length = 100, unique = true, nullable = false)
    /**
     * Store the primary email address of the people.used in communication such
     * as when people requests to reset password.
     */
    private String email;

    @NotNull
    @Column(nullable = false)
    /**
     * Ehether the people has activated the account in question. Can be used to
     * protect against spam account creation.
     */
    private boolean activated = false;

    @JsonIgnore
    @Size(min = 20, max = 20)
    @Column(name = "activation_key", length = 20, nullable = true)
    /**
     * Key needed to activate the account. Key can be sent to people in
     * communication, such as email upon account creation.
     */
    private String activationKey;

    @Size(min = 20, max = 20)
    @Column(name = "reset_key", length = 20, nullable = true)
    /**
     * Key which people must supply to be allowed to reset there password.
     */
    private String resetKey;

    @Past
    @Column(name = "reset_date", nullable = true)
    /**
     * When the account reset was requested, allowing expiry of reset key,
     * to ensure security is maintained.
     */
    private ZonedDateTime resetDate = null;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    /**
     * Store a list of the roles of users.
     */
    private Set<Access> authorities = new HashSet<>();

    public void setUsername(String username) {
        this.username = username.toLowerCase(Locale.ENGLISH);
    }
}