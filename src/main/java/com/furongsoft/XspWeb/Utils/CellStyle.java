package com.furongsoft.XspWeb.Utils;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * Created by LYD on 2016/9/27.
 */
public class CellStyle
{
    private int xRowCount = 0;
    private int yCellCount = 0;

    public int getxRowCount()
    {
        return xRowCount;
    }

    public void setxRowCount(int xRowCount)
    {
        this.xRowCount = xRowCount;
    }

    public int getyCellCount()
    {
        return yCellCount;
    }

    public void setyCellCount(int yCellCount)
    {
        this.yCellCount = yCellCount;
    }

    //设置底边框;
    private short styleBottomBORDER_THIN = HSSFCellStyle.BORDER_THIN;
    //设置底边框颜色;
    private short styleBottomColorIndex = HSSFColor.BLACK.index;
    //设置左边框;
    private short styleLeftBORDER_THIN = HSSFCellStyle.BORDER_THIN;
    //设置左边框颜色;
    private short styleLeftColorIndex = HSSFColor.BLACK.index;
    //设置右边框;
    private short styleRigtBORDER_THIN = HSSFCellStyle.BORDER_THIN;
    //设置右边框颜色;
    private short styleRightColorIndex = HSSFColor.BLACK.index;
    //设置顶边框;
    private short styleTopBORDER_THIN = HSSFCellStyle.BORDER_THIN;
    //设置顶边框颜色;
    private short styleTopColorIndex = HSSFColor.BLACK.index;
    //设置自动换行;
    private boolean styleWrapText = true;
    //设置水平对齐的样式为居中对齐;
    private short styleALIGN_CENTER = HSSFCellStyle.ALIGN_CENTER;
    //设置垂直对齐的样式为居中对齐;
    private short styleVERTICAL_CENTER = HSSFCellStyle.VERTICAL_CENTER;

    private short fontSize = 11;

    private short fontBoldweight = HSSFFont.BOLDWEIGHT_BOLD;

    private String fontName = "Courier New";

    public short getStyleBottomBORDER_THIN()
    {
        return styleBottomBORDER_THIN;
    }

    public void setStyleBottomBORDER_THIN(short styleBottomBORDER_THIN)
    {
        this.styleBottomBORDER_THIN = styleBottomBORDER_THIN;
    }

    public short getStyleBottomColorIndex()
    {
        return styleBottomColorIndex;
    }

    public void setStyleBottomColorIndex(short styleBottomColorIndex)
    {
        this.styleBottomColorIndex = styleBottomColorIndex;
    }

    public short getStyleLeftBORDER_THIN()
    {
        return styleLeftBORDER_THIN;
    }

    public void setStyleLeftBORDER_THIN(short styleLeftBORDER_THIN)
    {
        this.styleLeftBORDER_THIN = styleLeftBORDER_THIN;
    }

    public short getStyleLeftColorIndex()
    {
        return styleLeftColorIndex;
    }

    public void setStyleLeftColorIndex(short styleLeftColorIndex)
    {
        this.styleLeftColorIndex = styleLeftColorIndex;
    }

    public short getStyleRigtBORDER_THIN()
    {
        return styleRigtBORDER_THIN;
    }

    public void setStyleRigtBORDER_THIN(short styleRigtBORDER_THIN)
    {
        this.styleRigtBORDER_THIN = styleRigtBORDER_THIN;
    }

    public short getStyleRightColorIndex()
    {
        return styleRightColorIndex;
    }

    public void setStyleRightColorIndex(short styleRightColorIndex)
    {
        this.styleRightColorIndex = styleRightColorIndex;
    }

    public short getStyleTopBORDER_THIN()
    {
        return styleTopBORDER_THIN;
    }

    public void setStyleTopBORDER_THIN(short styleTopBORDER_THIN)
    {
        this.styleTopBORDER_THIN = styleTopBORDER_THIN;
    }

    public short getStyleTopColorIndex()
    {
        return styleTopColorIndex;
    }

    public void setStyleTopColorIndex(short styleTopColorIndex)
    {
        this.styleTopColorIndex = styleTopColorIndex;
    }

    public boolean isStyleWrapText()
    {
        return styleWrapText;
    }

    public void setStyleWrapText(boolean styleWrapText)
    {
        this.styleWrapText = styleWrapText;
    }

    public short getStyleALIGN_CENTER()
    {
        return styleALIGN_CENTER;
    }

    public void setStyleALIGN_CENTER(short styleALIGN_CENTER)
    {
        this.styleALIGN_CENTER = styleALIGN_CENTER;
    }

    public short getStyleVERTICAL_CENTER()
    {
        return styleVERTICAL_CENTER;
    }

    public void setStyleVERTICAL_CENTER(short styleVERTICAL_CENTER)
    {
        this.styleVERTICAL_CENTER = styleVERTICAL_CENTER;
    }

    public short getFontSize()
    {
        return fontSize;
    }

    public void setFontSize(short fontSize)
    {
        this.fontSize = fontSize;
    }

    public short getFontBoldweight()
    {
        return fontBoldweight;
    }

    public void setFontBoldweight(short fontBoldweight)
    {
        this.fontBoldweight = fontBoldweight;
    }

    public String getFontName()
    {
        return fontName;
    }

    public void setFontName(String fontName)
    {
        this.fontName = fontName;
    }
}