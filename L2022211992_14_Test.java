import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * 测试用例设计原则：
 * 1. 等价类划分：通过输入字符串不同的长度和内容划分测试用例。
 * 2. 边界值分析：测试字符串的最小长度和最大长度（4至12位）。
 * 3. 特殊情况：处理前导零和全零的输入，验证程序是否正确。
 */
public class L2022211992_14_Test {
    // Solution 实例
    Solution14 solution = new Solution14();

    /**
     * 测试目的：验证能够正确恢复合法的 IP 地址
     * 测试用例：给定字符串 "25525511135"
     * 预期结果：输出 ["255.255.11.135", "255.255.111.35"]
     */
    @Test
    public void testValidIpAddress1() {
        String input = "25525511135";
        List<String> result = solution.restoreIpAddresses(input);
        assertTrue(result.contains("255.255.11.135"));
        assertTrue(result.contains("255.255.111.35"));
        assertEquals(2, result.size());
    }

    /**
     * 测试目的：验证全为零的特殊情况
     * 测试用例：给定字符串 "0000"
     * 预期结果：输出 ["0.0.0.0"]
     */
    @Test
    public void testAllZeroes() {
        String input = "0000";
        List<String> result = solution.restoreIpAddresses(input);
        assertEquals(1, result.size());
        assertEquals("0.0.0.0", result.get(0));
    }

    /**
     * 测试目的：验证前导零的情况
     * 测试用例：给定字符串 "010010"
     * 预期结果：输出 ["0.10.0.10", "0.100.1.0"]
     */
    @Test
    public void testLeadingZero() {
        String input = "010010";
        List<String> result = solution.restoreIpAddresses(input);
        assertTrue(result.contains("0.10.0.10"));
        assertTrue(result.contains("0.100.1.0"));
        assertEquals(2, result.size());
    }

    /**
     * 测试目的：验证过长的输入，超过12个字符的情况
     * 测试用例：给定字符串 "1234567890123"
     * 预期结果：输出 []
     */
    @Test
    public void testTooLongInput() {
        String input = "1234567890123";
        List<String> result = solution.restoreIpAddresses(input);
        assertEquals(0, result.size());
    }

    /**
     * 测试目的：验证过短的输入，少于4个字符的情况
     * 测试用例：给定字符串 "123"
     * 预期结果：输出 []
     */
    @Test
    public void testTooShortInput() {
        String input = "123";
        List<String> result = solution.restoreIpAddresses(input);
        assertEquals(0, result.size());
    }

    /**
     * 测试目的：验证输入含有非法的段值（超过255）的情况
     * 测试用例：给定字符串 "256256256256"
     * 预期结果：输出 []
     */
    @Test
    public void testInvalidSegments() {
        String input = "256256256256";
        List<String> result = solution.restoreIpAddresses(input);
        assertEquals(0, result.size());
    }

    /**
     * 测试目的：验证复杂情况，给定字符串包含多个可能的IP地址
     * 测试用例：给定字符串 "101023"
     * 预期结果：输出 ["1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"]
     */
    @Test
    public void testComplexCase() {
        String input = "101023";
        List<String> result = solution.restoreIpAddresses(input);
        assertTrue(result.contains("1.0.10.23"));
        assertTrue(result.contains("1.0.102.3"));
        assertTrue(result.contains("10.1.0.23"));
        assertTrue(result.contains("10.10.2.3"));
        assertTrue(result.contains("101.0.2.3"));
        assertEquals(5, result.size());
    }
}
