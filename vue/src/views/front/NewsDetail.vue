<template>
  <div class="main-content">
    <div class="card">
      <div style="margin-bottom: 20px; font-size: 22px; font-weight: bold; text-align: center">{{news.title }}</div>
      <div style="color: #666; text-align: center">
        <span style="margin-right: 20px">发布时间：{{ news.time }}</span>
        <span>浏览量：<span style="color: red">{{ news.count }}</span></span>
      </div>
      <div style="margin: 30px 0; padding: 0 20px">
        <div class="w-e-text" style="line-height: 26px; text-indent: 2rem">
          <div v-html="news.content"></div>
        </div>
      </div>
    </div>

<!--    <div class="card" style="margin: 10px 0">-->
<!--      <div style="font-size: 20px; font-weight: bold; margin-bottom: 15px">评论 {{ commentCount }}</div>-->
<!--      <div style="margin-bottom: 20px">-->
<!--        <el-input type="textarea" placeholder="请输入评论内容" v-model="form.content"></el-input>-->
<!--        <div style="margin-top: 5px; text-align: right">-->
<!--          <el-button type="primary" @click="addComment">评论</el-button>-->
<!--        </div>-->
<!--      </div>-->

<!--      <div>-->
<!--        <div v-for="item in commentList" :key="item.id" style="display: flex; grid-gap: 15px; margin-bottom: 20px">-->
<!--          <img :src="item.avatar" alt="" style="width: 50px; height: 50px; border-radius: 50%">-->
<!--          <div style="flex: 1;">-->
<!--            <div style="margin-bottom: 5px; color: #666">{{ item.userName }}</div>-->
<!--            <div style="margin-bottom: 5px">{{ item.content }}</div>-->
<!--            <div style="font-size: 13px; color: #666; margin-bottom: 10px">-->
<!--              <span>{{ item.time }}</span>-->
<!--              <span style="margin: 0 20px; cursor: pointer" @click="handleReply(item)" :class="{ 'highLight' : item.showReply }">-->
<!--                <i class="el-icon-s-comment"></i>回复-->
<!--              </span>-->
<!--              <span style="cursor: pointer" @click="del(item.id)">-->
<!--                <i class="el-icon-delete"></i>删除-->
<!--              </span>-->
<!--            </div>-->
<!--            <div style="margin-bottom: 10px" v-if="item.showReply">-->
<!--              <el-input type="textarea" v-model="item.reply" placeholder="请输入回复内容"></el-input>-->
<!--              <div style="margin-top: 5px; text-align: right">-->
<!--                <el-button type="primary" size="mini">回复</el-button>-->
<!--              </div>-->
<!--            </div>-->

<!--            <div v-if="item.children.length">-->
<!--              <div v-for="sub in item.children" :key="sub.id" style="display: flex; grid-gap: 15px; margin-bottom: 20px">-->
<!--                <img :src="sub.avatar" alt="" style="width: 50px; height: 50px; border-radius: 50%">-->
<!--                <div style="flex: 1;">-->
<!--                  <div style="margin-bottom: 5px; color: #666">{{ sub.userName }}</div>-->
<!--                  <div style="margin-bottom: 5px">{{ sub.content }}</div>-->
<!--                  <div style="font-size: 13px; color: #666; margin-bottom: 10px">-->
<!--                    <span>{{ sub.time }}</span>-->
<!--                    <span style="margin: 0 20px; cursor: pointer" @click="handleReply(sub)" :class="{ 'highLight' : sub.showReply }">-->
<!--                      <i class="el-icon-s-comment"></i>回复-->
<!--                    </span>-->
<!--                    <span style="cursor: pointer" @click="del(sub.id)">-->
<!--                      <i class="el-icon-delete"></i>删除-->
<!--                    </span>-->
<!--                  </div>-->
<!--                  <div style="margin-bottom: 10px" v-if="sub.showReply">-->
<!--                    <el-input type="textarea" v-model="sub.reply" placeholder="请输入回复内容"></el-input>-->
<!--                    <div style="margin-top: 5px; text-align: right">-->
<!--                      <el-button type="primary" size="mini">回复</el-button>-->
<!--                    </div>-->
<!--                  </div>-->
<!--                </div>-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
<!--    </div>-->
    <Comment :fid ="id" module="news"/>
  </div>
</template>

<script>
import Comment from "@/components/Comment";
export default {
  name: "NewsDetail",
  components: {Comment},

  data() {
    return {
      id: this.$route.query.id,
      news: {},
      // commentCount: 0,
      // form: {},
      // commentList: []
    }
  },
  created() {
    this.$request.put('/news/updateCount/' + this.id).then(res => {
      this.load()
    })
    // this.loadComment()
  },
  methods: {
    // del(id) {   // 单个删除
    //   this.$confirm('您确定删除吗？', '确认删除', {type: "warning"}).then(response => {
    //     this.$request.delete('/comment/deepDelete/' + id).then(res => {
    //       if (res.code === '200') {   // 表示操作成功
    //         this.$message.success('操作成功')
    //         this.loadComment()
    //       } else {
    //         this.$message.error(res.msg)  // 弹出错误的信息
    //       }
    //     })
    //   }).catch(() => {
    //   })
    // },
    // handleReply(comment) {
    //   this.$set(comment, 'showReply',  !comment.showReply)
    // },
    // addComment() {
    //
    // },
    // loadComment() {
    //   this.$request.get('/comment/selectTree/' + this.id + '/news').then(res => {
    //     this.commentList = res.data || []
    //   })
    // },
    load() {
      this.$request.get('/news/selectById/' + this.id).then(res => {
        this.news = res.data || {}
      })
    }
  }
}
</script>

<style scoped>
.highLight {
  color: #2A60C9;
}
</style>