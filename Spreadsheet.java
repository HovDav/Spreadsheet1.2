public class Spreadsheet {
    private Cell[][] cells;

    public Spreadsheet() {                         // default constructor
        cells = new Cell[5][5];
    }

    public Spreadsheet(int r, int c) {
        cells = new Cell[r][c];
    }

    private boolean isOutOfRange(int r, int c) {
        boolean outOfRange = false;
        if (r >= cells.length || c >= cells[0].length || r < 0 || c < 0) {
            System.out.println("Out of range");
            outOfRange = true;
        }
        return outOfRange;
    }

    private static boolean isInt (String value) {
        try {
            int a = Integer.parseInt(value);
        }
            catch (NumberFormatException nfe) {
                return false;
            }
        return true;
    }

    private static boolean isDouble (String value) {
        try {
            double a = Integer.parseInt(value);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void setCellAt(int r, int c, Cell cl) {
        if (isOutOfRange(r, c)) {
            return;
        } else {
            cells[r][c] = cl;
        }
    }

    public void setCellAt(int r, int c, String cellValue) {
        if (isOutOfRange(r, c)) {
            return;
        } else if (isInt(cellValue)) {
            IntCell intCell = new IntCell(Integer.parseInt(cellValue));
           cells[r][c] = intCell;
        } else if (isDouble(cellValue)) {
            DoubleCell doubleCell = new DoubleCell(Double.parseDouble(cellValue));
            cells[r][c] = doubleCell;
        }
        else {
            cells[r][c] = new StringCell(cellValue);
        }
    }

    public Cell getCellAt(int r, int c) {
        if (isOutOfRange(r, c)) {
            return null;
        } else {
            return cells[r][c];
        }
    }

    public void addRowAt(int r) {
        if (isOutOfRange(r -1, 0)) {
            return;
        } else {
            Cell[][] tmp = new Cell[cells.length + 1][cells[0].length];
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[i].length; j++) {
                    tmp[i][j] = null;
                    if (i < r) {
                        tmp[i][j] = cells[i][j];
                    } else if (i > r) {
                        tmp[i][j] = cells[i - 1][j];
                    }
                }
            }
            cells = tmp;
        }
    }

    public void removeRow(int r) {
        if (isOutOfRange(r, 0)) {
            return;
        } else {
            Cell[][] tmp = new Cell[cells.length - 1][cells[0].length];
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[i].length; j++) {
                    tmp[i][j] = null;
                    if (i < r) {
                        tmp[i][j] = cells[i][j];
                    } else {
                        tmp[i][j] = cells[i + 1][j];
                    }
                }
            }
            cells = tmp;
        }
    }

    public void addColumnAt(int c) {
        if (isOutOfRange(0, c - 1)) {
            return;
        } else {
            Cell[][] tmp = new Cell[cells.length][cells[0].length + 1];
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[i].length; j++) {
                    tmp[i][j] = null;
                    if (j < c) {
                        tmp[i][j] = cells[i][j];
                    } else if (j > c) {
                        tmp[i][j] = cells[i][j - 1];
                    }
                }
            }
            cells = tmp;
        }
    }

    public void removeColumn(int c) {
        if (isOutOfRange(0, c)) {
            return;
        } else {
            Cell[][] tmp = new Cell[cells.length][cells[0].length - 1];
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[i].length; j++) {
                    tmp[i][j] = null;
                    if (j < c) {
                        tmp[i][j] = cells[i][j];
                    } else {
                        tmp[i][j] = cells[i][j + 1];
                    }
                }
            }
            cells = tmp;
        }
    }

    public void swapRows(int r1, int r2) {
        if (isOutOfRange(r1, 0) || isOutOfRange(r2, 0)) {
            return;
        } else {
            Cell[][] tmp = new Cell[cells.length][cells[0].length];
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[0].length; j++) {
                    tmp[i][j] = null;
                    if (i == r1) {
                        tmp[i][j] = cells[r2][j];
                    } else if (i == r2) {
                        tmp[i][j] = cells[r1][j];
                    } else {
                        tmp[i][j] = cells[i][j];
                    }
                }
            }
            cells = tmp;
        }
    }

    public void swapColumns(int c1, int c2) {
        if (isOutOfRange(0, c1) || isOutOfRange(0, c2)) {
            return;
        } else {
            Cell[][] tmp = new Cell[cells.length][cells[0].length];
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[0].length; j++) {
                    tmp[i][j] = null;
                    if (j == c1) {
                        tmp[i][j] = cells[i][c2];
                    } else if (j == c2) {
                        tmp[i][j] = cells[i][c1];
                    } else {
                        tmp[i][j] = cells[i][j];
                    }
                }
            }
            cells = tmp;
        }
    }

    public void printSheet() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j] == null) {
                    System.out.print(cells[i][j] + "\t\t\t");
                }
                else {
                    System.out.print(cells[i][j].getStringValue() + "(" + cells[i][j].getColor() + ")" + "\t\t\t");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public int getNumOfColumns () {
        return cells[0].length;
    }
    public int getNumOfRows () {
        return cells.length;
    }
}
