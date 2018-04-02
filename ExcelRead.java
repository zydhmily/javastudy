import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	// 判断Excel的版本,获取Workbook
	public static Workbook getWorkbook(InputStream in, File file)
			throws IOException {
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL_XLS)) {
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) {
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

	// 判断文件是否是excel
	public static void checkExcelVaild(File file) throws Exception {
		if (!file.exists()) {
			throw new Exception("文件不存在");
		}
		if (!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file
				.getName().endsWith(EXCEL_XLSX)))) {
			throw new Exception("文件不是Excel");
		}
	}

	// 读取Excel
	public static void main(String[] args) throws Exception {
		// SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 同时支持Excel 2003、2007
			File excelFile = new File(
					"C:\\Users\\lingl\\Desktop\\ExcelReadTest.xlsx"); // 创建文件对象
			FileInputStream inFile = new FileInputStream(excelFile); // 文件流
			checkExcelVaild(excelFile);
			Workbook workbook = getWorkbook(inFile, excelFile);
			// 遍历第一个Sheet
			Sheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				try {
					// 如果当前行没有数据，跳出循环
					if (isRowEmpty(row)) {
						System.out.println("null");
						return;
					}
					int end = row.getLastCellNum();
					for (int i = 0; i < end; i++) {
						Cell cell = row.getCell(i);
						if (cell == null) {
							continue;
						}
						Object obj = getValue(cell);
						System.out.println(obj);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Object getValue(Cell cell) {
		Object obj = null;
		switch (cell.getCellTypeEnum()) {
		case BOOLEAN:
			obj = cell.getBooleanCellValue();
			break;
		case ERROR:
			obj = cell.getErrorCellValue();
			break;
		case NUMERIC:
			obj = cell.getNumericCellValue();
			break;
		case STRING:
			obj = cell.getStringCellValue();
			break;
		default:
			break;
		}
		return obj;
	}

	public static boolean isRowEmpty(Row row) {
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null)
				return false;
		}
		return true;
	}
}