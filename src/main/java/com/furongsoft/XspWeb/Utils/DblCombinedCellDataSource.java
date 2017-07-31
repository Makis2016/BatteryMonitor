package com.furongsoft.XspWeb.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LYD on 2016/9/27.
 */
public class DblCombinedCellDataSource
{
    private int cellCount;
    private int rowCount = 2;
    private List<ExcelCell[]> excelCellsList = new ArrayList<>();
    private CellStyle columnTopStyle = new CellStyle();

    public DblCombinedCellDataSource(ExcelCell[] excelCells)
    {
        this.cellCount = 0;
        excelCellsList.add(excelCells);
        addLeve2LydExcelCells(excelCells);
        setCellStyle(excelCells);
        CellCount(excelCells);
        setCellsX(0, 0, 0, 0, excelCells);
    }

    private void addLeve2LydExcelCells(ExcelCell[] excelCells)
    {
        List<ExcelCell> lydExcelCells = new ArrayList<>();
        for (int i = 0; i < excelCells.length; i++) {
            if (excelCells[i].getExcelCells() != null && excelCells[i].getExcelCells().length > 0) {
                for (ExcelCell excelCell : excelCells[i].getExcelCells()) {
                    lydExcelCells.add(excelCell);
                }
            }
        }
        if(lydExcelCells.size()>0){
            ExcelCell[] excelCells_level2 = new ExcelCell[lydExcelCells.size()];
            for (int i = 0; i < lydExcelCells.size(); i++) {
                excelCells_level2[i] = lydExcelCells.get(i);
            }
            this.excelCellsList.add(excelCells_level2);
        }
    }

    private void setCellStyle(ExcelCell[] excelCells)
    {
        if (excelCells != null) {
            for (ExcelCell excelCell : excelCells) {
                setCellStyle(excelCell);
            }
        }
    }

    private void setCellStyle(ExcelCell excelCell)
    {
        if (excelCell.getExcelCells() != null && excelCell.getExcelCells().length > 0) {
            int rowCount = excelCell.getExcelCells().length - 1;
            excelCell.getCellStyle().setxRowCount(rowCount);
        }
        else {
            excelCell.getCellStyle().setyCellCount(this.rowCount - 1);
        }
    }

    private void CellCount(ExcelCell[] excelCells)
    {
        if (excelCells != null) {
            for (ExcelCell excelCell : excelCells) {
                int temp = CellCount(excelCell);
                this.cellCount += temp;
            }
        }
    }

    private int CellCount(ExcelCell excelCell)
    {
        if (excelCell == null) {
            return 1;
        }
        if (excelCell.getExcelCells() == null) {
            return 1;
        }
        else {
            CellCount(excelCell.getExcelCells());
        }
        return 0;
    }

    private void setCellsX(int x, int lx, int y, int ly, ExcelCell[] excelCells)
    {
        if (excelCells != null && excelCells.length > 0) {
            for (int i = 0; i < excelCells.length; i++) {
                if (i > 0 && x == 0) {
                    this.setX(i, excelCells);
                }
                else if (x > 0) {
                    if (i == 0) {
                        excelCells[i].setX(x);

                        int xRowCount = excelCells[i].getCellStyle().getxRowCount();
                        int llx = x + xRowCount;
                        excelCells[i].setLx(llx);
                    }
                    else {
                        this.setX(i, excelCells);
                    }
                }
                else if (i == 0 && x == 0) {
                    excelCells[i].setX(x);
                    int xRowCount = excelCells[i].getCellStyle().getxRowCount();
                    if (xRowCount > 0) {
                        int llx = x + xRowCount;
                        excelCells[i].setLx(llx);
                    }
                }


                if (ly == 0) {
                    int yCellCount = excelCells[i].getCellStyle().getyCellCount();
                    excelCells[i].setLy(yCellCount);
                }
                else if (ly > 0) {
                    int yy = ly + 1;
                    excelCells[i].setY(yy);

                    int lly = y + 1;
                    excelCells[i].setLy(lly);
                }
            }

            for (int i = 0; i < excelCells.length; i++) {
                setCellX(excelCells[i]);
            }
        }
    }

    private void setCellX(ExcelCell excelCell)
    {
        if (excelCell != null) {
            if (excelCell.getExcelCells() != null && excelCell.getExcelCells().length > 0) {
                ExcelCell[] excelCells = excelCell.getExcelCells();
                setCellsX(excelCell.getX(), excelCell.getLx(), excelCell.getY(), excelCell.getLy(), excelCells);
            }
        }

    }

    private void setX(int i, ExcelCell[] excelCells)
    {
        int xRowCount = excelCells[i - 1].getCellStyle().getxRowCount();
        int pX = excelCells[i - 1].getX();
        int xx = pX + xRowCount + 1;
        excelCells[i].setX(xx);

        xRowCount = excelCells[i].getCellStyle().getxRowCount();
        int llx = xx + xRowCount;
        excelCells[i].setLx(llx);
    }

    public int getCellCount()
    {
        return cellCount;
    }

    public List<ExcelCell[]> getExcelCellsList()
    {
        return excelCellsList;
    }

    public int getRowCount()
    {
        return rowCount;
    }

    public CellStyle getColumnTopStyle()
    {
        return columnTopStyle;
    }

    public void setColumnTopStyle(CellStyle columnTopStyle)
    {
        this.columnTopStyle = columnTopStyle;
    }
}