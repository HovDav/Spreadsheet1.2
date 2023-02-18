public class DoubleCell extends Cell{
    private double value;
    public DoubleCell () {
        super();
        this.value = 0;
    }
    public DoubleCell (double value, Color color) {
        super (color);
        this.value = value;
    }

    public DoubleCell (double value) {
        super();
        this.value = value;
    }

    public void setValue (double value) {
        this.value = value;
    }

    public String getStringValue () {
        return Double.toString(value);
    }
}
