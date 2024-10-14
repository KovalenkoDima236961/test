package com.dimon.test.solution;

import com.dimon.test.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SolutionTest {
    @Autowired
    private Solution solution;

    @Test
    void testFindMaxPr() {
        // Arrange
        LinkedHashMap<String, Object> json = new LinkedHashMap<>();
        LinkedHashMap<String, Object> pearMap = new LinkedHashMap<>();
        pearMap.put("green", 2);
        pearMap.put("light green", 4);
        pearMap.put("dark green", 8);
        json.put("pear", pearMap);
        solution.findMaxPr(json);
        assertEquals(8, solution.maxValue);
    }
}
