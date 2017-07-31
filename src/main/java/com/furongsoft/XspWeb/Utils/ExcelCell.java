package com.furongsoft.XspWeb.Utils;

/**
 * Created by LYD on 2016/9/27.
 */
public class ExcelCell
{
    private Object text;
    private CellStyle cellStyle  = new CellStyle();
    private ExcelCell[] excelCells;
    private int x;
    private int lx;
    private int y;
    private int ly;

    public ExcelCell()
    {
    }

    public ExcelCell(Object text, ExcelCell[] excelCells)
    {
        this.text = text;
        this.excelCells = excelCells;
    }

    public ExcelCell(Object text)
    {
        this.text = text;
    }

    public Object getText()
    {
        return text;
    }

    public void setText(Object text)
    {
        this.text = text;
    }

    public CellStyle getCellStyle()
    {
        return cellStyle;
    }

    public void setCellStyle(CellStyle cellStyle)
    {
        this.cellStyle = cellStyle;
    }

    public ExcelCell[] getExcelCells()
    {
        return excelCells;
    }

    public void setExcelCells(ExcelCell[] excelCells)
    {
        this.excelCells = excelCells;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getLx()
    {
        return lx;
    }

    public void setLx(int lx)
    {
        this.lx = lx;
    }

    public int getLy()
    {
        return ly;
    }

    public void setLy(int ly)
    {
        this.ly = ly;
    }
}