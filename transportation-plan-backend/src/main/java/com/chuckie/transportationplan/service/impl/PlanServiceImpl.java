package com.chuckie.transportationplan.service.impl;

import com.chuckie.transportationplan.mapper.PlanMapper;
import com.chuckie.transportationplan.model.Plan;
import com.chuckie.transportationplan.model.PlanExample;
import com.chuckie.transportationplan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Chuckie
 */
@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanMapper planMapper;

    @Override
    public void create(Plan plan) {
        planMapper.insertSelective(plan);
    }

    @Override
    public void update(int id, Plan plan) {
        plan.setId(id);
        plan.setUpdatedAt(new Date());
        planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public List<Plan> getAll() {
        PlanExample planExample = new PlanExample();
        planExample.createCriteria().andIsDeletedEqualTo(false);
        planExample.setOrderByClause("updated_at desc");
        return planMapper.selectByExample(planExample);
    }

    @Override
    public List<Plan> getByDate(Date date) {
        PlanExample planExample = new PlanExample();
        planExample.createCriteria().andIsDeletedEqualTo(false).andDateEqualTo(date);
        planExample.setOrderByClause("from_province desc, from_city desc");
        return planMapper.selectByExample(planExample);
    }

    @Override
    public Plan getById(int id) {
        return planMapper.selectByPrimaryKey(id);
    }
}
