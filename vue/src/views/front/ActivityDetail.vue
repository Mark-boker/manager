<template>
  <div class="main-content">
    <div class="card">
      <div style="display: flex; grid-gap: 20px;">
        <img :src="activity.cover" alt="" style="width: 50%">
        <div style="flex: 1">
          <div style="font-size: 22px; margin-bottom: 40px">{{activity.name }}</div>
          <div class="item"><span style="color: #333">活动简介：</span>{{activity.descr }}</div>
          <div class="item"><span style="color: #333">活动日期：</span>{{ activity.start }} ~ {{ activity.end }}</div>
          <div class="item"><span style="color: #333">活动地址：</span>{{ activity.address }}</div>
          <div>
            <el-button size="medium" type="primary" v-if="activity.status === '未报名'" >开始报名</el-button>
            <el-button size="medium" type="primary" v-if="activity.status === '已报名'" disabled >已报名</el-button>
            <el-button size="medium" type="primary" v-if="activity.status === '未开始'" disabled >活动未开始</el-button>
            <el-button size="medium" type="primary" v-if="activity.status === '已结束'" disabled >活动已结束</el-button>
          </div>
        </div>
      </div>

      <div style="margin: 50px 0">
        <div style="margin-bottom: 30px; font-size: 22px; font-weight: bold; text-align: center">- 活动详情 -</div>
        <div class="w-e-text" style="line-height: 26px">
          <div v-html="activity.content"></div>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  name: "ActivityDetail",
  data() {
    return {
      id: this.$route.query.id,
      activity: {}
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      this.$request.get('/activity/selectById/' + this.id).then(res => {
        this.activity = res.data || {}
        this.activity.status = '未开始'  // 先默认一个数据测试一下
      })
    }
  }
}
</script>

<style scoped>
.item {
  color: #666; margin-bottom: 40px
}
</style>