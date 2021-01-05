package com.building.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 分页工具类
 * page 当前页
 * prePage 上一页
 * nextPage 下一页
 * pages 总页数
 * count 信息总数
 * pageList 显示可选页数
 */
public class PageUtils {

    private static String pageNum = "4";
    private static String pageSize = "5";

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public static Map<String,Object> pageHandler(String page, String count){
        Integer tempPage = Integer.parseInt(page);
        Integer tempCount = Integer.parseInt(count);

        Map<String,Object> map = new HashMap<String,Object>();

        Integer prePage = prePageHandler(tempPage);
        Integer nextPage = nextPageHandler(tempPage,tempCount);
        List<Integer> pageList = pageHandler(tempPage,tempCount);
        Integer pages = pagesCount(tempCount);

        map.put("page",page);
        map.put("prePage",prePage);
        map.put("nextPage",nextPage);
        map.put("pages",pages);
        map.put("count",tempCount);
        map.put("pageList",pageList);

        return map;
    }

    /**
     * 上一页
     * @param page
     * @return
     */
    private static Integer prePageHandler(Integer page) {
        Integer prePage;
        if(page-1 == 0){
            prePage = 1;
        }else{
            prePage = page - 1;
        }
        return prePage;
    }

    /**
     * 下一页
     * @param page
     * @return
     */
    private static Integer nextPageHandler(Integer page,Integer count) {

        Integer pageSize = Integer.parseInt(PageUtils.pageSize);
        Integer pages = pagesCount(count);

        Integer nextPage;
        if(page == pages){
            nextPage = pages;
        }else{
            nextPage = page + 1;
        }
        return nextPage;
    }

    /**
     * 页码总数
     * @param count
     * @return
     */
    private static Integer pagesCount(Integer count) {

        Integer pageSize = Integer.parseInt(PageUtils.pageSize);
        Integer pages = (count % pageSize == 0)?(count/pageSize):(count/pageSize+1);
        return pages;
    }

    /**
     * 显示出来的页码数
     * @param page
     * @param count
     * @return
     */
    public static List<Integer> pageHandler(Integer page,Integer count){

        List<Integer> list = new LinkedList<Integer>();
        Integer pageNum = Integer.parseInt(PageUtils.pageNum);

        Integer pages = pagesCount(count);
        Integer minPages = (page - pageNum > 0)?(page - pageNum):1;
        Integer maxPages = (page + pageNum > pages)?pages:(page + pageNum);

        for (int i = minPages;i <= maxPages;i++){
            list.add(i);
        }
        return list;
    }
}
