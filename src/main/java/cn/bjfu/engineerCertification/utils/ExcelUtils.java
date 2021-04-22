package cn.bjfu.engineerCertification.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * Created by jxy on 2021/4/22 0022 16:21
 */
public class ExcelUtils {
    public static String getValue(XSSFCell xSSFCell) {
        if (null == xSSFCell) {
            return "";
        }
        if (xSSFCell.getCellType() == xSSFCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(xSSFCell.getBooleanCellValue());
        } else if (xSSFCell.getCellType() == xSSFCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(xSSFCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(xSSFCell.getStringCellValue());
        }
    }
}
