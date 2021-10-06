public class HealthItem {
    private String id, testName, date, value;

    public HealthItem( ) {
        id = ""; testName = ""; date = ""; value = "";
    }

    public HealthItem(String id, String testName, String date, String value) {
        this.id = id;
        this.testName = testName;
        this.date = date;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%5s %20s %12s %5s", id, testName, date, value);
    }

    public String toCSV() {
        return new String(id + "," + testName + "," + date + "," + value);
    }
}
