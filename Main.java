import javax.xml.transform.sax.SAXSource;

public class Main {
    public static void main(String[] args) {
        // creating a new SpreadSheet
        Spreadsheet sheet1 = new Spreadsheet(5, 5);
        System.out.println("Creating a new empty spreadsheet:");
        sheet1.printSheet();


        // initializing the first column
        sheet1.setCellAt(0, 0, "Name");
        Cell r1c0 = new StringCell("John");
        sheet1.setCellAt(1, 0, r1c0);
        Cell r2c0 = new StringCell("Alan", Color.red);
        sheet1.setCellAt(2, 0, r2c0);
        Cell r3c0 = new StringCell("Mary", Color.green);
        sheet1.setCellAt(3, 0, r3c0);
        sheet1.setCellAt(4, 0, "Jack");
        System.out.println("Initializing the first column:");
        sheet1.printSheet();

        // initializing all cells
        for (int i = 1; i < 5; i++) {
            sheet1.setCellAt(0, i, "Gr:" + i);
        }
        sheet1.setCellAt(1, 1, "9");
        sheet1.setCellAt(1, 2, "7");
        sheet1.setCellAt(1, 3, "7");
        sheet1.setCellAt(1, 4, "6");
        sheet1.setCellAt(2, 1, "7");
        sheet1.setCellAt(2, 2, "9");
        sheet1.setCellAt(2, 3, "6");
        sheet1.setCellAt(2, 4, "7");
        sheet1.setCellAt(3, 1, "9");
        sheet1.setCellAt(3, 2, "9");
        sheet1.setCellAt(3, 3, "9");
        sheet1.setCellAt(3, 4, "8");
        sheet1.setCellAt(4, 1, "8");
        sheet1.setCellAt(4, 2, "8");
        sheet1.setCellAt(4, 3, "9");
        sheet1.setCellAt(4, 4, sheet1.getCellAt(4, 3));

        System.out.println("Initializing grades:");
        sheet1.printSheet();

        // inserting new column
        sheet1.addColumnAt(6);    // out of range
        System.out.println();
        System.out.println("Adding new empty column :");
        sheet1.addColumnAt(5);
        sheet1.printSheet();

        // initialising new column and calculating sum
        sheet1.setCellAt(0, 5, "Sum");
        for (int i = 1; i < sheet1.getNumOfRows(); i++) {
            int sum = 0;
            for (int j = 1; j < sheet1.getNumOfColumns() - 1; j++) {
                sum += Integer.parseInt(sheet1.getCellAt(i, j).getStringValue());

            }
            sheet1.setCellAt(i, 5, "" + sum);
        }
        System.out.println("Initialising new column and calculating sum:");
        sheet1.printSheet();


        // swap rows

        sheet1.swapRows(1, 6);   // out of range
        sheet1.swapRows(1, 4);
        System.out.println("Swap rows at indexes 1  and 4:");
        sheet1.printSheet();

        // swap columns
        sheet1.swapColumns(1, 6);   // out of range
        sheet1.swapColumns(1, 2);
        System.out.println("Swap columns at indexes 1  and 2:");
        sheet1.printSheet();

     // delete row
        sheet1.removeRow(2);
        System.out.println("remove row N 2:");
        sheet1.printSheet();

        // delete column
        sheet1.removeColumn(4);
        System.out.println("remove column N 4:");
        sheet1.printSheet();
    }
}
