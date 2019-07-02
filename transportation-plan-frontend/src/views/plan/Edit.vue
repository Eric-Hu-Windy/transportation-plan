<template>
  <div class="wrapper">
    <el-form :ref="form.name" :model="plan" :rules="form.rules" label-width="80px" class="form">
      <el-form-item label="日期" prop="date">
        <el-date-picker type="date" placeholder="选择日期" v-model="plan.date" value-format="yyyy-MM-dd HH:mm:ss"></el-date-picker>
      </el-form-item>
      <el-form-item label="时间" prop="time">
        <el-input v-model="plan.time"></el-input>
      </el-form-item>
      <el-form-item label="省" prop="fromProvince">
        <el-input v-model="plan.fromProvince"></el-input>
      </el-form-item>
      <el-form-item label="市" prop="fromCity">
        <el-input v-model="plan.fromCity"></el-input>
      </el-form-item>
      <el-form-item label="详细地址" prop="fromAddress">
        <el-input v-model="plan.fromAddress"></el-input>
      </el-form-item>
      <el-form-item label="联系人" prop="contact">
        <el-input v-model="plan.contact"></el-input>
      </el-form-item>
      <el-form-item label="收货地址" prop="toAddress">
        <el-input v-model="plan.toAddress"></el-input>
      </el-form-item>
      <el-form-item label="货物数据" prop="goods">
        <el-input v-model="plan.goods"></el-input>
      </el-form-item>
      <el-form-item label="车队" prop="motorcade">
        <el-input v-model="plan.motorcade"></el-input>
      </el-form-item>
      <el-form-item label="成本" prop="cost">
        <el-input v-model="plan.cost"></el-input>
      </el-form-item>
      <el-form-item label="业务员" prop="salesman">
        <el-input v-model="plan.salesman"></el-input>
      </el-form-item>
      <el-form-item label="业务编号" prop="serialNo">
        <el-input v-model="plan.serialNo"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="save">保存</el-button>
        <el-button @click="goBack">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import PlanApi from '@/api/plan'

export default {
  name: 'planEdit',
  data: function () {
    return {
      id: this.$route.params.id,
      plan: {},
      form: {
        name: 'planForm',
        rules: {
          date: [
            { required: true, message: '请选择日期', trigger: 'blur' }
          ]
        }
      }
    }
  },
  mounted: function () {
    if (this.id) {
      PlanApi.getPlanById(this.id).then(resp => {
        if (resp.data) {
          this.plan = resp.data
        }
      })
    }
  },
  methods: {
    save () {
      this.$refs[this.form.name].validate(valid => {
        if (valid) {
          if (this.id) {
            PlanApi.updatePlan(this.id, this.plan).then(() => {
              this.gotoIndexPage()
            })
          } else {
            PlanApi.createPlan(this.plan).then(() => {
              this.gotoIndexPage()
            })
          }
        }
      })
    },
    gotoIndexPage () {
      this.$router.push({name: 'plan-index', query: { date: new Date(this.plan.date).toLocaleDateString() }})
    },
    goBack () {
      this.$router.go(-1)
    }
  }
}
</script>

<style lang="scss" scoped>
.wrapper {
  border: 1px solid #DCDFE6;
  padding: 20px;
}
.form {
  /deep/ .el-input__inner {
    width: 400px;
  }
}
</style>