package norvidi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Book {
    private String number;
    private String client;
    private String address;
    private String zone;
    private String date;
    private String price;
    private String iva;
    private String total;

    Book() {
    }

    public String toString() {
        return String.format("%s - %s - %s - %s - %s - %s - %s - %s", number, client, address, zone, date, price, iva, total);
    }

    // getters and setters

    private Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }

        return null;
    }

    List<Book> readBooksFromExcelFile(String excelFilePath) throws IOException {
        List<Book> listBooks = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            Book aBook = new Book();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        aBook.setNumber((String) getCellValue(nextCell)+"");
                        break;
                    case 1:
                        aBook.setClient((String) getCellValue(nextCell)+"");
                        break;
                    case 2:
                        aBook.setAddress((String) getCellValue(nextCell)+"");
                        break;
                    case 3:
                        aBook.setZone((String) getCellValue(nextCell)+"");
                        break;
                    case 4:
                        aBook.setDate((String) String.valueOf(getCellValue(nextCell))+"");
                        break;
                    case 5:
                        aBook.setPrice((String) getCellValue(nextCell)+"");
                        break;
                    case 6:
                        aBook.setIva((String) getCellValue(nextCell)+"");
                        break;
                    case 7:
                        aBook.setTotal(String.valueOf(getCellValue(nextCell)));
                        break;
                }


            }
            listBooks.add(aBook);
        }

        workbook.close();
        inputStream.close();

        return listBooks;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    private void setClient(String client) {
        this.client = client;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setZone(String zone) {
        this.zone = zone;
    }

    private void setDate(String date) {
        this.date = date;
    }

    private void setPrice(String price) {
        this.price = price;
    }

    private void setIva(String iva) {
        this.iva = iva;
    }

    private void setTotal(String total) {
        this.total = total;
    }
}

