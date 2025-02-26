package jerry;

import jerry.IntensitySegments;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * function test
 * @date 2023/11/22 11:14
 **/
class IntensitySegmentsTest {

    @Test
    void add_normal_1() {
        IntensitySegments segments = new IntensitySegments();
        assertEquals("[]", segments.toString());

        segments.add(10, 30, 1);
        assertEquals("[[10,1],[30,0]]", segments.toString());


        segments.add(20, 40, 1);
        assertEquals("[[10,1],[20,2],[30,1],[40,0]]", segments.toString());

        segments.add(10, 40, -2);
        assertEquals("[[10,-1],[20,0],[30,-1],[40,0]]", segments.toString());

    }

    @Test
    void add_normal_2() {

        IntensitySegments segments = new IntensitySegments();
        assertEquals("[]", segments.toString());

        segments.add(10, 30, 1);
        assertEquals("[[10,1],[30,0]]", segments.toString());


        segments.add(20, 40, 1);
        assertEquals("[[10,1],[20,2],[30,1],[40,0]]", segments.toString());

        segments.add(10, 40, -1);
        assertEquals("[[20,1],[30,0]]", segments.toString());

        segments.add(10, 40, -1);
        assertEquals("[[10,-1],[20,0][30,-1],[40,0]]", segments.toString());
    }

    @Test
    void set_normal_1() {
        IntensitySegments segments = new IntensitySegments();

        segments.set(10, 30, 1);
        assertEquals("[[10,1],[30,0]]", segments.toString());


        segments.set(20, 40, 1);
        assertEquals("[[10,1],[40,0]]", segments.toString());

    }

    @Test
    void testToString_normal_1() {
        IntensitySegments segments = new IntensitySegments();

        segments.set(10, 30, 1);
        assertEquals("[[10,1],[30,0]]", segments.toString());

    }
}