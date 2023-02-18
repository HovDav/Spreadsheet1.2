public class IntCell extends Cell{
    private int value;
    public IntCell () {
        super();
        this.value = 0;
    }
    public IntCell (int value, Color color) {
        super (color);
        this.value = value;
    }
    public IntCell (int value) {
        super();
        this.value = value;
    }
    public void setValue (int value) {
        this.value = value;
    }
    public int getValue () {
        return this.value;
    }
    public String getStringValue () {
        return Integer.toString(value);
    }
}
