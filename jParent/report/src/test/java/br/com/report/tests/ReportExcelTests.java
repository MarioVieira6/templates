/**
 *
 */
package br.com.report.tests;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;

import br.com.report.BasicTest;
import br.com.report.poi.excel.ReportExcel;
import br.com.report.tests.utils.TestClass;

/**
 * Simple write file test.
 */
public class ReportExcelTests extends BasicTest {

    /**
     * Teste de geracao de planilha de forma dinamica.
     */
    @Test
    public void writeExcelTest() {
        ReportExcel reportExcel = new ReportExcel("ReportExcelTests.xlsx");

        SXSSFWorkbook workbook = reportExcel.writeSheet(TestClass.getTestData());
        reportExcel.generateSheet(workbook);
        reportExcel.closeWorkbook();
    }
}
