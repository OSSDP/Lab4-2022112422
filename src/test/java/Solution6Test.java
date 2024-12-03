import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * 测试类设计原则：
 * 本测试类遵循等价类划分原则。根据输入数据的不同类型，设计不同的测试用例，确保边界情况、常规情况以及特殊情况都能够覆盖。
 *
 * 测试目标：
 * 1. 验证算法对于常见情况的正确性；
 * 2. 验证边界情况的正确性；
 * 3. 验证特殊情况和极端数据的正确性。
 */
public class Solution6Test
{

    /**
     * 测试方法：验证普通案例，测试不同用户收藏的公司清单
     * 用到的测试用例：favoriteCompanies1, expected1
     */
    @Test
    public void testPeopleIndexesCase1() {
        Solution6 solution = new Solution6();

        // 示例 1
        List<List<String>> favoriteCompanies1 = new ArrayList<>();
        favoriteCompanies1.add(Arrays.asList("leetcode", "google", "facebook"));
        favoriteCompanies1.add(Arrays.asList("google", "microsoft"));
        favoriteCompanies1.add(Arrays.asList("google", "facebook"));
        favoriteCompanies1.add(Arrays.asList("google"));
        favoriteCompanies1.add(Arrays.asList("amazon"));
        List<Integer> expected1 = Arrays.asList(0, 1, 4);
        assertEquals(expected1, solution.peopleIndexes(favoriteCompanies1));
    }

    /**
     * 测试方法：验证包含子集关系的情况
     * 用到的测试用例：favoriteCompanies2, expected2
     */
    @Test
    public void testPeopleIndexesCase2() {
        Solution6 solution = new Solution6();

        // 示例 2
        List<List<String>> favoriteCompanies2 = new ArrayList<>();
        favoriteCompanies2.add(Arrays.asList("leetcode", "google", "facebook"));
        favoriteCompanies2.add(Arrays.asList("leetcode", "amazon"));
        favoriteCompanies2.add(Arrays.asList("facebook", "google"));
        List<Integer> expected2 = Arrays.asList(0, 1);
        assertEquals(expected2, solution.peopleIndexes(favoriteCompanies2));
    }

    /**
     * 测试方法：验证没有子集关系的情况
     * 用到的测试用例：favoriteCompanies3, expected3
     */
    @Test
    public void testPeopleIndexesCase3() {
        Solution6 solution = new Solution6();

        // 示例 3
        List<List<String>> favoriteCompanies3 = new ArrayList<>();
        favoriteCompanies3.add(Arrays.asList("leetcode"));
        favoriteCompanies3.add(Arrays.asList("google"));
        favoriteCompanies3.add(Arrays.asList("facebook"));
        favoriteCompanies3.add(Arrays.asList("amazon"));
        List<Integer> expected3 = Arrays.asList(0, 1, 2, 3);
        assertEquals(expected3, solution.peopleIndexes(favoriteCompanies3));
    }

    /**
     * 测试方法：验证当某些清单完全不包含任何子集时的情况
     * 用到的测试用例：favoriteCompanies4, expected4
     */
    @Test
    public void testPeopleIndexesCase4() {
        Solution6 solution = new Solution6();

        // 示例：没有任何用户的收藏是其他用户的子集
        List<List<String>> favoriteCompanies4 = new ArrayList<>();
        favoriteCompanies4.add(Arrays.asList("apple", "google", "facebook"));
        favoriteCompanies4.add(Arrays.asList("amazon", "microsoft"));
        favoriteCompanies4.add(Arrays.asList("twitter", "netflix"));
        favoriteCompanies4.add(Arrays.asList("linkedin", "snapchat"));
        favoriteCompanies4.add(Arrays.asList("yahoo", "dropbox"));
        List<Integer> expected4 = Arrays.asList(0, 1, 2, 3, 4);  // 每个用户的收藏都不是任何人的子集
        assertEquals(expected4, solution.peopleIndexes(favoriteCompanies4));
    }

    /**
     * 测试方法：验证只有一个用户的情况
     * 用到的测试用例：favoriteCompanies5, expected5
     */
    @Test
    public void testPeopleIndexesCase5() {
        Solution6 solution = new Solution6();

        // 示例：只有一个用户的情况
        List<List<String>> favoriteCompanies5 = new ArrayList<>();
        favoriteCompanies5.add(Arrays.asList("google", "microsoft"));
        List<Integer> expected5 = Arrays.asList(0);  // 唯一的用户其收藏是自己的子集
        assertEquals(expected5, solution.peopleIndexes(favoriteCompanies5));
    }

    /**
     * 测试方法：验证多个用户拥有完全相同收藏清单的情况
     * 用到的测试用例：favoriteCompanies6, expected6
     */
    @Test
    public void testPeopleIndexesCase6() {
        Solution6 solution = new Solution6();

        // 示例：多个用户收藏清单完全相同
        List<List<String>> favoriteCompanies6 = new ArrayList<>();
        favoriteCompanies6.add(Arrays.asList("google", "microsoft"));
        favoriteCompanies6.add(Arrays.asList("google", "microsoft"));
        favoriteCompanies6.add(Arrays.asList("google", "microsoft"));
        List<Integer> expected6 = Arrays.asList(0, 1, 2);  // 所有用户的收藏是相同的，没有子集关系
        assertEquals(expected6, solution.peopleIndexes(favoriteCompanies6));
    }
}
