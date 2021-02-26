<template>
  <el-dialog title="缴费历史"
             ref='r'
             :visible.sync="visibles.rentHVisible"
             width="50%">
    <el-steps :active="rentData.length"
              direction="vertical"
              finish-status="success">
      <el-step v-for="rent in rentData"
               v-bind:key="rent.uid">
        <span slot='title'>{{ rent.month  }}</span>
        <span slot='description'>
          房租：{{ rent.rent  }} <br>
          水费：{{ rent.waterRent  }} &nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
          电费：{{ rent.electricity }}&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
          网费：{{ rent.network  }}&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
          垃圾费：{{ rent.garbage  }} &nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
          其他：{{ rent.other  }} <br>
          缴费时间：{{ rent.createTime  }} <br>
        </span>
      </el-step>
    </el-steps>
  </el-dialog>
</template>
<script>
import { fetchMonthrent } from '../../api/index';
export default {
  props: {
    houseId: {
      type: String,
      default: ''
    },
    visibles: {
      type: Object,
      default: () => { }
    }
  },
  data () {
    return {
      rentData: [
      ]
    };
  },
  mounted () {

  },
  methods: {
    queryData (houseId) {
      fetchMonthrent({ houseId: houseId }).then(res => {
        if (res.status === 200) {
          this.rentData = res.data.result;
        }
      });
    }
  }

}
</script>
<style scoped>
</style>
