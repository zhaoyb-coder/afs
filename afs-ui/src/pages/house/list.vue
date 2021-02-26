<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-cascades"></i> 房屋列表
        </el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="container">
      <div class="handle-box">
        <el-button type="primary"
                   icon="el-icon-circle-plus-outline"
                   class="handle-del mr10"
                   @click="addHouseFun">增加</el-button>
        <el-button type="danger"
                   icon="el-icon-delete"
                   class="handle-del mr10"
                   @click="delAllSelection">批量删除</el-button>
        <el-input placeholder="房屋编号"
                  v-model="searchForm.houseName"
                  class="handle-input mr10"></el-input>
        <el-button type="primary"
                   icon="el-icon-search"
                   @click="getData">搜索</el-button>
      </div>
      <vxe-table border
                 ref="houseTable"
                 highlight-hover-row
                 resizable
                 align='center'
                 :loading="loading"
                 :data="tableData">
        <vxe-table-column type="checkbox"
                          width="60"></vxe-table-column>
        <vxe-table-column type="seq"
                          width="60"></vxe-table-column>
        <vxe-table-column field="houseName"
                          title="房屋编号"
                          width="100">
        </vxe-table-column>
        <vxe-table-column field="houseStat"
                          title="住宿情况"
                          width="100">
          <template slot-scope="scope">
            <el-tag :type="scope.row.houseStat=== '入住' ? 'success':'danger'">
              {{scope.row.houseStat}}
            </el-tag>
          </template>
        </vxe-table-column>
        <vxe-table-column field="houseNum"
                          title="入住人数"
                          width="100">
          <template slot-scope="scope">
            <el-button type="text"
                       @click="handlePersonList(scope.$index, scope.row)">{{scope.row.houseNum}}</el-button>
          </template>
        </vxe-table-column>
        <vxe-table-column title="当月是否缴费"
                          align="center"
                          width="150">
          <template slot-scope="scope">
            <el-tag :type="scope.row.isPay==='是'?'success':'danger'">
              {{scope.row.isPay}}
            </el-tag>
          </template>
        </vxe-table-column>
        <vxe-table-column title="操作">
          <template slot-scope="scope">
            <el-button type="text"
                       icon="el-icon-edit"
                       @click="editHouseFun(scope.row)">编辑</el-button>
            <el-button type="text"
                       icon="el-icon-goods"
                       @click="handleEdit(scope.$index, scope.row)">缴费</el-button>
            <el-button type="text"
                       icon="el-icon-circle-check"
                       @click="handleEdit(scope.$index, scope.row)">入住</el-button>
            <el-button type="text"
                       icon="el-icon-remove"
                       @click="handleEdit(scope.$index, scope.row)">退租</el-button>
            <el-button type="text"
                       icon="el-icon-view"
                       @click="handleMonthRent(scope.$index, scope.row)">缴费历史</el-button>
            <el-button type="text"
                       icon="el-icon-view"
                       @click="handleEdit(scope.$index, scope.row)">租赁历史</el-button>
            <el-button type="text"
                       icon="el-icon-delete"
                       class="red"
                       @click="handleDelete(scope.$index, scope.row.uid)">删除</el-button>
          </template>
        </vxe-table-column>
      </vxe-table>
      <vxe-pager background
                 size="small"
                 :loading="loading"
                 :current-page="searchForm.pageIndex"
                 :page-size="searchForm.pageSize"
                 :total="total"
                 :page-sizes="[10, 20, 100, {label: '大量数据', value: 1000}]"
                 :layouts="['PrevPage', 'JumpNumber', 'NextPage', 'FullJump', 'Sizes', 'Total']"
                 @page-change="handlePageChange">
      </vxe-pager>
    </div>
    <!-- 缴费历史弹框-->
    <rentHistory ref='rent'
                 :visibles='visibles' />
    <!-- 编辑房屋弹出框 -->
    <editHouse ref='editHouse'
               :visibles='visibles'
               v-on:reloadHouseList="getData"
               :houseinfo="houseInfo" />

  </div>
</template>

<script>
import { fetchData, delHouse } from '../../api/index';
import rentHistory from './rent-history.vue';
import editHouse from './edit-house.vue';
export default {
  name: 'basetable',
  components: {
    rentHistory,
    editHouse
  },
  data () {
    return {
      tableData: [],
      searchForm: {
        pageIndex: 1,
        pageSize: 20,
        houseName: ''
      },
      total: 0,
      loading: false,
      multipleSelection: [],
      delList: [],
      visibles: {
        rentHVisible: false,
        editHVisible: false,
        personVisible: false,
      },
      houseInfo: {
        houseName: '',
        uid: ''
      }
    };
  },
  created () {
    this.getData();
  },
  methods: {
    // 获取 easy-mock 的模拟数据
    getData () {
      this.loading = true
      fetchData(this.searchForm).then(res => {
        this.loading = false
        if (res.status === 200) {
          this.tableData = res.data.result.rows;
          this.total = res.data.result.total
        }
      });
    },
    // 触发搜索按钮
    handleSearch () {
      this.$set(this.query, 'pageIndex', 1);
      this.getData();
    },
    // 删除操作
    handleDelete (index, uid) {
      // 二次确认删除
      this.$confirm('确定要删除吗？', '提示', {
        type: 'warning'
      }).then(() => {
        delHouse({ uid: uid }).then(res => {
          if (res.status === 200) {
            this.$message.success('删除成功');
            this.getData()
          }
        });
      });
    },
    // 多选操作
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    // 新增房屋
    addHouseFun () {
      this.houseInfo = {}
      this.visibles.editHVisible = true
    },
    // 修改房屋
    editHouseFun (rows) {
      this.houseInfo.uid = rows.uid
      this.houseInfo.houseName = rows.houseName
      this.visibles.editHVisible = true
    },
    // 缴费历史
    handleMonthRent (index, row) {
      this.$refs.rent.queryData(row.uid);
      this.visibles.rentHVisible = true;
    },
    delAllSelection () {
      let selectRecords = this.$refs.houseTable.getCheckboxRecords()
      let uids = ''
      selectRecords.forEach(element => {
        uids = uids + element.uid + ','
      });
      this.handleDelete('', uids)
    },

    handlePersonList (index, row) {
      this.personVisible = true;
    },
    // 保存编辑
    saveEdit () {
      this.editVisible = false;
      this.$message.success(`修改第 ${this.idx + 1} 行成功`);
      this.$set(this.tableData, this.idx, this.form);
    },
    // 分页导航
    handlePageChange ({ currentPage, pageSize }) {
      this.searchForm.pageIndex = currentPage
      this.searchForm.pageSize = pageSize
      this.getData()
    }
  }
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 300px;
    display: inline-block;
}
.table {
    width: 100%;
    font-size: 14px;
}
.red {
    color: #ff0000;
}
.mr10 {
    margin-right: 10px;
}
.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
