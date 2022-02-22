package com.anuanu00.moviebooking.entity;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@ToString
@EqualsAndHashCode
public class Cinema {
    private final String id;
    private final String name;
    private final Map<String, Screen> screenMap;

    public Cinema(String id, String name) {
        this.id = id;
        this.name = name;
        this.screenMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addScreen(Screen screen) {
        screenMap.put(screen.getId(), screen);
    }

    public Screen getScreenById(String screenId) {
        return screenMap.get(screenId);
    }

    public Screen getScreenByName(String screenName) {
        return screenMap.values()
                .stream().filter(screen -> screenName.equals(screen.getName()))
                .findAny()
                .orElse(null);
    }
}
