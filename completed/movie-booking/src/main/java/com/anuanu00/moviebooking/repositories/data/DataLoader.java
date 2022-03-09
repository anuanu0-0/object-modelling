package com.anuanu00.moviebooking.repositories.data;

import com.anuanu00.moviebooking.exceptions.NoSuchDataException;

import java.util.HashMap;
import java.util.Map;

public class DataLoader {
    private static final Map<String, IData> dataMap = new HashMap<>();

    // Register the data into the hashmap
    public void register(String dataName, IData data) {
        dataMap.put(dataName, data);
    }

    // Get the registered Data
    private IData get(String dataName){
        return dataMap.get(dataName);
    }

    // Execute the registered data
    public void executeData(String dataName, String dataPath) throws NoSuchDataException {
        IData data = get(dataName);
        if(data == null) {
            throw new NoSuchDataException();
        }
        data.loadData(dataPath, ",");
    }
}
