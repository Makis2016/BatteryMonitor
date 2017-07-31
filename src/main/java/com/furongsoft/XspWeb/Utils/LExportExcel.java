package com.furongsoft.XspWeb.Utils;

import com.furongsoft.XspWeb.Common.Tracker;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 导出Excel公共方法
 */
public class LExportExcel
{

    // 导出表的文件名称
    private String fileName;

    private DblCombinedCellDataSource dblCombinedCellDataSource;

    private HSSFWorkbook workbook = new HSSFWorkbook();  // 创建工作簿对象

    private String workBookName = "数据";

    // 导出表的数据源
    private List<ExcelCell[]> dataList = new ArrayList<ExcelCell[]>();

    // 列头样式
    private HSSFCellStyle h_style;

    // 正文样式
    private HSSFCellStyle style;


    //构造方法，传入要导出的数据
    public LExportExcel(List<ExcelCell[]> dataList, String fileName)
    {
        this.dataList = dataList;
        this.fileName = fileName;
        if ((dataList != null) && (dataList.size() > 1)) {
            if (dataList.get(0) != null && dataList.get(0).length > 0) {
                if (dataList.get(0)[0].getCellStyle() != null) {
                    this.h_style = this.getCellStyle(dataList.get(0)[0].getCellStyle());
                }
            }
            if ((dataList.get(1) != null) && (dataList.get(1).length > 0)) {
                if (dataList.size() > 1) {
                    if (dataList.get(1)[0].getCellStyle() != null) {
                        this.style = this.getCellStyle(dataList.get(1)[0].getCellStyle());
                    }
                }
            }
        }
    }

    //构造方法，传入要导出的数据
    public LExportExcel(List<ExcelCell[]> dataList)
    {
        this.dataList = dataList;
        if ((dataList != null) && (dataList.size() > 1)) {
            if (dataList.get(0) != null && dataList.get(0).length > 0) {
                if (dataList.get(0)[0].getCellStyle() != null) {
                    this.h_style = this.getCellStyle(dataList.get(0)[0].getCellStyle());
                }
            }
            if ((dataList.get(1) != null) && (dataList.get(1).length > 0)) {
                if (dataList.size() > 1) {
                    if (dataList.get(1)[0].getCellStyle() != null) {
                        this.style = this.getCellStyle(dataList.get(1)[0].getCellStyle());
                    }
                }
            }
        }
    }

    //构造方法，传入要导出的数据
    public LExportExcel(String workBookName, List<ExcelCell[]> dataList)
    {
        this.dataList = dataList;
        this.workBookName = workBookName;
        if ((dataList != null) && (dataList.size() > 1)) {
            if ((dataList.get(0) != null) && (dataList.get(0).length > 0)) {
                if (dataList.get(0)[0].getCellStyle() != null) {
                    this.h_style = this.getCellStyle(dataList.get(0)[0].getCellStyle());
                }
            }
            if ((dataList.get(1) != null) && (dataList.get(1).length > 0)) {
                if (dataList.size() > 1) {
                    if (dataList.get(1)[0].getCellStyle() != null) {
                        this.style = this.getCellStyle(dataList.get(1)[0].getCellStyle());
                    }
                }
            }
        }
    }

    //构造方法，传入要导出的数据
    public LExportExcel(DblCombinedCellDataSource dblCombinedCellDataSource, List<ExcelCell[]> dataList)
    {
        this.dataList = dataList;
        this.dblCombinedCellDataSource = dblCombinedCellDataSource;
        if(dblCombinedCellDataSource != null){
            this.h_style = null;
            if ((dataList != null) && (dataList.size() > 1)) {
                if ((dataList.get(0) != null) && (dataList.get(0).length > 0)) {
                    if (dataList.get(0)[0].getCellStyle() != null) {
                        this.style = this.getCellStyle(dataList.get(0)[0].getCellStyle());
                    }
                }
            }
        }

    }

    //构造方法，传入要导出的数据
    public LExportExcel(DblCombinedCellDataSource dblCombinedCellDataSource, List<ExcelCell[]> dataList, String fileName)
    {
        this.dataList = dataList;
        this.dblCombinedCellDataSource = dblCombinedCellDataSource;
        this.fileName = fileName;
        if(dblCombinedCellDataSource!=null){
            this.h_style = null;
            if ((dataList != null) && (dataList.size() > 1)) {
                if ((dataList.get(0) != null) && (dataList.get(0).length > 0)) {
                    if (dataList.get(0)[0].getCellStyle() != null) {
                        this.style = this.getCellStyle(dataList.get(0)[0].getCellStyle());
                    }
                }
            }
        }
    }

    //构造方法，传入要导出的数据
    public LExportExcel(String workBookName, DblCombinedCellDataSource dblCombinedCellDataSource, List<ExcelCell[]> dataList)
    {
        this.dataList = dataList;
        this.dblCombinedCellDataSource = dblCombinedCellDataSource;
        this.workBookName = workBookName;
        if(dblCombinedCellDataSource!=null){
            this.h_style = null;
            if ((dataList != null) && (dataList.size() > 1)) {
                if ((dataList.get(0) != null) && (dataList.get(0).length > 0)) {
                    if (dataList.get(0)[0].getCellStyle() != null) {
                        this.style = this.getCellStyle(dataList.get(0)[0].getCellStyle());
                    }
                }
            }
        }
    }

    //构造方法，传入要导出的数据
    public LExportExcel(String workBookName, DblCombinedCellDataSource dblCombinedCellDataSource)
    {
        this.dblCombinedCellDataSource = dblCombinedCellDataSource;
        this.workBookName = workBookName;
    }

    //构造方法，传入要导出的数据
    public LExportExcel(DblCombinedCellDataSource dblCombinedCellDataSource)
    {
        this.dblCombinedCellDataSource = dblCombinedCellDataSource;
    }

    /*
     * 导出数据
     *
     * */
    public void export(HttpServletResponse response) throws Exception
    {
        try {
            HSSFSheet sheet = workbook.createSheet(workBookName);                  // 创建工作表

            // 定义所需行数索引 和 列数
            int rowIndex = -1;
            int columnCount = 0;
            if (dblCombinedCellDataSource != null) {
                rowIndex = crateDblCellToRow(this.dblCombinedCellDataSource.getExcelCellsList(), sheet);
                columnCount = this.dblCombinedCellDataSource.getCellCount();
            }

            if (dataList != null) {
                //将查询出的数据设置到sheet对应的单元格中
                Integer integerType = 0;
                Double doubleType = 0D;
                for (int i = 0; i < dataList.size(); i++) {
                    ExcelCell[] obj = dataList.get(i);//遍历每个对象
                    HSSFRow row = sheet.createRow(i + 1 + rowIndex);//创建所需的行数
                    columnCount = obj.length;
                    for (int j = 0; j < columnCount; j++) {
                        if (obj[j] != null) {
                            HSSFCell cell = null;   //设置单元格的数据类型
                            Object value = obj[j].getText();
                            cell = convertTypeToCellByValue(row, j, value);
                            if (value != null && !"".equals(value)) {
                                if (value.getClass().equals(integerType.getClass()) || value.getClass().equals(doubleType.getClass())) {
                                    //设置单元格的值
                                    cell.setCellValue(Double.parseDouble(value.toString()));
                                }
                                else {
                                    //设置单元格的值
                                    cell.setCellValue(value.toString());
                                }
                            }
                            else {
                                cell.setCellValue("");
                            }

                            if (i == 0 && this.h_style != null) {
                                //设置单元格样式
                                cell.setCellStyle(this.h_style);
                            }
                            else if (i > 0 && this.style != null) {
                                //设置单元格样式
                                cell.setCellStyle(this.style);
                            }

                            int rowx = obj[j].getX();
                            int lrowx = obj[j].getLx();
                            int rowy = obj[j].getY();
                            int lrowy = obj[j].getLy();
                            if (lrowx > rowx || lrowy > rowy) {
                                sheet.addMergedRegion(new CellRangeAddress(rowy, lrowy, rowx, lrowx));
                            }
                            j += lrowx - rowx;
                            i += lrowy - rowy;
                        }
                    }
                }
            }

            //让列宽随着导出的列长自动适应
            for (int colIndex = 0; colIndex < columnCount; colIndex++) {
                int width = sheet.getColumnWidth(colIndex);
                int columnWidth = width / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    }
                    else {
                        currentRow = sheet.getRow(rowNum);
                    }

                    if (currentRow.getCell(colIndex) != null) {
                        HSSFCell currentCell = currentRow.getCell(colIndex);
                        if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (length > columnWidth) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                sheet.setColumnWidth(colIndex, (columnWidth + 4) * 256);
            }

            if (this.workbook != null) {
                try {
                    String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
                    if (!StringUtils.isNullOrEmpty(this.fileName)) {
                        fileName = this.fileName + ".xls";
                    }

                    String headStr = "attachment; filename=\"" + fileName + "\"";
                    response.setContentType("APPLICATION/OCTET-STREAM");
                    response.setHeader("Content-Disposition", headStr);
                    OutputStream out = response.getOutputStream();
                    this.workbook.write(out);
                }
                catch (IOException e) {
                    Tracker.e(e);
                }
            }

        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }

    private int crateDblCellToRow(List<ExcelCell[]> excelCellsList, HSSFSheet sheet)
    {
        if (excelCellsList != null && excelCellsList.size() > 0) {
            List<HSSFCell[]> cells = initDblCell(sheet);
            if (cells != null && cells.size() > 0) {
                for (int rowIndex = 0; rowIndex < excelCellsList.size(); rowIndex++) {
                    setDblCellValue(cells.get(rowIndex), excelCellsList.get(rowIndex), sheet);
                }
            }
            else {
                for (int rowIndex = 0; rowIndex < excelCellsList.size(); rowIndex++) {
                    HSSFRow rowRowName = sheet.createRow(rowIndex);
                    setDblCellValue(rowRowName, excelCellsList.get(rowIndex), sheet);
                }
            }
            return excelCellsList.size() - 1;
        }
        return 0;
    }

    private List<HSSFCell[]> initDblCell(HSSFSheet sheet)
    {
        List<HSSFCell[]> hssfCells = new ArrayList<>();
        HSSFCell[] hssfCells1 = null;
        for (int rowIndex = 0; rowIndex < this.dblCombinedCellDataSource.getRowCount(); rowIndex++) {
            HSSFRow rowRowName = sheet.createRow(rowIndex);
            hssfCells1 = new HSSFCell[this.dblCombinedCellDataSource.getCellCount()];
            for (int n = 0; n < this.dblCombinedCellDataSource.getCellCount(); n++) {
                HSSFCell cellRowName = rowRowName.createCell(n);
                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString("");
                cellRowName.setCellValue(text);                                 //设置列头单元格的值
                HSSFCellStyle columnTopStyle = getCellStyle(this.dblCombinedCellDataSource.getColumnTopStyle());
                cellRowName.setCellStyle(columnTopStyle);  //设置列头单元格样式
                hssfCells1[n] = cellRowName;
            }
            hssfCells.add(hssfCells1);
        }
        return hssfCells;
    }

    private void setDblCellValue(HSSFCell[] cells, ExcelCell[] excelCells, HSSFSheet sheet)
    {
        if (cells != null && cells.length > 0) {
            // 将列头设置到sheet的单元格中
            int count = excelCells.length;
            for (int n = 0; n < count; n++) {
                HSSFCell cellRowName = cells[excelCells[n].getX()];//rowRowName.initDblCell(excelCells[n].getX());               //创建列头对应个数的单元格
                int rowx = excelCells[n].getX();
                int lrowx = excelCells[n].getLx();
                int rowy = excelCells[n].getY();
                int lrowy = excelCells[n].getLy();
                if (lrowx > rowx || lrowy > rowy) {
                    sheet.addMergedRegion(new CellRangeAddress(rowy, lrowy, rowx, lrowx));
                }

                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(excelCells[n].getText().toString());
                cellRowName.setCellValue(text);                                 //设置列头单元格的值
                HSSFCellStyle columnStyle = getCellStyle(excelCells[n].getCellStyle());
                cellRowName.setCellStyle(columnStyle);  //设置列头单元格样式
            }
        }
    }

    private void setDblCellValue(HSSFRow rowRowName, ExcelCell[] excelCells, HSSFSheet sheet)
    {
        if (excelCells != null && excelCells.length > 0) {
            // 将列头设置到sheet的单元格中
            int count = excelCells.length;
            for (int n = 0; n < count; n++) {
                HSSFCell cellRowName = rowRowName.createCell(excelCells[n].getX());               //创建列头对应个数的单元格
                int rowx = excelCells[n].getX();
                int lrowx = excelCells[n].getLx();
                int rowy = excelCells[n].getY();
                int lrowy = excelCells[n].getLy();
                if (lrowx > rowx || lrowy > rowy) {
                    sheet.addMergedRegion(new CellRangeAddress(rowy, lrowy, rowx, lrowx));
                }

                cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING);             //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(excelCells[n].getText().toString());
                cellRowName.setCellValue(text);//设置列头单元格的值
                HSSFCellStyle columnStyle = getCellStyle(excelCells[n].getCellStyle());
                cellRowName.setCellStyle(columnStyle);  //设置列头单元格样式
            }
        }
    }

    /*
    * 设置单元格格类型
    */
    private HSSFCell convertTypeToCellByValue(HSSFRow row, int j, Object value)
    {
        if (value != null) {
            Integer integerType = 0;
            Double doubleTyep = 0d;
            Class clazz = value.getClass();
            if (clazz.equals(integerType.getClass())) {
                return row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);
            }
            else if (clazz.equals(doubleTyep.getClass())) {
                return row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);
            }
        }
        return row.createCell(j, HSSFCell.CELL_TYPE_STRING);
    }

    /*
     * 列头单元格样式
     */
    private HSSFCellStyle getCellStyle(CellStyle excelCellStyle)
    {
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints(excelCellStyle.getFontSize());
        //字体加粗
        font.setBoldweight(excelCellStyle.getFontBoldweight());
        //设置字体名字
        font.setFontName(excelCellStyle.getFontName());

        //设置底边框;
        style.setBorderBottom(excelCellStyle.getStyleBottomBORDER_THIN());
        //设置底边框颜色;
        style.setBottomBorderColor(excelCellStyle.getStyleBottomColorIndex());
        //设置左边框;
        style.setBorderLeft(excelCellStyle.getStyleLeftBORDER_THIN());
        //设置左边框颜色;
        style.setLeftBorderColor(excelCellStyle.getStyleLeftColorIndex());
        //设置右边框;
        style.setBorderRight(excelCellStyle.getStyleRigtBORDER_THIN());
        //设置右边框颜色;
        style.setRightBorderColor(excelCellStyle.getStyleRightColorIndex());
        //设置顶边框;
        style.setBorderTop(excelCellStyle.getStyleTopBORDER_THIN());
        //设置顶边框颜色;
        style.setTopBorderColor(excelCellStyle.getStyleTopColorIndex());
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(excelCellStyle.isStyleWrapText());
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(excelCellStyle.getStyleALIGN_CENTER());
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(excelCellStyle.getStyleVERTICAL_CENTER());

        return style;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public DblCombinedCellDataSource getDblCombinedCellDataSource()
    {
        return dblCombinedCellDataSource;
    }

    public void setDblCombinedCellDataSource(DblCombinedCellDataSource dblCombinedCellDataSource)
    {
        this.dblCombinedCellDataSource = dblCombinedCellDataSource;
    }

    public HSSFWorkbook getWorkbook()
    {
        return workbook;
    }

    public void setWorkbook(HSSFWorkbook workbook)
    {
        this.workbook = workbook;
    }

    public String getWorkBookName()
    {
        return workBookName;
    }

    public void setWorkBookName(String workBookName)
    {
        this.workBookName = workBookName;
    }

    public List<ExcelCell[]> getDataList()
    {
        return dataList;
    }

    public void setDataList(List<ExcelCell[]> dataList)
    {
        this.dataList = dataList;
    }
}