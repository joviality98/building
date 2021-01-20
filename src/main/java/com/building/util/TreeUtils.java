package com.building.util;

import com.building.entity.vo.MenuTreeVO;
import com.building.entity.vo.MenuVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeUtils {
    /**
     * 所有待用"菜单"
     */
    private static List<MenuTreeVO> all = null;

    /**
     * 转换为树形
     * @param list 所有节点
     * @return 转换后的树结构菜单
     */
    public static List<MenuTreeVO> toTree(List<MenuVo> list) {
        HashMap<String, MenuTreeVO> map = new HashMap<>();
        List<MenuTreeVO> trees = new ArrayList<>();
        list.stream()
                .peek(type -> {
                    MenuTreeVO node = new MenuTreeVO();
                    node.setId(type.getId());
                    node.setName(type.getName());
                    node.setComponent(type.getComponent());
                    node.setParentId(type.getParentId());
                    node.setSort(type.getSort());
                    node.setIcon(type.getIcon());
                    map.put(type.getId(), node);
                })
                .forEach(type -> {
                    String pid = type.getParentId();
                    String id = type.getId();
                    MenuTreeVO pNode = map.get(pid);
                    MenuTreeVO cNode = map.get(id);
                    //判断map是否存在此pid
                    if (map.containsKey(pid)) {
                        //存在，则将该pid的子节点取出来
                        List<MenuVo> children = pNode.getChildren();
                        if (children == null) { //如果子节点为空，初始化子节点
                            children = new ArrayList<>();
                            pNode.setChildren(children);
                        }
                        //将此子节点放入对应父节点下
                        children.add(cNode);
                    } else {
                        trees.add(cNode);
                    }
                });
        return trees;
    }
    /**
     * * 解析树形数据
     *
     * @param topId
     * @param entityList
     * @return
     */
    public static <E extends TreeEntity<E>> List<E> getTreeList(String topId, List<E> entityList) {
        List<E> resultList = new ArrayList<>();
        // 获取顶层元素集合
        String parentId;
        for (E entity : entityList) {
            parentId = entity.getParentId();
            if (parentId == null || topId.equals(parentId)) {
                resultList.add(entity);
            }
        }
        // 获取每个顶层元素的子数据集合
        for (E entity : resultList) {
            entity.setChildren(getSubList(entity.getId(), entityList));
        }
        return resultList;
    }

    /**
     * * 获取子数据集合
     *
     * @param id
     * @param entityList
     * @return
     */
    private static <E extends TreeEntity<E>> List<E> getSubList(String id, List<E> entityList) {
        List<E> childList = new ArrayList<>();
        String parentId;
        // 子集的直接子对象
        for (E entity : entityList) {
            parentId = entity.getParentId();
            if (id.equals(parentId)) {
                childList.add(entity);
            }
        }
        // 子集的间接子对象
        for (E entity : childList) {
            entity.setChildren(getSubList(entity.getId(), entityList));
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

}
