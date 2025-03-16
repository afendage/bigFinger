package com.finger.desgin.composite;

import java.util.HashSet;
import java.util.Set;

public class TreeNode {

    private String name;

    private TreeNode parent;

    private Set<TreeNode> child = new HashSet<TreeNode>();

    public TreeNode(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public Set<TreeNode> getChild() {
        return child;
    }

    public void setChild(Set<TreeNode> child) {
        this.child = child;
    }

    /** 添加 子节点 */
    public void add(TreeNode node){
        child.add(node);
    }

    /** 删除 子节点*/
    public void remove(TreeNode node){
        child.remove(node);
    }

}
