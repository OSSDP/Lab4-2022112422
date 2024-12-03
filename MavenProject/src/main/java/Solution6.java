import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 *
 * 给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。
 *
 * 请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
 * 输出：[0,1,4]
 * 解释：
 * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
 * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
 * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
 * 示例 2：
 *
 * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
 * 输出：[0,1]
 * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
 * 示例 3：
 *
 * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
 * 输出：[0,1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= favoriteCompanies.length <= 100
 * 1 <= favoriteCompanies[i].length <= 500
 * 1 <= favoriteCompanies[i][j].length <= 20
 * favoriteCompanies[i] 中的所有字符串 各不相同 。
 * 用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
 * 所有字符串仅包含小写英文字母。
 *
 */
class Solution6
{
    Set<String>[] s = new Set[105];

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        List<Integer> ans = new ArrayList<>();

        // 初始化每个用户的收藏公司集合
        for (int i = 0; i < n; i++) {
            s[i] = new HashSet<>(favoriteCompanies.get(i));
        }

        // 遍历每个用户，检查是否是其他用户的子集
        for (int i = 0; i < n; i++) {
            boolean isSubset = false;
            for (int j = 0; j < n; j++) {
                if (i != j && check(i, j)) { // 只有在 i != j 且 i 是 j 的子集时才标记
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) {
                ans.add(i);  // 如果没有找到任何子集关系，添加到结果中
            }
        }

        return ans;
    }

    // 判断 favoriteCompanies[i] 是否是 favoriteCompanies[j] 的子集
    private boolean check(int x, int y) {
        if (s[x].size() >= s[y].size()) {  // 先排除 x 集合比 y 大的情况
            return false;
        }
        for (String com : s[x]) {  // 检查 x 是否是 y 的严格子集
            if (!s[y].contains(com)) {
                return false;
            }
        }
        return true;
    }
}

