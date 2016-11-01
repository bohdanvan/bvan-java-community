package com.bvan.jc.chat2.employee;

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
