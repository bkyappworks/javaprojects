public class Patient {
    private String firstName, lastName, id, address;
    private int age;
    private Chart chart;

    public Patient() {
        this.firstName = "";
        this.lastName = "";
        this.id = "";
        this.address = "";
        this.age = -1;
        chart = null;
    }

    public Patient(String firstName, String lastName, String id, String address, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.age = age;
        this.chart = new Chart(this.id);
        chart.loadFromFile();
    }
    // getter for chart

    public Chart getChart() {
        return chart;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%10s %10s %5s %20s %3d",
                firstName, lastName, id, address, age);
    }

    public String toCSV() {
        return new String(firstName + "," + lastName + "," + id + "," + address + "," + age);
    }

    public void showChart() {
        chart.display();
    }

    public void appendHealthItem(HealthItem h) {
        chart.append(h);
    }

    public void updateChart() {
        chart.writeToFile();
    }
}
