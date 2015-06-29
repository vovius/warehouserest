package com.dio.warehouserest;

import java.util.List;

import com.dio.javamentoring.warehouse.StorageType;
import com.dio.javamentoring.warehouse.TVStorage;
import com.dio.javamentoring.warehouse.Warehouse;

public class InitWarehouse extends Warehouse {
	
	private static InitWarehouse initWarehouse;

	public InitWarehouse() throws Exception {
		super();
	}
	
	public static InitWarehouse initStorageFactory(String factoryFolder) throws Exception {
		initWarehouse = new InitWarehouse();
		initWarehouse.getManageService().createStorageFactory(factoryFolder);
		return initWarehouse;
	}
	
	public TVStorage initStorageByType(StorageType storageType) throws Exception {
		getManageService().initByStorageType(storageType);
		return getManageService().getStorage(storageType); 
	}
	
	public List<TVStorage> getStorages() throws Exception {
		return getManageService().getStorages();
	}
	
}
