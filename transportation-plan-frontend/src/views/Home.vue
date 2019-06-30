<template>
  <div class="wrapper">
    <el-calendar v-model="date"></el-calendar>
  </div>
</template>

<script>
export default {
  name: 'home',
  data: function () {
    return {
      date: '',
    };
  },
  watch: {
    date: function (newValue) {
      this.$router.push({name: 'plan-index', query: { date: newValue.toLocaleDateString() }})
    }
  }
};
</script>

<style lang="scss" scoped>
.wrapper {
  padding: 50px;
}
</style>
