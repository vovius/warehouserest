package com.dio.warehouserest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.dio.javamentoring.warehouse.*;

@Path("/storages")
public class RestStorageItem {
	
	@Autowired
	private InitWarehouse initWarehouse;
	
	public void setInitWarehouse(InitWarehouse initWarehouse) {
		this.initWarehouse = initWarehouse;
	}

	@Path("/{storageid}/{itemid}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public TV getStorageItem(@PathParam("storageid") String storageId, 
			                     @PathParam("itemid") String itemId) throws Exception {
		StorageType storageType = StorageType.valueOf(storageId);
		TVStorage storage = initWarehouse.getManageService().getStorage(storageType);
		int id = Integer.valueOf(itemId);
		return storage.getItemById(id);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestXml() {
		return "Hello";
	}
}
