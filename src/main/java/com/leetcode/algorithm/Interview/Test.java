package com.leetcode.algorithm.Interview;


import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args){
        ArrayList<Order> list = new ArrayList();
        list.add(new Order("001","13","xiaoming"));
        list.add(new Order("001","12","xiaobai"));
        list.add(new Order("003","14","xiaohei"));
        list.add(new Order("002","15","xiaozhang"));
        list.add(new Order("004","16","kangkang"));
        list.add(new Order("006","17","jan"));
        list.add(new Order("005","18","miche"));
        list.add(new Order("006","19","mingxiao"));

        //删除ID为001元素
        Iterator<Order> it= list.iterator();
        while(it.hasNext()){
            Order order = it.next();
            if("001".equals(order.getId())){
                it.remove();
            }
        }
        //根据名字排序
        list.sort(new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int result = 0;
                if(Integer.valueOf(o1.getId())>Integer.valueOf(o2.getId())){
                    result = 1;
                }else{
                    if(Integer.valueOf(o1.getId())==Integer.valueOf(o2.getId())){
                        if(Integer.valueOf(o1.getAge())>Integer.valueOf(o2.getAge())){
                            result = 1;
                        }else if (Integer.valueOf(o1.getAge())<Integer.valueOf(o2.getAge())){
                            result = -1;
                        }else{
                            result = 0;
                        }
                    }else{
                        result =-1;
                    }
                }
                return result;
            }
        });

        //过滤输出id为006的元素
        List<Order> sixIDList = list.stream().filter(order->"006".equals(order.getId())).collect(Collectors.toList());
    }
}
