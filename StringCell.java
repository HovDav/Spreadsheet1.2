public class StringCell extends Cell{
    private String value;
    public StringCell () {
        super();
        this.value = "0";
    }
    public StringCell (String value, Color color) {
        super (color);
        this.value = value;
    }

    public StringCell (String value) {
        super();
        this.value = value;
    }

    public void setValue (String value) {
        this.value = value;
    }

    public String getStringValue () {
        return value;
    }
}
