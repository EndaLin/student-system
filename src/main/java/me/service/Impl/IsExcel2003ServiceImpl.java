package me.service.Impl;

import me.service.IIsExcel2003Service;

public class IsExcel2003ServiceImpl implements IIsExcel2003Service {
	public static boolean isExcel2003(String path) {
		return path.matches("^.+\\.(?i)(xls)$");
	}
}
