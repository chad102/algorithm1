package net.power;

import java.lang.reflect.Array;
import java.util.*;

public class StringListImpl implements StringList{
    private int size = 0;
    private final String[] strings = new String[10];

    @Override
    public String add(String item) {
        if (strings[size] == null) {
            strings[size] = item;
            size++;
        }
        return strings[size - 1];
    }

    @Override
    public String add(int index, String item) {
        String[] stringsCopy = Arrays.copyOf(strings, strings.length + 1);
        stringsCopy[index] = item;
        size++;
        if ((index > strings.length-1) || (index > size)) {
            throw new RuntimeException();
        }
        return stringsCopy[index];

    }

    @Override
    public String set(int index, String item) {
        if ((index > strings.length-1) || (index > size)) {
            throw new RuntimeException();
        }
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].equals(item)) {
                strings[i] = null;
                size--;
                return item;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public String remove(int index) {
        if ((index > strings.length-1) || (index > size)) {
            throw new RuntimeException();
        }
        String deletedElement = strings[index];
        strings[index] = null;
        return deletedElement;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < strings.length - 1;) {
            if (strings[i].equals(item)) {
                return true;
            } else {
                i++;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < strings.length - 1; i++) {
            if ((strings[i] != null) && (strings[i].equals(item))) {
                return i;
                }
            }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = strings.length - 1; i >= 0 ; i--) {
            if ((strings[i] != null) && (strings[i].equals(item))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].equals(strings[index])) {
                return strings[index];
            }
        }
        throw new RuntimeException();
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new RuntimeException();
        }
        if (otherList == this) {
            return true;
        }
        if (!(otherList instanceof StringListImpl)) {
            return false;
        }
        StringListImpl otherList2 = (StringListImpl) otherList;
        if (this.size != otherList2.size) {
            return false;
        }
        for (int i = 0; i < strings.length - 1; i++) {
            if (!Objects.equals(strings[i], otherList2.strings[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i] != null) {
                strings[i] = null;
                size--;
            }
        }
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strings, strings.length);
    }
}
