package com.geekbounty.engineeringinvoice;

import com.itextpdf.text.Font;

/**
 * Created by Mussa on 5/29/2018.
 */

public class StaticValue {
    public static Font FONT_TABLE_HEADER = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.BOLD);
    public static  String PATH_PRODUCT_REPORT="/SIAS/REPORT_PRODUCT/";
    public static Font FONT_TITLE = new Font(Font.FontFamily.TIMES_ROMAN, 22,Font.BOLD);
    public static Font FONT_SUBTITLE = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
    public static Font FONT_HEADER_FOOTER = new Font(Font.FontFamily.UNDEFINED, 7, Font.ITALIC);
    public static Font FONT_BODY = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);
}
