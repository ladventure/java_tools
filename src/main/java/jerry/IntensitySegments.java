package jerry;

import java.util.*;

/**
 * The IntensitySegments class is used to manage and manipulate changes in intensity intervals.
 * It utilizes a TreeMap to store the starting points of intervals and their corresponding intensity values.
 * It supports increasing and setting the intensity values within specified intervals and can clean up redundant data.
 */
public class IntensitySegments {
    /**
     * Using treeMap to store the segments and intensity values. Because the treeMap is sorted and the key is unique,
     * it is easy to find the intensity value at any point.
     */
    private  final TreeMap<Integer, Integer> segments = new TreeMap<>();

    /**
     * Increase the specified intensity value within the specified interval [from, to).
     *
     * @param from   The starting point of the interval.
     * @param to     The ending point of the interval.
     * @param amount The intensity value to be increased.
     */
    public synchronized void add(int from, int to, int amount) {
        NavigableMap<Integer, Integer> subMap = getIntensitys(from, to);
        subMap.putIfAbsent(from, 0);
        if(segments.lastKey()<to) {
            segments.put(to, 0);
        }
        subMap.forEach( (k,v) -> segments.put(k, v + amount));
        cleanUp();
    }

    /**
     * Set the intensity value within the specified interval [from, to) to the specified value.
     *
     * @param from   The starting point of the interval.
     * @param to     The ending point of the interval.
     * @param amount The intensity value to be set.
     */
    public synchronized void set(int from, int to, int amount) {

        // clean up the range [from, to)
        NavigableMap<Integer, Integer> subMap = getIntensitys(from, to);
        // remove the intensity
        Set<Integer> removed = new HashSet<>(subMap.keySet());
        removed.forEach(segments::remove);

        // reset the intensity
        segments.put(from, amount);

        if (segments.lastKey() < to) {
            segments.put(to, 0);
        }
        cleanUp();
    }

    // get the intensity value
    private NavigableMap<Integer, Integer> getIntensitys(int from, int to) {
        NavigableMap<Integer, Integer> subMap = segments.subMap(from, true, to, false);

        if(!subMap.containsKey(from)) {
            Map.Entry<Integer,Integer>  fromEntry= segments.lowerEntry(from);
            if(fromEntry!=null) {
                subMap.put(from, fromEntry.getValue());
            }
        }
        return subMap;
    }

    /**
     * clean up redundant data
     */
    private void cleanUp() {

        // Clean continuously with the same intensity
        Iterator<Map.Entry<Integer, Integer>> iterator = segments.entrySet().iterator();
        Integer prevValue = null;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue().equals(prevValue)) {
                iterator.remove();
            } else {
                prevValue = entry.getValue();
            }
        }

        // Clean up zero at the beginning
        if (!segments.isEmpty() && segments.firstEntry().getValue() == 0) {
            segments.remove(segments.firstKey());
        }
        //  fill back zero at the end
        if (!segments.isEmpty() && segments.lastEntry().getValue() != 0) {
            segments.put(segments.lastKey() + 10, 0);
        }
    }

    /**
     * Convert the current intensity segmentation state into a string representation.
     *
     * @return A string representation of the intensity segmentation state.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        segments.forEach( (k, v) -> sb.append('[').append(k).append(",").append(v).append("],"));
        if(sb.charAt(sb.length()-1) == ',') {
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
}