package Java.classes;

import java.util.*;

public final class ImmutableClass {
    private final int id;
    private final String name;
    private final List<String> dataList;

    public ImmutableClass(int id, String name, List<String> dataList) {
        this.id = id;
        this.name = name;
        this.dataList = dataList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getDataList() {
        return dataList;
    }
}
