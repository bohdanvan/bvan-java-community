package com.bvan.jc.employee;

import java.util.Objects;

/**
 * @author bvanchuhov
 */
public class OtherEmployee extends AbstractEmployee {

    private Position position;
    private String description;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OtherEmployee that = (OtherEmployee) o;
        return position == that.position &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), position, description);
    }

    @Override
    public String toString() {
        return "OtherEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", position=" + position +
                ", description='" + description + '\'' +
                '}';
    }
}
