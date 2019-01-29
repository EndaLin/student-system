package me.service;

import java.io.InputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author wt
 * @description 该借口用于提供读取不同版本Excel的方法操作
 */
public interface IReadExcelService {

	/**
	 * @description 根据流来读取Excel文件
	 * @param inputStream
	 * @param isExcel2003
	 * @return
	 */
	List<List<String>> read(InputStream inputStream, boolean isExcel2003);
	

	/**
	 * @description 数据读取
	 * @param wb
	 * @return
	 */
	List<List<String>> read(Workbook wb);

}
