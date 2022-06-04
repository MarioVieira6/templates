/**
 *
 */
package br.com.report.poi.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.streaming.*;

/**
 * Generic functionality to read and write Excel file.
 */
public class ReportExcel {

	/**
	 * Logs.
	 */
	private static final Log LOGGER = LogFactory.getLog(ReportExcel.class);

	private static final String ROOT_PATH = System.getProperty("user.home") + "/Downloads/";

	private final String fileName;

	private final List<String> fieldNames;

	/**
	 * Initialize parameters.
	 *
	 * @param fileName
	 */
	public ReportExcel(String fileName) {
		this.fileName = fileName;
		this.fieldNames = new ArrayList<>();
	}

	/**
	 * @return Initialize creation of sheet.
	 */
	private SXSSFWorkbook getWorkbook() {
		return new SXSSFWorkbook(100);
	}

	/**
	 * Initialize dynamic writing in the excel sheet.
	 *
	 * @param data Sheet data
	 */
	public <T> SXSSFWorkbook writeSheet(List<T> data) {
		SXSSFSheet sheet = getWorkbook().createSheet(data.get(0).getClass().getName());
		try {
			Field[] fields = data.get(0).getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fieldNames.add(fields[i].getName());
			}

			int rowCount = 0;
			int columnCount = 0;

			SXSSFRow row = sheet.createRow(rowCount++);
			for (String fieldName : fieldNames) {
				SXSSFCell cell = row.createCell(columnCount++);
				cell.setCellValue(fieldName);
			}

			Class<? extends Object> clazz = data.get(0).getClass();
			for (T t : data) {
				row = sheet.createRow(rowCount++);
				columnCount = 0;
				for (String fieldName : fieldNames) {
					SXSSFCell cell = row.createCell(columnCount);

					Method method = clazz.getMethod("get" + StringUtils.capitalize(fieldName));
					Object value = method.invoke(t, (Object[]) null);

					if (value != null) {
						if (value instanceof String) {
							cell.setCellValue((String) value);
						} else if (value instanceof Integer) {
							cell.setCellValue((Integer) value);
						} else if (value instanceof Long) {
							cell.setCellValue((Long) value);
						} else if (value instanceof Double) {
							cell.setCellValue((Double) value);
						}
					}
					columnCount++;
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LOGGER.error("[POI]-ERROR TO ACCESS METHOD OF THE CLASS: " + e.getMessage());

			throw new RuntimeException("[POI]-ERROR TO ACCESS METHOD OF THE CLASS: " + e.getMessage());
		} catch (NoSuchMethodException | SecurityException e) {
			LOGGER.error("[POI]-NOT FOUND METHOD OF THE CLASS: " + e.getMessage());

			throw new RuntimeException("[POI]-NOT FOUND METHOD OF THE CLASS: " + e.getMessage());
		}
		return sheet.getWorkbook();
	}

	/**
	 * Generate filled workbook with data.
	 *
	 * @param workbook Filled workbook
	 */
	public void generateSheet(SXSSFWorkbook workbook) {
		Path filePath = Paths.get(ROOT_PATH + fileName);

		try (FileOutputStream fileOut = new FileOutputStream(filePath.toFile())) {
			workbook.write(fileOut);
		} catch (IOException e) {
			LOGGER.error("[POI]-ERROR TO WRITE WORKBOOK: " + e.getMessage());

			throw new RuntimeException("[POI]-ERROR TO WRITE WORKBOOK: " + e.getMessage());
		}
	}

	/**
	 * Make download of the workbook.
	 *
	 * @param workbook Filled workbook
	 * @param response Information to send generated workbook to client
	 */
	public void downloadSheet(SXSSFWorkbook workbook, HttpServletResponse response) {
		Path filePath = Paths.get(ROOT_PATH + fileName);

		try (FileOutputStream fileOut = new FileOutputStream(filePath.toFile())) {
			workbook.write(fileOut);

			FileInputStream inputStream = new FileInputStream(filePath.toFile());

			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			response.setContentType("application/octet-stream");

			ServletOutputStream outputStream = response.getOutputStream();
			IOUtils.copy(inputStream, outputStream);

			Files.delete(filePath);
		} catch (Exception e) {
			LOGGER.info("[POI]-ERROR TO MAKE DOWNLOAD: " + e.getMessage());
		}
	}

	/**
	 * Close processing of the Workbook.
	 */
	public void closeWorkbook() {
		try {
			getWorkbook().close();
		} catch (IOException e) {
			LOGGER.error("[POI]-ERROR TO CLOSE WORKBOOK: " + e.getMessage());
		}
	}
}
