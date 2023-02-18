
enum Color {
    red, green, blue, white
}

public abstract class Cell {

    private Color color;

    public Cell () {
        this.color = Color.white;
    }

    public Cell (Color color) {
        this.color = color;
    }

    public void setColor (Color color) {
        this.color = color;
    }

    public Color getColor () {
        return color;
    }

    abstract String getStringValue ();
//    public void reset () {
//        this.value = "0";
//        this.color = Color.white;
//    }
}
