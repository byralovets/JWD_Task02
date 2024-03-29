package by.ralovets.epamcourse.entity.appliance.impl;

import by.ralovets.epamcourse.entity.appliance.Appliance;
import by.ralovets.epamcourse.entity.appliance.ApplianceCreationException;

import java.util.HashMap;

import static by.ralovets.epamcourse.entity.appliance.criteria.SearchCriteria.TabletPC.*;
import static java.util.Objects.requireNonNull;

public class TabletPC implements Appliance {

    private static final long serialVersionUUID = -1L;

    private int batteryCapacity;
    private int displayInches;
    private int memoryROM;
    private int flashMemoryCapacity;
    private String color;

    public TabletPC(HashMap<String, String> params) throws ApplianceCreationException {
        try {
            batteryCapacity = Integer.parseInt(
                    requireNonNull(params.get(BATTERY_CAPACITY.toString())));
            displayInches = Integer.parseInt(
                    requireNonNull(params.get(DISPLAY_INCHES.toString())));
            memoryROM = Integer.parseInt(
                    requireNonNull(params.get(MEMORY_ROM.toString())));
            flashMemoryCapacity = Integer.parseInt(
                    requireNonNull(params.get(FLASH_MEMORY_CAPACITY.toString())));
            color = requireNonNull(params.get(COLOR.toString()));
        } catch (NumberFormatException | NullPointerException e) {
            throw new ApplianceCreationException(e.getMessage());
        }
    }

    public TabletPC() {
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(int displayInches) {
        this.displayInches = displayInches;
    }

    public int getMemoryROM() {
        return memoryROM;
    }

    public void setMemoryROM(int memoryROM) {
        this.memoryROM = memoryROM;
    }

    public int getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    public void setFlashMemoryCapacity(int flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {

        return getClass().getSimpleName().toUpperCase() +
                " : " +
                BATTERY_CAPACITY +
                "=" +
                batteryCapacity +
                ", " +
                DISPLAY_INCHES +
                "=" +
                displayInches +
                ", " +
                MEMORY_ROM +
                "=" +
                memoryROM +
                ", " +
                FLASH_MEMORY_CAPACITY +
                "=" +
                flashMemoryCapacity +
                ", " +
                COLOR +
                "=" +
                color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TabletPC tabletPC = (TabletPC) obj;
        return batteryCapacity == tabletPC.batteryCapacity
                && displayInches == tabletPC.displayInches
                && memoryROM == tabletPC.memoryROM
                && flashMemoryCapacity == tabletPC.flashMemoryCapacity
                && color.equals(tabletPC.color);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + batteryCapacity;
        result = prime * result + displayInches;
        result = prime * result + memoryROM;
        result = prime * result + flashMemoryCapacity;
        result = prime * result + ((color == null) ? 0 : color.hashCode());

        return result;
    }
}
