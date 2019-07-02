package com.chuckie.transportationplan.service;

import com.chuckie.transportationplan.model.Plan;

import java.util.Date;
import java.util.List;

public interface PlanService {
    /** 新建Plan
     * @param plan 新建Plan数据
     */
    void create(Plan plan);

    /** 根据id更新指定的Plan
     * @param id 主键值
     * @param plan 修改后的Plan数据
     */
    void update(int id, Plan plan);

    /** 根据id删除Plan
     * @param id 要删除的Plan主键
     */
    void delete(int id);

    /** 查询所有Plan
     * @return Plan list
     */
    List<Plan> getAll();

    /** 查询某一天的Plan列表
     * @param date 计划日期
     * @return 符合条件的Plan
     */
    List<Plan> getByDate(Date date);

    /** 根据id查询Plan
     * @param id 要查询的Plan主键
     * @return 符合条件的Plan
     */
    Plan getById(int id);
}
