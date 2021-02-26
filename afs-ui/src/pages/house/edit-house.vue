<template>
  <el-dialog title="房屋信息"
             ref='r'
             :visible.sync="visibles.editHVisible"
             :loading='loading'
             width="50%">
    <el-form ref="form"
             :model="houseinfo"
             label-width="70px">
      <el-form-item label="房屋编号">
        <el-input v-model="houseinfo.houseName"></el-input>
      </el-form-item>
    </el-form>
    <span slot="footer"
          class="dialog-footer">
      <el-button @click="cancel">取 消</el-button>
      <el-button type="primary"
                 :loading="loading"
                 @click="saveEdit">保存</el-button>
    </span>
  </el-dialog>
</template>
<script>
import { addHouse, editHouse } from '../../api/index';
export default {
  props: {
    visibles: {
      type: Object,
      default: () => {

      }
    },
    houseinfo: {
      type: Object,
      default: () => {
        houseName = '',
          uid = ''
      }
    }
  },
  data () {
    return {
      loading: false
    };
  },
  mounted () {

  },
  methods: {
    cancel () {
      this.visibles.editHVisible = false
    },
    saveEdit () {
      this.loading = true
      console.log(this.houseinfo.uid)
      if (this.houseinfo.uid === '' || this.houseinfo.uid === undefined) {
        addHouse(this.houseinfo).then(res => {
          if (res.status === 200) {
            this.loading = false
            this.$message({
              message: '添加成功',
              type: 'success'
            });
            // 关闭弹框
            this.visibles.editHVisible = false
            // 刷新父页面列表
            this.$emit("reloadHouseList")
          }
        });
      } else {
        editHouse(this.houseinfo).then(res => {
          if (res.status === 200) {
            this.loading = false
            this.$message({
              message: '更新成功',
              type: 'success'
            });
            // 关闭弹框
            this.visibles.editHVisible = false
            // 刷新父页面列表
            this.$emit("reloadHouseList")
          }
        });
      }

    }
  }

}
</script>
<style scoped>
</style>
