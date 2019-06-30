<template>
  <div class="wrapper">
    <div class="filter-wrapper">
      <el-form :ref="form.name" inline class="form">
        <el-form-item label="日期：" prop="date">
          <el-date-picker type="date" placeholder="选择日期" v-model="date" value-format="yyyy/MM/dd"></el-date-picker>
        </el-form-item>
      </el-form>
    </div>
    <div class="table-wrapper">
      <div class="button-bar">
        <el-button @click="createPlan()" type="primary" size="small" class="create-btn" plain>新建</el-button>
      </div>
      <el-table :data="plans" stripe style="width: 100%">
        <el-table-column prop="time" label="时间"></el-table-column>
        <el-table-column label="提货地址">
          <el-table-column prop="fromProvince" label="省"></el-table-column>
          <el-table-column prop="fromCity" label="市"></el-table-column>
          <el-table-column prop="fromAddress" label="详细地址"></el-table-column>
        </el-table-column>
        <el-table-column prop="contact" label="联系人"></el-table-column>
        <el-table-column prop="toAddress" label="收货地址"></el-table-column>
        <el-table-column prop="goods" label="货物数据"></el-table-column>
        <el-table-column prop="motorcade" label="车队"></el-table-column>
        <el-table-column prop="cost" label="成本"></el-table-column>
        <el-table-column prop="salesman" label="业务员"></el-table-column>
        <el-table-column prop="serialNo" label="业务编号"></el-table-column>
        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button @click="editPlan(scope.row.id)" type="text" size="small">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import PlanApi from '@/api/plan';

export default {
  name: 'planIndex',
  data () {
    return {
      date: this.$route.query.date,
      plans: [],
      form: {
        name: 'filterForm'
      }
    };
  },
  mounted () {
    this.getPlans()
  },
  watch: {
    date (newVal) {
      this.$router.replace({name: 'plan-index', query: { date: newVal }})
      this.getPlans()
    }
  },
  methods: {
    getPlans () {
      PlanApi.getPlansByDate(this.date).then(resp => {
        if (resp.data) {
          this.plans = resp.data
        }
      })
    },
    createPlan () {
      this.$router.push({name: 'plan-create'})
    },
    editPlan (id) {
      this.$router.push({name: 'plan-edit', params: { id }})
    }
  }
};
</script>

<style lang="scss" scoped>
.wrapper {
  padding: 50px;

  .filter-wrapper {
    border: 1px solid #DCDFE6;
    padding: 10px;
    margin-bottom: 10px;

    .el-form-item {
      margin-bottom: 0;
    }
  }

  .table-wrapper {
    border: 1px solid #DCDFE6;
    padding: 10px;

    .button-bar {
      margin-bottom: 20px;
      overflow: hidden;

      .create-btn {
        float: right;
      }
    }
  }
}
</style>

