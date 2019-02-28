public class People {
    private String name;
    private City city;
    private String id;

    public People(String name, City city, String id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s,%s",name,id);
    }
}
