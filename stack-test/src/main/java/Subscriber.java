public class Subscriber {
    private int id;
    private String surname;
    private String street;
    private int house;
    private int flat;
    private int type;
    private int previous;
    private int current;
    private double accrued;

    public Subscriber(int id, String surname, String street, int house, int flat, int type, int previous, int current) {
        this.id = id;
        this.surname = surname;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.type = type;
        this.previous = previous;
        this.current = current;
        this.accrued = (type == 1) ? 301.26 : (current - previous) * 1.52;
    }

    public int getId() {
        return id;
    }

    public int getCurrent() {
        return current;
    }

    public int getFlat() {
        return flat;
    }

    public int getHouse() {
        return house;
    }

    public int getPrevious() {
        return previous;
    }

    public int getType() {
        return type;
    }

    public String getStreet() {
        return street;
    }

    public String getSurname() {
        return surname;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getAccrued() {
        return accrued;
    }

    @Override
    public String toString() {
        return this.id + " " + this.surname + " " + this.street + " " + this.house + " " + this.flat + " " + this.type + " " + this.previous + " " + this.current;
    }

    public String toStringAccured() {
        return this.id + " " + this.surname + " " + this.street + " " + this.house + " " + this.flat + " " + this.type + " " + this.previous + " " + this.current + " " + this.accrued;
    }
}
