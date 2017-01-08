package com.job4sho.core;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * Created by Nsovo on 2016/12/24.
 */
@Entity
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1229124742389648323L;

    @Id
    private long id;

    public BaseEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        return getId() == that.getId();

    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
