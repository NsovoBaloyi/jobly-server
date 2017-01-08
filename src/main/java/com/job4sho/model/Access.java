package com.job4sho.model;


import com.job4sho.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Defines a role object used to represent a roles/permissions of a people.
 *
 * @author Nsovo Baloyi
 * @version 1.0.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Access extends BaseEntity {

    private static final long serialVersionUID = 4973925160613773037L;
    @NotNull
    @Size(min = 1, max = 50)
    @Id
    @Column(length = 50, unique = true)
    /**
     * Name of the role/permission
     * Note: Name is the {@link Id} of the object and must be unique.
     */
    private String name;
}
