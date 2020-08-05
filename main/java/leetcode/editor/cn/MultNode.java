package leetcode.editor.cn;

import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2020/8/5
 * @update:修改内容
 * @author: fesine
 * @updateTime:2020/8/5
 */
public class MultNode {
    public int val;
    public List<MultNode> children;

    public MultNode() {
    }

    public MultNode(int _val) {
        val = _val;
    }

    public MultNode(int _val, List<MultNode> _children) {
        val = _val;
        children = _children;
    }
}
