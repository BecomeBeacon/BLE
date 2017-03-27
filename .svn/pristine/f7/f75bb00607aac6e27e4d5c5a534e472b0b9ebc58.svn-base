package com.example.changsu.bluetoothle;

import android.os.Environment;
import android.util.Log;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by SJ on 2015-05-11.
 */
public class LogExcelFile {
    final String TAG = getClass().getSimpleName();
    String filename;
    String downLoadPath = Environment.getExternalStorageDirectory() + "/Download/";

    HSSFWorkbook workbook = new HSSFWorkbook();

    public LogExcelFile(){}
    public void init(){
        filename =
                downLoadPath + "BLE Log " +
                        new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(
                                Calendar.getInstance().getTime()).toString()
                        +".xls";

        Log.i(TAG, "LOG : " + filename);
    }

    public boolean makeExcelFile()
    {
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(filename);
            workbook.write(fs);
            fs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {

        }
        return true;
    }

    public boolean writeLog(String bleAddress, String RSSIValue)
    {
        String logDate = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(Calendar.getInstance().getTime()).toString();
        HSSFSheet sheet = null;

        bleAddress = bleAddress.replaceAll(":", "");

        boolean isFound = false;
        int rows = 0;

        for (int i=0; i < workbook.getNumberOfSheets(); i++)
        {
            if (workbook.getSheetName(i).equals(bleAddress))
            {
                isFound = true;
                sheet = workbook.getSheetAt(i);
                rows = sheet.getPhysicalNumberOfRows();
            }
        }

        if (!isFound)
        {
            sheet = workbook.createSheet(bleAddress);
        }

        HSSFRow row = sheet.createRow(rows);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue(logDate);

        cell = row.createCell(1);
        cell.setCellValue(RSSIValue);

        makeExcelFile();

        return true;
    }
    public boolean writeLog(String bleAddress, String RSSIValue, String KalmanRSSIValue)
    {
        String logDate = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(Calendar.getInstance().getTime()).toString();
        HSSFSheet sheet = null;

        bleAddress = bleAddress.replaceAll(":", "");

        boolean isFound = false;
        int rows = 0;

        for (int i=0; i < workbook.getNumberOfSheets(); i++)
        {
            if (workbook.getSheetName(i).equals(bleAddress))
            {
                isFound = true;
                sheet = workbook.getSheetAt(i);
                rows = sheet.getPhysicalNumberOfRows();
            }
        }

        if (!isFound)
        {
            sheet = workbook.createSheet(bleAddress);
        }

        HSSFRow row = sheet.createRow(rows);

        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue(logDate);

        cell = row.createCell(1);
        cell.setCellValue(RSSIValue);

        cell = row.createCell(2);
        cell.setCellValue(KalmanRSSIValue);

        makeExcelFile();

        return true;
    }

}
